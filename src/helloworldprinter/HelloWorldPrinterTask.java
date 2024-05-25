package helloworldprinter;

public class HelloWorldPrinterTask implements Runnable {
    @Override
    public void run() {
        /**
         * your code logic should go here.
         */
        System.out.println("Inside Run method for Printing with diff thread: " + Thread.currentThread().getName());
        doSomething();
    }

    private void doSomething() {
        System.out.println("Hello world!!!!");
    }
}
