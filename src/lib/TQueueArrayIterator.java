package lib;

import java.util.Iterator;

public class TQueueArrayIterator<E> implements Iterator<E> {

    private TQueueArrayIteratorState<E> state;

    public TQueueArrayIterator(TQueueArrayIteratorState<E> state) {
        this.state = state;
    }

    @Override
    public boolean hasNext() {
        return state.getCount() > 0;
    }

    @Override
    public E next() {
        if( hasNext() ){
            E data = state.getArrayReference()[state.getCurrentIndex()];
            state.setCurrentIndex( (state.getCurrentIndex()+1)%state.getMaxSize() );
            state.decCount();
            return data;
        }

        return null;
    }
}
