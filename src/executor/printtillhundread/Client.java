package executor.printtillhundread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            if(i==5 || i==12){
                System.out.println("Debug....");
            }
            PrintNumberTask pnt = new PrintNumberTask(i);
            executor.submit(pnt);
        }
    }
}
