package Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {
    private T[] items;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        items = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == items.length) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % items.length;
        items[rear] = element;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = items[front];
        front = (front + 1) % items.length;
        size--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return items[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}