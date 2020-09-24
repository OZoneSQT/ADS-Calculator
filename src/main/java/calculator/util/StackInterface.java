package calculator.util;

public interface StackInterface<T> {
    /**
     * Add element to queue
     * @param element
     */
    void enqueue(T element);

    /**
     * Return and remove, last added element from queue
     * @return
     */
    T dequeue();

    /**
     * Return size of queue
     * @return
     */
    int size();

    /**
     * Return the value true if queue is empty, else return false
     * @return
     */
    boolean isEmpty();
}
