// depends-on-plugin Git4Idea
// depends-on-plugin com.intellij.java

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiMethod
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.vcsUtil.VcsUtil
import git4idea.GitUtil
import git4idea.repo.GitRepositoryManager
import liveplugin.show
import java.awt.datatransfer.StringSelection

class CopyGithubLinkAction : AnAction("(Markdown) Copy Link to Github Repository") {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project ?: return
        val file = event.getData(CommonDataKeys.VIRTUAL_FILE) ?: return
        val editor = FileEditorManager.getInstance(project).selectedTextEditor ?: return

        val caret = editor.caretModel.offset
        val methodName = getMethodNameAtCaret(project, file, caret)
        val className = getClassNameAtCaret(project, file, caret)
        val selectionLines = SelectionLines(
            (editor.document.getLineNumber(editor.selectionModel.selectionStart) + 1),
            (editor.document.getLineNumber(editor.selectionModel.selectionEnd) + 1)
        )
        getGitHubUrl(project, file, selectionLines) { githubUrl ->
            if (githubUrl.isNotEmpty()) {
                val displayString = displayString(className, methodName, selectionLines)
                val mdLink = convertToMarkdownLinkFormat(displayString, githubUrl)
                CopyPasteManager.getInstance().setContents(StringSelection(mdLink))
            } else {
                show("Failed to retrieve GitHub URL")
            }
        }
    }

    private fun displayString(className: String, methodName: String, selectionLines: SelectionLines): String {
        return if (methodName.isNotBlank())
            "$className#$methodName${selectionLines.rangeString()}"
        else "$className${selectionLines.rangeString()}"
    }

    private fun convertToMarkdownLinkFormat(displayString: String, githubUrl: String): String {
        return "[$displayString]($githubUrl)"
    }

    private fun getMethodNameAtCaret(project: Project, file: VirtualFile, caretOffset: Int): String {
        val psiFile = PsiManager.getInstance(project).findFile(file) ?: return ""
        val elementAtCaret = psiFile.findElementAt(caretOffset) ?: return ""
        return PsiTreeUtil.getParentOfType(elementAtCaret, PsiMethod::class.java)?.name ?: ""
    }

    private fun getClassNameAtCaret(project: Project, file: VirtualFile, caretOffset: Int): String {
        val psiFile = PsiManager.getInstance(project).findFile(file) ?: return file.nameWithoutExtension
        val elementAtCaret = psiFile.findElementAt(caretOffset) ?: return file.nameWithoutExtension
        return PsiTreeUtil.getParentOfType(elementAtCaret, PsiClass::class.java)?.name ?: file.nameWithoutExtension
    }

    private fun getGitHubUrl(project: Project, file: VirtualFile, selectionLines: SelectionLines, callback: (String) -> Unit) {
        ProgressManager.getInstance().run(object : Task.Backgroundable(project, "Fetching GitHub URL", false) {
            override fun run(indicator: com.intellij.openapi.progress.ProgressIndicator) {
                val repositoryManager = GitRepositoryManager.getInstance(project)
                val repository = repositoryManager.getRepositoryForFileQuick(file)
                    ?: repositoryManager.getRepositoryForRoot(project.baseDir)
                if (repository == null) {
                    callback("")
                    return
                }

                val remoteUrl = repository.remotes.firstOrNull()?.firstUrl ?: return
                val branch = repository.currentBranchName ?: "main"
                val relativePath = GitUtil.getRelativePath(repository.root.path, VcsUtil.getFilePath(file)) ?: return

                val githubUrl = remoteUrl.replace(".git", "") + "/blob/$branch/$relativePath${selectionLines.rangeString()}"
                callback(githubUrl)
            }
        })
    }
}

class SelectionLines(private val startLine: Int, private val endLine: Int) {
    fun rangeString(): String {
        return if (startLine != endLine) "#L$startLine-L$endLine" else "#L$startLine"
    }
}

val actionManager = ActionManager.getInstance()
val groupId = "CopyGithubLinkAction"
val actionId = "(Markdown) Copy Link to Github Repository"

// removeAction
actionManager.getAction(actionId)?.let { actionManager.unregisterAction(actionId) }

// addAction
val action = CopyGithubLinkAction()
actionManager.registerAction(actionId, action)
(actionManager.getAction(groupId) as? DefaultActionGroup)?.add(action)
