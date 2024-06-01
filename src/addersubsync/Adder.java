package addersubsync;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count) {
            for (int i = 0; i < 100000; i++) {
                // whenever there is a critical section in my code, take sync on object.
                count.value += 1;
            }
        }

    }
}
