/**
 * ID 303080097
 */
/**
 * The class is responsible for the constructors and
 * actions related to a Counter object.
 */
public class Counter {
    private int counter;

    /**
     * constructor new Counter.
     * @param counter the initial number of this counter.
     */
    public Counter(int counter) {
        this.counter = counter;
    }
    /**
     * add number to current count.
     * @param number The number we will add this counter.
     */
    void increase(int number) {
        this.counter = this.counter + number;
    }
    /**
     * subtract number from current count.
     * @param number The number we will subtract from this counter.
     */
    void decrease(int number) {
        this.counter = this.counter - number;
    }
    /**
     * get current count.
     * @return current count.
     */
    int getValue() {
        return this.counter;
    }
}