package Praktika.Praktiak11.Adapter;

import java.util.ArrayList;

public class StackAdapter<T> implements Interface<T> {
    private ArrayList<T> stack = new ArrayList<T>();

    public boolean empty() {
        return stack.isEmpty();
    }

    public T push(T item) {
        stack.add(item);
        return item;
    }

    public T pop() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T item : stack) {
            sb.append(item + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
