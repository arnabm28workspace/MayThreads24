package helloworldprinter;

public class Client {
    public static void main(String[] args) {
        /**
         * Print HelloWorld as part of diff thread than main
         */

        System.out.println("In my main method, thread name is: "+ Thread.currentThread().getName());

        HelloWorldPrinterTask task = new HelloWorldPrinterTask();
        Thread t= new Thread(task);
        // create a new thread and execute this task
        // as part of the thread

        t.start();
        // if you want to wait.. you can wait here...
        System.out.println("bye....");
    }
}
