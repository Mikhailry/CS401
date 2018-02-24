package lab6;


import java.util.EmptyStackException;

public class LinkedStack implements StackInterface{

    protected LLNode<Employee> top; // reference to the top of this stack
    public LinkedStack()
    {
        top = null;
    }

    public void push(Object element) {
        // Places element at the top of this stack.
        LLNode<Employee> newNode = new LLNode((Employee) element);
        newNode.setLink(top);
        top = newNode;
    }

    public void pop()
    // Throws NullPointerException if this stack is empty,
    // otherwise removes top element from this stack.
    {
        if (isEmpty())
            throw new NullPointerException("Pop attempted on an empty stack.");
        else
            top = top.getLink();
    }

    public Employee top()
    // Throws NullPointerException if this stack is empty,
    // otherwise returns top element of this stack.
    {
        if (isEmpty())
            throw new NullPointerException("Top attempted on an empty stack.");
        else
            return top.getInfo();
    }

    public boolean isEmpty()
    // Returns true if this stack is empty, otherwise returns false.
    {
        return (top == null);
    }

    public boolean isFull()
    // Returns false – a linked stack is never full.
    {
        return false;
    }

}
