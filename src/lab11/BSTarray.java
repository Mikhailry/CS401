package lab11;

//Array implementation of BST
public class BSTarray<T> {

    private int numElements=0; //number of elements in the array
    private T[] tree;
    private int capacity; //array size
    private int maxIndex=-1; //to hold the max index of the array

    //constructor
    public BSTarray(int size) {
        tree = (T[]) new Object[size];
        numElements = 0;
        capacity = size;
    }

    //add method
    public void add (T element) {
        if (capacity < maxIndex*2+3) {
            grow();
        }

        Comparable<T> temp = (Comparable<T>) element;

        if (is_empty()) {
            tree[0] = element;
            maxIndex = 0;
            numElements++;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while (!added) {
                if (temp.compareTo((tree[currentIndex])) < 0) {
                    // go left
                    if (tree[currentIndex*2+1] == null) {
                        tree[currentIndex*2+1] = element;
                        added = true;
                        numElements++;
                        if (currentIndex*2+1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    // go right
                    if (tree[currentIndex*2+2] == null) {
                        tree[currentIndex*2+2] = element;
                        added = true;
                        numElements++;

                        if (currentIndex*2+2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else
                        currentIndex = currentIndex*2+2;
                }
            }// end of while loop
        }

    }  // end of add method

    //is_full returns true if number of elements equal to array capacity, else returns false
    public boolean is_full() {
        if (numElements == capacity)
            return true;
        return false;
    }//end of is_full method

    //returns true if number of elements equal 0
    public boolean is_empty() {
        if (numElements == 0)
            return true;
        return false;
    }//end of is_empty method

    private boolean grow()  {

        T[] treeExt = (T[]) new Object[capacity*2+3];
        for (int i=0; i<=maxIndex; i++ ){
            treeExt[i] = tree[i];
        }//end of for loop
        tree = treeExt;
        capacity = tree.length;

        System.out.println("Capacity reached.  Increasing storage...");
        System.out.println("New capacity is " + capacity + " elements");

        return true;
    }// end of grow method

    public void printAll() {

        for (int i = 0; i <= maxIndex; i++) {
            System.out.print(tree[i] + " ");
        }// end of for loop
    }

    public boolean contains(T element) {

        boolean result = false;

        for (int i=0; i <= maxIndex; i++){

            if (tree[i] !=null && tree[i].equals(element)){
                result = true;
            } else {
                i++;
            }

        }//end of for loop

        return result;
    }//end of contains method

}
