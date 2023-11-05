package Collidables;

/**
 * The type Counter.
 */
public class Counter {
    private int number;

    /**
     * Instantiates a new Counter.
     *
     * @param start the start
     */
    public Counter(int start) {
        this.number = start;
    }

    /**
     * Increase the counter.
     *
     * @param number the number we add
     */
    public void increase(int number) {
        this.number += number;
    }

    /**
     * Decrease the counter.
     *
     * @param number the number we decrease
     */
    public void decrease(int number) {
        this.number -= number;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return this.number;
    }
}
