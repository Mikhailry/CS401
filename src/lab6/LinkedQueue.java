package lab6;

import java.util.NoSuchElementException;

public class LinkedQueue implements QueueInterface{

    protected LLNode<Employee> front; // reference to the front of this queue
    protected LLNode<Employee> rear; // reference to the rear of this queue
    protected int numElements = 0; // number of elements in this queue
    public LinkedQueue()
    {
        front = null; rear = null;
    }

    @Override
    public void enqueue(Object element) throws NoSuchElementException {
        LLNode<Employee> newNode = new LLNode(element);
        if (rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        numElements++;

    }

    @Override
    public Object dequeue() throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
