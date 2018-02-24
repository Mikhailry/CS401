package lab6;

import java.util.NoSuchElementException;

public class FixedFrontArrayQueue<T> implements QueueInterface{

    protected final int DEFCAP=30; //default array size
    protected T[] elements; //array that holds queue elements
    protected final int front=0; //index of front of the queue
    protected int rear; //index of rear of the queue
    protected int numElements=0; //number of elements in the queue

    //default constructor
    public FixedFrontArrayQueue() {

        elements = (T[]) new Object[DEFCAP];
    }

    @Override
    public void enqueue(Object element) throws NoSuchElementException {
        if (isFull())
            throw new NoSuchElementException("Enqueue attempted on a full queue.");
        else
        {
            elements[rear] = (T) element;
            rear++;
            numElements++;
        }
    }

    @Override
    public Object dequeue() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Dequeue attempted on empty queue.");
        else
        {
            T toReturn = elements[front];
            for (int i=0; i<numElements-1;i++){
                elements[i]=elements[i+1];
            }
            rear--;
            numElements--;
            return toReturn;
        }
    }

    @Override
    public boolean isFull() {
        return (numElements == elements.length);
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    @Override
    public int size() {
        return numElements;
    }
}
