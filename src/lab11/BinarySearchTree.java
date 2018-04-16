package lab11;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T> {

    protected TreeNode<T> root; //reference to the root
    protected Comparator<T> comp; //used for comparisons
    protected boolean found;

    public BinarySearchTree(){
        root = null;
        comp = new Comparator<T>() {

            public int compare(T element1, T element2) {
                return ((Comparable)element1).compareTo(element2);
            }

        };
    }

    public BinarySearchTree(Comparator<T>comp){
        root = null;
        this.comp = comp;
    }

    //returns true if BST is empty
    public boolean isEmpty(){
        return (root == null);
    }

    //returns min element of BST, if BST is empty - returns null
    public T min(){

        if (isEmpty()){
            return null;
        } else {
            TreeNode<T> node = root;
            while (node.getLeft()!=null){
                node = node.getLeft();
            }
            return node.getInfo();
        }
    }//end of min method

    //returns max element of BST, if BST is empty - returns null
    public T max(){
        if (isEmpty()){
            return null;
        } else {
            TreeNode<T> node = root;
            while (node.getRight()!=null){
                node = node.getRight();
            }
            return node.getInfo();
        }
    }//end of max method

    //returns the depth of BST - number of nodes along the longest path from the root node down
    public int maxDepth(TreeNode<T> node){
        int leftDepth=0;
        int rightDepth=0;

        if (isEmpty()) {
            return 0;
        } else{
            if (node.getLeft()!=null) {
                leftDepth = maxDepth(node.getLeft());
            }
            if (node.getRight()!=null) {
                rightDepth = maxDepth(node.getRight());
            }

            if (leftDepth>rightDepth){
                return 1+leftDepth;
            } else {
                return 1+rightDepth;
            }
        }
    }//end of maxDepth method



    //returns the size of the tree recursively
    public int size(){return size_p(root);}

    private int size_p(TreeNode<T> node){
        if (node == null) {
            return 0;
        } else {
            return 1+size_p(node.getLeft())+size_p(node.getRight());
        }
    }//end of recursive size method

    //returns the size of the tree iteratively
    public int sizeIter() {
        int count = 0;
        if (root != null)
        {
            LinkedStack<TreeNode<T>> nodeStack = new LinkedStack<TreeNode<T>> ();
            TreeNode<T> currNode;
            nodeStack.push(root);
            while (!nodeStack.isEmpty()) {
                currNode = nodeStack.top();
                nodeStack.pop();
                count++;
                if (currNode.getLeft() != null)
                    nodeStack.push(currNode.getLeft());
                if (currNode.getRight() != null)
                    nodeStack.push(currNode.getRight());
            } //end of while loop
        }
        return count;
    }//end of iterative size method


    //returns true if BST contains element
    public boolean contains (T target) {return contains_p(target, root);}

    private boolean contains_p (T target, TreeNode<T> node){
        if (node == null) {
            return false;
        }
        else if (comp.compare(target, node.getInfo())<0) {
            return contains_p(target, node.getLeft()); //search left subtree
        }
        else if (comp.compare(target, node.getInfo()) > 0) {
            return contains_p(target, node.getRight()); //search right subtree
        }
        else {return true;} //target is found
    } //end of contains_p method


    //returns info of the target
    public T get (T target){return get_p(target, root);}

    private T get_p(T target, TreeNode<T> node){
        if (node == null){
            return null;
        }
        else if (comp.compare(target, node.getInfo()) < 0) {
            return get_p(target, node.getLeft()); // get from left subtree
        }
        else if (comp.compare(target, node.getInfo()) > 0) {
            return get_p(target, node.getRight()); // get from right subtree
        }
        else {
            return node.getInfo(); // target is found
        }
    }// end of get_p method

    //adds element to BST
    public boolean add (T element) {
        root = add_p(element, root);
        return true;
    }

    private TreeNode<T> add_p(T element, TreeNode<T> node) {
        if (node == null) {
            node = new TreeNode<T>(element);
        }
        else if (comp.compare(element, node.getInfo()) <= 0){
            node.setLeft(add_p(element, node.getLeft()));//add at left subtree
        }
        else {
            node.setRight(add_p(element, node.getRight())); //add at right subtree
        }
        return node;
    }//end of add_p method

    //removes element from BST
    public boolean remove (T target) {
        root = remove_p(target, root);
        return found;
    }

    private TreeNode<T> remove_p(T target, TreeNode<T> node){
        if (node == null){
            found = false;
        } else if (comp.compare(target, node.getInfo()) < 0) {
            node.setLeft(remove_p(target, node.getLeft()));
        } else if (comp.compare(target, node.getInfo()) > 0) {
            node.setRight(remove_p(target, node.getRight()));
        } else {
            node = removeNode(node);
            found = true;
        }
        return node;
    }//end of remove_p method

    //removes information at node
    private TreeNode<T> removeNode(TreeNode<T> node){
        T data;
        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        } else {
            data = getPredecessor(node.getLeft());
            node.setInfo(data);
            node.setLeft(remove_p(data, node.getLeft()));
            return node;
        }
    }// end of remove node method

    //return info at the rightmost tree node
    private T getPredecessor(TreeNode<T> subtree) {
        TreeNode<T> temp = subtree;
        while (temp.getRight() != null)
            temp = temp.getRight();
        return temp.getInfo();
    }

    // Creates and returns an Iterator providing a traversal of a "snapshot"
    public Iterator<T> getIterator(Order order) {
        final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
        if (order == Order.Preorder) {
            preOrder(root, infoQueue);
        } else if (order == Order.Inorder) {
            inOrder(root, infoQueue);
        } else if (order == Order.Postorder) {
            postOrder(root, infoQueue);
        }

        return new Iterator<T>() {
            public boolean hasNext() {
                // Returns true if iteration has more elements; otherwise returns false.
                return !infoQueue.isEmpty();
            }

            public T next() {
                // Returns the next element in the iteration.
                // Throws NoSuchElementException - if the iteration has no more elements
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("illegal invocation of next "
                            + " in BinarySearchTree iterator.\n");
                }
                return infoQueue.dequeue();
            }
        };
    }//end of getIterator method

    // Enqueues the elements from the subtree rooted at node into q in inOrder.
    private void inOrder(TreeNode<T> node, LinkedQueue<T> q){
        if (node != null) {
            inOrder(node.getLeft(), q);
            q.enqueue(node.getInfo());
            System.out.print(node.getInfo()+" ");
            inOrder(node.getRight(), q);
        }
    }//end of inOrder method

    // Enqueues the elements from the subtree rooted at node into q in preOrder.
    private void preOrder(TreeNode<T> node, LinkedQueue<T> q) {
        if (node != null) {
            q.enqueue(node.getInfo());
            System.out.print(node.getInfo()+" ");
            preOrder(node.getLeft(), q);
            preOrder(node.getRight(), q);
        }
    }//end of preOrder method

    // Enqueues the elements from the subtree rooted at node into q in postOrder.
    private void postOrder(TreeNode<T> node, LinkedQueue<T> q) {
        if (node != null) {
            postOrder(node.getLeft(), q);
            postOrder(node.getRight(), q);
            q.enqueue(node.getInfo());
            System.out.print(node.getInfo()+" ");
        }
    }//end of postOrder method

}//end of class
