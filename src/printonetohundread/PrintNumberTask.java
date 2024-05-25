package printonetohundread;

public class PrintNumberTask implements Runnable {
    public int var;

    public PrintNumberTask(int var) {
        this.var = var;
    }

    @Override
    public void run() {
        System.out.println("Printing Number: " + this.var + "" +
                " Thread Name is: " + Thread.currentThread().getName());
    }
}
