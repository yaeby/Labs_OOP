package Queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListQueue<T> implements Queue<T> {
    private final ArrayList<T> items;
    private int front;

    public ListQueue() {
        items = new ArrayList<>();
        front = 0;
    }

    @Override
    public void enqueue(T item) {
        items.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return items.remove(front);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return items.get(front);
    }

    @Override
    public boolean isEmpty() {
        return front == items.size();
    }

    @Override
    public int size() {
        return items.size() - front;
    }
}
