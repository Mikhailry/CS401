package lab9;

public class TreeNode<T> {

    private T info; //node info
    private TreeNode<T> left; //link to the left child
    private TreeNode<T> right; //link to the right child

    //constructor
    public TreeNode(T info){
        this.info = info;
        left = null;
        right = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
