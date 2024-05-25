package printonetohundread;

public class Client {

    public static void main(String[] args) {
        /**
         * Print 1 - 100 ; each as part of a new thread
         */

        for (int i=1;i<=100;i++){
            PrintNumberTask p = new PrintNumberTask(i);
            Thread t = new Thread(p);
            t.start();
        }

    }
}
