package lib;

public class TQueueArrayIteratorState<E> {
    private int count;
    private E[] arrayReference;
    private int maxSize;
    private int currentIndex;

    private TQueueArrayIteratorState(int count, E[] arrayReference, int maxSize, int startingIndex) {
        this.count = count;
        this.arrayReference = arrayReference;
        this.maxSize = maxSize;
        this.currentIndex = startingIndex;
    }

    public int getCount() {
        return count;
    }

    public void decCount(){
        count--;
    }

    public E[] getArrayReference() {
        return arrayReference;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public static <E> TQueueArrayIteratorState<E> Create(int count, E[] arrayReference, int maxSize, int startingIndex){
        return  new TQueueArrayIteratorState<E>(
                count,
                arrayReference,
                maxSize,
                startingIndex);
    }
}
