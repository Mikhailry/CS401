package lab10;


import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void showMenu() {
        //input menu
        System.out.println();
        System.out.println("##     ## ######## ##    ## ##     ##");
        System.out.println("###   ### ##       ###   ## ##     ##");
        System.out.println("#### #### ##       ####  ## ##     ##");
        System.out.println("## ### ## ######   ## ## ## ##     ##");
        System.out.println("##     ## ##       ##  #### ##     ##");
        System.out.println("##     ## ##       ##   ### ##     ##");
        System.out.println("##     ## ######## ##    ##  #######");
        System.out.println("=====================================");

        System.out.println("[1] Add elements one by one to build Binary Search Tree.\n"
                + "[2] Find depth of Binary Search tree.\n"
                + "[3] Balance Binary Search Tree.\n"
                + "[4] Find depth of balanced Binary Search Tree.\n"
                + "[5] Calculate size recursively.\n"
                + "[6] Calculate size iteratively.\n"
                + "[7] Print InOrder Traversal.\n"
                + "[8] Print PreOrder Traversal.\n"
                + "[9] Print PostOrder Traversal.\n"
                + "[0] Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer

        //instantiate BST
        BinarySearchTree numbers = new BinarySearchTree();
        //instantiating BST balanced
        BinarySearchTree numbersBal = new BinarySearchTree<>();

        Main mn1 = new Main();
        mn1.showMenu();

        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 0) {

            switch (n){

                case 1:
                    //4,10,12 15,18,22,24,31,35,44,50,66,70,90,25
                    numbers.add(4);
                    numbers.add(10);
                    numbers.add(12);
                    numbers.add(15);
                    numbers.add(18);
                    numbers.add(22);
                    numbers.add(24);
                    numbers.add(31);
                    numbers.add(35);
                    numbers.add(44);
                    numbers.add(50);
                    numbers.add(66);
                    numbers.add(70);
                    numbers.add(90);
                    numbers.add(25);

                    System.out.println("Binary Search Tree has been built.");
                    System.out.println("Min element is: " + numbers.min());
                    System.out.println("Max element is: " + numbers.max());

                    System.out.println("\nInorder traversal: ");
                    numbers.getIterator(Order.Inorder);
                    System.out.println();

                    mn1.showMenu();
                    break;

                case 2:
                    if (numbers.size()==0) {
                        System.out.println("Please press [1] to build tree first");
                    } else {
                        System.out.println("Binary Search Tree depth: " + numbers.maxDepth(numbers.root));
                    }

                    mn1.showMenu();
                    break;

                case 3:
                    if (numbers.size()==0) {
                        System.out.println("Please press [1] to build tree first");
                    } else {
                        //balance tree
                        //get size
                        int size = numbers.size();
                        //instantiate array of size == number of tree elements
                        Integer[] num = new Integer[size];
                        int index = 0;

                        //put all tree elements into array in order
                        Iterator iter = numbers.getIterator(Order.Inorder);
                        while (iter.hasNext()) {
                            num[index] = (int) iter.next();
                            index++;
                        }

                        //building a balanced tree
                        rebuildTree(numbersBal, num, 0, index - 1);
                        System.out.println();
                        System.out.println("Tree was balanced.");
                    }

                    mn1.showMenu();
                    break;

                case 4:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [3] to balance tree first");
                    } else {
                        System.out.println("Binary Search Tree depth: " + numbersBal.maxDepth(numbersBal.root));
                    }

                    mn1.showMenu();
                    break;

                case 5:
                    System.out.println("Binary Search Tree size (calculated recursively): " + numbers.size());
                    System.out.println("Balanced Binary Search Tree size (calculated recursively): " + numbersBal.size());

                    mn1.showMenu();
                    break;

                case 6:
                    System.out.println("Binary Search Tree size (calculated iteratively): " + numbers.sizeIter());
                    System.out.println("Balanced Binary Search Tree size (calculated iteratively): " + numbersBal.sizeIter());

                    mn1.showMenu();
                    break;

                case 7:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [3] to balance tree first");
                    } else {
                        System.out.println("\nInOrder traversal: ");
                        numbersBal.getIterator(Order.Inorder);
                        System.out.println();
                        System.out.println("Elements are in the sorted ascending order.");
                    }

                    mn1.showMenu();
                    break;

                case 8:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [3] to balance tree first");
                    } else {
                        System.out.println("\nPreOrder traversal: ");
                        numbersBal.getIterator(Order.Preorder);
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                case 9:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [3] to balance tree first");
                    } else {
                        System.out.println("\nPostOrder traversal: ");
                        numbersBal.getIterator(Order.Postorder);
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                default:
                    mn1.showMenu();
                    break;
            }//end of switch


        }//end of showMenu while loop


    }//end of main method

    public static void rebuildTree(BinarySearchTree tree, Integer [] arr, int low, int high){
        if (low==high){
            tree.add(arr[low]);
        }
        else if ((low+1)==high) {
            tree.add(arr[low]);
            tree.add(arr[high]);
        }
        else {
            int mid = (low+high)/2;
            tree.add(arr[mid]);
            rebuildTree(tree, arr, low, mid-1);
            rebuildTree(tree, arr, mid+1, high);
        }
    }

}
