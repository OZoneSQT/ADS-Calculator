package source.calculator.util;

import java.util.ArrayDeque;

public class StackLIFO<T> implements StackInterface<T> {
    private ArrayDeque<T> stack;
    private int  count;

    public StackLIFO() {
    }

    public void enqueue(T element) throws IllegalArgumentException, IllegalStateException {
        if(stack == null) {
            stack = new ArrayDeque<>();
        }

        if(element == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }

        stack.addLast(element);
        count++;
    }

    public T dequeue() throws IllegalStateException {
        if(count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T result = stack.getLast();
        stack.removeLast();
        return result;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        boolean result = false;
        if (count == 0) {
            result = true;
        }
        return result;
    }

}
