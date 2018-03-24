package lab8;

public class LinkedList<T> {

    protected LLNode<T> head; // reference to the head node
    protected int numElements = 0; // number of elements in the LinkedList

    public LinkedList() {
        this.head = null;
        this.numElements = 0;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public void add(T element) {

        LLNode<T> newNode = new LLNode<>((T) element);
        newNode.setLink(head);
        head = newNode;
        numElements++;
    }

    public void remove(T element) {

        LLNode<T> temp = head;
        LLNode<T> previous = null;

        // check if head node has data for deletion
        if (temp != null && temp.getInfo() == element)
        {
            head = temp.getLink(); // Changed head
            return;
        }

        // Search for the element to be deleted and
        // keeping track of the previous node
        while (temp != null && temp.getInfo() != element)
        {
            previous = temp;
            temp = temp.getLink();
        }

        // if element not found
        if (temp == null) return;

        // Unlink the node from linked list
        previous.setLink(temp.getLink());
    }

    public boolean isFull(){
        // Returns false – a linked list is never full.
        return false;
    }

    //print LinkedList
    public void printList()
    {
        LLNode pnode = head;
        while (pnode != null)
        {
            System.out.print(pnode.getInfo()+" ");
            pnode = pnode.getLink();
        }
    }//end of printList method

}
