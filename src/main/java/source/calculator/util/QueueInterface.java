package source.calculator.util;

public interface QueueInterface<T> {

    /**
     * Add element to queue
     * @param element
     */
    void enqueue(T element);

    /**
     * Return and remove, first added element from queue
     * @return
     */
    T dequeue();

    /**
     * Return and remove, first added element from queue
     * @return
     */
    T first();

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

    /**
     * Return index number of an element
     * @param element
     * @return
     */
    int indexOf(T element);

    /**
     * Check if queue holds element
     * @param element
     * @return
     */
    boolean contains(T element);
}
