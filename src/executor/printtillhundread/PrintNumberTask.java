package executor.printtillhundread;

public class PrintNumberTask implements Runnable {
    public int var;

    public PrintNumberTask(int var) {
        this.var = var;
    }

    @Override
    public void run() {
        System.out.println("Printing " + this.var + ". Printed by thread: " + Thread.currentThread().getName());
    }
}
