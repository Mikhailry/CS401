package lab10;

import java.util.NoSuchElementException;

public interface QueueInterface<T> {

    void enqueue(T element) throws NoSuchElementException;
    // Throws NoSuchElementException if this queue is full;
    // otherwise, adds element to the rear of this queue.

    T dequeue() throws NoSuchElementException;
    // Throws NoSuchElementException if this queue is empty;
    // otherwise, removes front element from this queue and returns it.

    boolean isFull();
    // Returns true if this queue is full;
    // otherwise, returns false.

    boolean isEmpty();
    // Returns true if this queue is empty;
    // otherwise, returns false.

    int size();
    // Returns the number of elements in this queue.

}
