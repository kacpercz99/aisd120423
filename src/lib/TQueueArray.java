package lib;

import lib.base.InterQueueIterableArray;

import java.util.Iterator;

public class TQueueArray<E> implements InterQueueIterableArray<E> {
    private int head;
    private int tail;
    private E[] arrayBuffor;
    private int count;
    private int maxCapacity;
    public static int DEFAULT_CAPACITY = 16;
    public static int DEFAULT_MINIMAL_CAPACITY = 4;


    public TQueueArray(int maxSize) {
        if (maxSize < DEFAULT_MINIMAL_CAPACITY) {
            this.maxCapacity = DEFAULT_CAPACITY;
        } else {
            this.maxCapacity = maxSize;
        }
        arrayBuffor = (E[]) new Object[this.maxCapacity];
        setInitialState();
    }

    private void setInitialState() {
        head = 0;
        tail = 0;
        count = 0;
    }

    @Override
    public boolean isFull() {
        return count == maxCapacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new TQueueArrayIterator<E>(
                TQueueArrayIteratorState.Create(count,
                        arrayBuffor,
                        maxCapacity,
                        head)
        );
    }

    @Override
    public boolean put(E element) {
        if (element == null)
            return false;

        if (isFull())
            return false;

        if (!isEmpty())
            tail = (tail + 1) % maxCapacity;

        arrayBuffor[tail] = element;
        count++;
        return true;
    }

    @Override
    public E top() {
        if (isEmpty())
            return null;

        return arrayBuffor[head];
    }

    @Override
    public E get() {
        if (isEmpty()) {
            return null;
        }

        E element = top();
        pop();
        return element;
    }

    @Override
    public boolean pop() {
        if (isEmpty())
            return false;

        if (count == 1) {
            setInitialState();
        } else {
            head = (head + 1) % maxCapacity;
            count--;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head=").append(head).append(", tail=").append(tail).append(" i tablica ma postac:\n");

        for (int i = 0; i < count; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        for (E el : arrayBuffor) {
            sb.append(el).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }
    public E reset(){
        
    }
}
