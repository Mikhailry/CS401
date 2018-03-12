package lab7;


import java.util.EmptyStackException;

public interface StackInterface<T> {

        void push(T element);
        // places element at the top of this stack.

        void pop() throws EmptyStackException;
        // Throws EmptyStackException if this stack is empty,
        // otherwise removes top element from this stack.

        T top() throws EmptyStackException;
        // Throws EmptyStackException if this stack is empty,
        // otherwise returns top element of this stack.

        boolean isFull();
        // Returns true if this stack is full, otherwise returns false.

        boolean isEmpty();
        // Returns true if this stack is empty, otherwise returns false.

}//end of interface
