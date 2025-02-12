英語記載の後に日本語記載を行っています。

# IntelliJGithubLinkCopyPlugin
This is a plugin that extends the functionality of `Copy Link to Github Repository` in IntelliJ.  
Currently, this plugin requires installation via [LivePlugin](https://plugins.jetbrains.com/plugin/7282-liveplugin).

---

## **Installing LivePlugin**
1. Follow the instructions in the [LivePlugin README](https://github.com/dkandalov/live-plugin?tab=readme-ov-file#liveplugin) to install it from the JetBrains Marketplace.
2. Open the **Live Plugin** menu in IntelliJ IDEA and create a new plugin.
3. Select **"Kotlin Plugin"**.
4. Enter any desired plugin name.
   - <img width="334" alt="1" src="https://github.com/user-attachments/assets/92a29d03-6641-4333-9f0c-052670987579" />
6. Replace the content of `plugin.kts` with the corresponding plugin code from this project.
   - <img width="690" alt="2" src="https://github.com/user-attachments/assets/25bb36f2-e36d-4306-b2e1-6280f8a6fe5c" />
8. Run **"Run {Plugin Name} Plugin"**.
   - <img width="293" alt="3" src="https://github.com/user-attachments/assets/75be6f10-b8ee-4ca3-a08f-a796b27fdc2d" />

---

## **markdownLinkCopier**
<img width="270" alt="4" src="https://github.com/user-attachments/assets/30c518c9-f735-434e-9c8b-f5943f29a982" />

Installing this plugin adds the **`(Markdown) Copy Link to Github Repository`** feature.  
It allows you to open a Java or Kotlin file managed in a GitHub repository and execute the feature from the right-click menu.  
This function copies the selected code's GitHub link in the following Markdown format to the clipboard:
```
[{ClassName}#{MethodName}#L{LineNumber}](GitHub Repository URL)
```

---

## **Examples**
Below are examples of running this feature on sample files provided in this project.

### Running with the cursor on line 9 of the `main` method in `SampleJavaClass`
[SampleJavaClass#main#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L9)

```markdown
[SampleJavaClass#main#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L9)
```

### Running after selecting multiple lines (lines 8-9)
[SampleJavaClass#main#L8-L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L8-L9)
``` markdown
[SampleJavaClass#main#L8-L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L8-L9)
```

### ### Running with the cursor on line 9 of the `printMessage` method in `SampleKotlinClass`
[SampleKotlinClass#printMessage#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L9)
``` markdown
[SampleKotlinClass#printMessage#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L9)
```

### When using a top-level function
If the function does not belong to a class (a top-level function), the filename is used in the format:
```
[{FileName}#{MethodName}#L{LineNumber}](GitHub Repository URL)
```
[SampleKotlinClass#main#L3](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L3)
``` markdown
[SampleKotlinClass#main#L3](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L3)
```

---

# IntelliJGithubLinkCopyPlugin
IntelliJ における `Copy Link to Github Repository` の機能を拡張したプラグインです。  
本プラグインは現在 [LivePlugin](https://plugins.jetbrains.com/plugin/7282-liveplugin) によるインストールが必要です。

---

## **LivePlugin のインストール**
1. [LivePlugin のREADME](https://github.com/dkandalov/live-plugin?tab=readme-ov-file#liveplugin) に従い、インストールを行ってください。
2. IntelliJ IDEA の「Live Plugin」メニューを開き、新しいプラグインを作成。
3. 「Kotlin Plugin」を選択。
5. 任意のプラグイン名を入力。
   - <img width="334" alt="1" src="https://github.com/user-attachments/assets/92a29d03-6641-4333-9f0c-052670987579" />
7. `plugin.kts` の内容を本プロジェクトの対象プラグインのコードに置き換える。
　　- <img width="690" alt="2" src="https://github.com/user-attachments/assets/25bb36f2-e36d-4306-b2e1-6280f8a6fe5c" />
9. 「Run {プラグイン名} Plugin」を実行。
   - <img width="293" alt="3" src="https://github.com/user-attachments/assets/75be6f10-b8ee-4ca3-a08f-a796b27fdc2d" />

---

## **markdownLinkCopier**
<img width="270" alt="4" src="https://github.com/user-attachments/assets/30c518c9-f735-434e-9c8b-f5943f29a982" />

プラグインをインストールすることで **`(Markdown) Copy Link to Github Repository`** という機能が追加されます。  
github リポジトリで管理している java, kotlin を開き、右クリックメニューから本機能を実行可能です。
この機能は以下の Markdown 形式でクリップボードにコピーします。

```
[{クラス名}#{メソッド名}#L{行番号}](Github Repository URL)
```

## 実例
以下は本プロジェクトに配置したサンプルファイルに対して実行した例です。

### SampleJavaClassクラス、mainメソッドの9行目にカーソルを合わせて実行
[SampleJavaClass#main#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L9)

``` markdown
[SampleJavaClass#main#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L9)
```

### 複数行を選択して実行
[SampleJavaClass#main#L8-L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L8-L9)
``` markdown
[SampleJavaClass#main#L8-L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleJavaClass.java#L8-L9)
```

### SampleKotlinClassクラス、printMessageメソッドの9行目にカーソルを合わせて実行
[SampleKotlinClass#printMessage#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L9)
``` markdown
[SampleKotlinClass#printMessage#L9](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L9)
```

### トップレベル関数の場合
クラスに属していないトップレベル関数の場合は、以下のようにファイル名を使用したフォーマットでコピーされます。
```
[{ファイル名}#{メソッド名}#L{行番号}](Github Repository URL)
```
の形式でコピーします。

[SampleKotlinClass#main#L3](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L3)
``` markdown
[SampleKotlinClass#main#L3](https://github.com/kihiro1031/IntelliJGithubLinkCopyPlugin/blob/311724aa103d7f4cbcd9f9ffcbb9855dc36b9158/markdownLinkCopier/samples/SampleKotlinClass.kt#L3)
```
