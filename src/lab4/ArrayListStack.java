package lab4;

import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class ArrayListStack<T> implements StackInterface<T> {

    protected ArrayList<T> elements; // ArrayList that holds stack elements

    public ArrayListStack()
    {
        elements = new ArrayList<T>();
    }


    public void push(T element)
    // place element at the top
    {
        elements.add(element);
    }


    public void pop()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    {
        if (!isEmpty()) {
            elements.remove(elements.size() - 1);
        }
    }

    public T peek()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element of this stack.
    {
        T topOfStack = null;
        if (isEmpty())
            System.out.println("Top attempted on empty stack.");
        else
            topOfStack = elements.get(elements.size() - 1);
        return topOfStack;
    }

    public boolean isEmpty()
    // Returns true if this stack is empty, otherwise returns false.
    {
        return (elements.size() == 0);
    }
    public boolean isFull()
    // Returns false – an ArrayListStack is never full.
    {
        return false;
    }


}//end of class
