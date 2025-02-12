public class SampleJavaClass {

    public void printMessage(String message) {
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        SampleJavaClass sample = new SampleJavaClass();
        sample.printMessage("Hello!");
    }
}
