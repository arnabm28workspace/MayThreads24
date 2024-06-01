package syncmethods;

public class Count {
    private int value = 0;

    public int getValue() {
        return this.value;
    }

    public synchronized void incrementValue(int offset) {
        this.value += offset;
    }

}
