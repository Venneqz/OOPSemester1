package Praktika.Praktiak11.Adapter;

public interface Interface<T> {
    boolean empty();
    T push(T item);
    T pop();
    T peek();
}
