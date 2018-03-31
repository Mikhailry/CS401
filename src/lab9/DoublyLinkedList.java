package lab9;

public class DoublyLinkedList<T> {

    protected DLLNode<T> head; //reference to the head
    protected int numElements = 0; // number of elements


    class DLLNode<T>{

        protected T info; //reference to an object
        protected DLLNode<T> next; //reference to a next node
        protected DLLNode<T> prev; //reference to a previous node

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        //DLLNode constructor
        public DLLNode(T info){

            this.info=info;
            next=null;
            prev=null;
        }//end of constructor
    } // end of DLLNode class

    //add element at the front
    public boolean add(T element){

        //create new node
        DLLNode<T> newNode = new DLLNode<>((T) element);

        //set next pointer to the head, previous to null
        newNode.next = head;
        newNode.prev = null;

        //set prev of head node to newNode
        if (head != null) {
            head.prev = newNode;
        }

        //move head to point new inserted element
        head = newNode;

        numElements++;

        return true;
    } // end of add method


    /**
     * Add element in front or at the end, as dictated by where.
     * Preconditions: where != MIDDLE
     */
    public boolean add(Where where, T element){

        if (where == Where.BACK)  {
            System.out.println("Inserting element at the rear");

            //create new node
            DLLNode<T> newNode = new DLLNode<>((T) element);
            DLLNode<T> last = head;

            //set newNode next reference as null
            newNode.next = null;

            //if DLL is empty, then set head ref to newNode
            if (head == null) {
                newNode.prev = null;
                head = newNode;
                return true;
            }

            //if DLL is not empty, find last node
            while (last.next != null){
                last = last.next;
            }

            //add newNode at the back
            last.next = newNode;

            //set reference from newNode to last
            newNode.prev = last;

            numElements++;
            return true;
        }
        else if (where == Where.FRONT)  {
            System.out.println("Inserting element at the front");

            //create new node
            DLLNode<T> newNode = new DLLNode<>((T) element);

            //set next pointer to the head, previous to null
            newNode.next = head;
            newNode.prev = null;

            //set prev of head node to newNode
            if (head != null) {
                head.prev = newNode;
            }

            //move head to point new inserted element
            head = newNode;

            numElements++;
            return true;
        }//end of else if

        return false;
    }//end of add (FRONT,BACK) method


    /**
     * Add element in middle.
     * Preconditions: where == MIDDLE
     *                index <= numElements
     */
    public boolean add(Where where, int index, T element){

        if (where == Where.MIDDLE && index<=numElements && index>0){

            //create new node
            DLLNode<T> newNode = new DLLNode<>((T) element);
            DLLNode<T> tmp = head;

            //insert at front
            if (index == 1){
                add(Where.FRONT, element);
            }
            else if (index == numElements){
                add(Where.BACK, element);
            }

            else {
                for (int i = 2; i <= numElements; i++)
                {
                    if (i == index) {

                        newNode.next = tmp.next;
                        tmp.next = newNode;
                        newNode.prev = tmp;
                        if (newNode.next != null){
                            newNode.next.prev = newNode;
                        }
                    }
                    tmp = tmp.next;
                }
                System.out.println("Inserting element in the MIDDLE");
            }
            numElements++;
            return true;
        } // end of if
        else {
            System.out.println("There is no such index in the Double Linked List");
            return false;
        }// end of else

    }//end of add method with index

    //method to search for an element in the DLL
    public boolean contains (T element){

        DLLNode tmp = head;

        while (tmp != null && tmp.getInfo() != element) {
            tmp = tmp.next;
        }

        // if element not found
        if (tmp == null){
         System.out.println("Element has NOT been found");
            return false;
        }

        System.out.println("Element has been found");
        return true;
//        for (int i=0; i<=numElements; i++){
//            if (tmp.getInfo())
//
//        }
    }

    public T remove(int index){

        DLLNode<T> tmp = head;
        DLLNode<T> prev = head;
        DLLNode<T> rtnObj=null;

        //if DLL is empty, return null
        if (numElements==0) {
            System.out.println("Double Linked List is empty");
            rtnObj=null;
        }
        //else check the index
        else {
            if (index > 0 && index <= numElements) {

                //if index == 1 -> remove at front
                if (index == 1) {
                    head = tmp.next;
                    rtnObj = tmp;
                    tmp = null;
                    numElements--;
                    System.out.println("Element removed at front: " + rtnObj.getInfo());
                }
                //if index == numElements -> remove at rear
                else if (index == numElements) {

                    //find last node
                    while (tmp.next != null) {
                        tmp = tmp.next;
                        rtnObj = tmp;
                    }

                    //find the last but one element
                    prev = tmp.prev;
                    //set reference to last element as null
                    prev.next = null;
                    //set reference from last to previous to null
                    tmp.prev = null;

                    System.out.println("Element removed at rear: "+ rtnObj.getInfo());
                    numElements--;
                }
                else if (index > 1 && index < numElements) {

                    for (int i = 2; i <= index; i++) {
                        if (i == index) {

                            //set next object as return
                            rtnObj = tmp.next;
                            //set new reference between prev and next of object to remove
                            tmp.next = rtnObj.next;
                            //set new reference between next and previous of object to remove
                            //rtnObj.prev = tmp;
                            tmp.next.prev = tmp;
                            //set temp to null
                            //tmp.next=null;

                        }
                        tmp = tmp.next;
                    }
                    System.out.println("Removing element: "+rtnObj.getInfo());

                }

                else {
                    System.out.println("There is no such index in the Double Linked List");
                }

            }//end of if numElements>0 && index<numElements
            else {
                System.out.println("There is no such index in the Double Linked List");
                rtnObj = null;
            }
        }

        return (T) rtnObj;
    } //end of remove method



    //print DoublyLinkedList
    public void printDLL()
    {
        DLLNode pnode = head;
        while (pnode != null)
        {
            System.out.print(pnode.getInfo()+" ");
            pnode = pnode.next;
        }
    }//end of printDLL method

}//end of DoublyLinkedList class
