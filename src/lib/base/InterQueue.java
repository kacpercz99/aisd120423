package lib.base;

public interface InterQueue<E> {
    boolean put(E element);
    E top();
    E get();
    boolean pop();
    boolean isEmpty();
    int size();
}
