package lab6;

import java.util.NoSuchElementException;

public class ArrayBoundedQueue<T> implements QueueInterface{

    protected final int DEFCAP = 100; // default capacity
    protected T[] elements; // array that holds queue elements
    protected int numElements = 0; // number of elements in the queue
    protected int front = 0; // index of front of queue
    protected int rear; // index of rear of queue

    //default constructor with capacity equal 100
    public ArrayBoundedQueue()
    {
        elements = (T[]) new Object[DEFCAP];
        rear = DEFCAP - 1;
    }

    //custom constructor where user may set the size of array
    public ArrayBoundedQueue(int maxSize)
    {
        elements = (T[]) new Object[maxSize];
        rear = maxSize - 1;
    }

    @Override
    public void enqueue(Object element) throws NoSuchElementException {
        if (isFull())
            throw new NoSuchElementException("Enqueue attempted on a full queue.");
        else
        {
            rear = (rear + 1) % elements.length;
            elements[rear] = (T) element;
            numElements = numElements + 1;
        }
    }

    public T dequeue()
    // Throws ArrayIndexOutOfBoundsException if this queue is empty;
    // otherwise, removes front element from this queue and returns it.
    {
        if (isEmpty())
            throw new NoSuchElementException("Dequeue attempted on empty queue.");
        else
        {
            T toReturn = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            numElements = numElements - 1;
            return toReturn;
        }
    }

    public boolean isEmpty()
    // Returns true if this queue is empty; otherwise, returns false
    {
        return (numElements == 0);
    }

    public boolean isFull()
    // Returns true if this queue is full; otherwise, returns false.
    {
        return (numElements == elements.length);
    }

    public int size()
    // Returns the number of elements in this queue.
    {
        return numElements;
    }

}
