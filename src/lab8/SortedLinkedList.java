package lab8;


public class SortedLinkedList<T> extends LinkedList<Employee> {


    @Override
    public void add(Employee element){
        //This method inserts new objects in the collection using a
        //sorted order. Sort elements based on ID.

        LLNode<Employee> newNode = new LLNode<>(element);

            //dealing with special cases
            //head reference is null and inserted element is smaller than head
            if (head==null || head.info.compareTo(element)>0) {
                newNode.setLink(head);
                head = newNode;
            }

            else {

                LLNode<Employee> current = head;

                //searching the position for sorted insert
                while (current.getLink()!=null && current.getLink().info.compareTo(element)<0) {
                    current = current.getLink();
                } // end of while loop

                newNode.setLink(current.getLink());
                current.setLink(newNode);
            } // end of else

    }//end of add method

}
