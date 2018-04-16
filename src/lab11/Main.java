package lab11;


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
                + "[2] Balance Binary Search Tree.\n"
                + "[3] Print InOrder Traversal.\n"
                + "[4] Remove leaf node (90).\n"
                + "[5] Remove node with one child (70).\n"
                + "[6] Remove node with two children (22).\n"
                + "[7] Add nodes to BST (array impl).\n"
                + "[8] Check if BST contains node (array impl).\n"
                + "[0] Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer

        //instantiate BST
        BinarySearchTree numbers = new BinarySearchTree();
        //instantiating BST balanced
        BinarySearchTree numbersBal = new BinarySearchTree<>();

        //instantiating BST array of size 10
        BSTarray numbersArr = new BSTarray(10);

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
                        System.out.println("The following tree has been built:");
                        System.out.println("                25");
                        System.out.println("              /    \\");
                        System.out.println("             /      \\");
                        System.out.println("            /        \\");
                        System.out.println("           /          \\");
                        System.out.println("          /            \\");
                        System.out.println("        15              50");
                        System.out.println("       / \\             / \\");
                        System.out.println("      /   \\           /   \\");
                        System.out.println("     /     \\         /     \\");
                        System.out.println("   10       22      35      70");
                        System.out.println("  /  \\     / \\     / \\     / \\");
                        System.out.println(" /    \\   /   \\   /   \\   /   \\");
                        System.out.println("4     12 18    24 31   44 66   90");


                    }

                    mn1.showMenu();
                    break;

                case 3:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [2] to balance tree first");
                    } else {
                        System.out.println("\nInOrder traversal: ");
                        numbersBal.getIterator(Order.Inorder);
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                case 4:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [2] to balance tree first");
                    } else {
                        System.out.println("Removing leaf node : 90");
                        numbersBal.remove(90);
                        System.out.println("\nInOrder traversal: ");
                        numbersBal.getIterator(Order.Inorder);
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                case 5:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [2] to balance tree first");
                    } else {
                        System.out.println("Removing node with one child : 70");
                        numbersBal.remove(70);
                        System.out.println("\nInOrder traversal: ");
                        numbersBal.getIterator(Order.Inorder);
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                case 6:
                    if (numbersBal.size()==0) {
                        System.out.println("Please press [2] to balance tree first");
                    } else {
                        System.out.println("Removing node with two children : 22");
                        numbersBal.remove(22);
                        System.out.println("\nInOrder traversal: ");
                        numbersBal.getIterator(Order.Inorder);
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                case 7:
                    System.out.println("Adding the following elements :");
                    System.out.println("50, 40, 29, 45, 42, 60, 70");
                    numbersArr.add(50);
                    numbersArr.add(40);
                    numbersArr.add(29);
                    numbersArr.add(45);
                    numbersArr.add(42);
                    numbersArr.add(60);
                    numbersArr.add(70);

                    System.out.println("Tree array output :");
                    numbersArr.printAll();
                    System.out.println();

                    mn1.showMenu();
                    break;

                case 8:
                    if (numbersArr.is_empty()) {
                        System.out.println("Please press [7] to add nodes to array BST first");
                    } else {
                        System.out.println("Does tree contains element 42 :");
                        System.out.println(numbersArr.contains(42));
                        System.out.println();
                        System.out.println("Does tree contains element 33 :");
                        System.out.println(numbersArr.contains(33));
                    }

                    mn1.showMenu();
                    break;

//                case 9:
//
//
//                    mn1.showMenu();
//                    break;

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
