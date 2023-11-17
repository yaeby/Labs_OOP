package Stack;

import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {
    private T[] items;
    private int top;

    public ArrayStack(int capacity) {
        items = (T[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T item) {
        if (top == items.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        items[++top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        items = removeTheElement(items, top--);
        return items[top];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    public T[] removeTheElement(T[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) return arr;

        T[] copyArray = (T[]) new Object[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) continue;

            copyArray[k++] = arr[i];
        }
        return copyArray;
    }
}
