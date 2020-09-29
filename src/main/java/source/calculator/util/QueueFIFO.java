package source.calculator.util;

public class QueueFIFO<T> implements QueueInterface<T> {

    private T[] integerQueue;
    private int  count, capacity;

    public QueueFIFO(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(T element) throws IllegalArgumentException, IllegalStateException {
        if(integerQueue == null) {
            integerQueue = (T[])(new Object[capacity]);
        }
        if(element == null) {
            throw new IllegalArgumentException("Null is not allowed");
        } else if(count == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        integerQueue[count] = element;
        count++;
    }

    public T dequeue() throws IllegalStateException {
        if(count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T genericQueue = integerQueue[0];
        for (int i = 1; i < count; i++) {
            integerQueue[i-1] = integerQueue[i];
        }
        count--;
        return genericQueue;
    }

    public T first() throws IllegalStateException {
        if(count == 0) throw new IllegalStateException("Queue is empty");
        return integerQueue[0];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int indexOf(T element) {
        if(element == null) {
            for (int i = 0; i < count; i++) {
                if (integerQueue[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (element.equals(integerQueue[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        if(element == null) return false;
        for (T t : integerQueue) {
            if(element.equals(t)) return true;
        }
        return false;
    }

}
