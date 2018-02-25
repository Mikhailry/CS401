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
    public void enqueue(Object element) {
        LLNode<Employee> newNode = new LLNode(element);
        if (rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        numElements++;

    }

    @Override
    public Object dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Dequeue attempted on empty queue.");
        else
        {
            Employee element;
            element = front.getInfo();
            front = front.getLink();
            if (front == null)
                rear = null;
            numElements--;
            return element;
        }
    }

    @Override
    public boolean isFull() {
        // Returns false – a linked queue is never full.
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (numElements==0);
    }

    @Override
    public int size() {
        //returns size of queue
        return numElements;
    }
}
