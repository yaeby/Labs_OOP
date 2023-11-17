package Stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListStack<T> implements Stack<T> {
    private final ArrayList<T> items = new ArrayList<>();

    @Override
    public void push(T item) {
        items.add(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }
}
