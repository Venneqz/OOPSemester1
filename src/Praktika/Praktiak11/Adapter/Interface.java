package Praktika.Praktiak11.Adapter;

public interface Interface<T> {
    //interface for the adapter
    boolean empty();
    T push(T item);
    T pop();
    T peek();
}
