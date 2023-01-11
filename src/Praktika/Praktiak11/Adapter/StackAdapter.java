package Praktika.Praktiak11.Adapter;

import java.util.ArrayList;

public class StackAdapter<T> implements Interface<T> {
    private ArrayList<T> stack = new ArrayList<T>();

    // Returns true if this stack contains no elements.
    public boolean empty() {
        return stack.isEmpty();
    }

    // Pushes an item onto the top of this stack.
    public T push(T item) {
        stack.add(item);
        return item;
    }

    // Removes the object at the top of this stack and returns that object as the value of this function.
    public T pop() {
        if (empty()) {
            // throw new EmptyStackException(); if stack is empty
            throw new RuntimeException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    // Looks at the object at the top of this stack without removing it from the stack.
    public T peek() {
        if (empty()) {
            // throw new EmptyStackException(); if stack is empty
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    //for printing out the stack
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
