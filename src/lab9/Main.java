package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void showMenu() {
        //input menu
        System.out.println("##     ## ######## ##    ## ##     ##");
        System.out.println("###   ### ##       ###   ## ##     ##");
        System.out.println("#### #### ##       ####  ## ##     ##");
        System.out.println("## ### ## ######   ## ## ## ##     ##");
        System.out.println("##     ## ##       ##  #### ##     ##");
        System.out.println("##     ## ##       ##   ### ##     ##");
        System.out.println("##     ## ######## ##    ##  #######");
        System.out.println("=====================================");

        System.out.println("1. Part2: Read emp.txt file and create a DoublyLinkedList of employee objects.\n"
                + "2. Part2: Add new employee (Mikhail1, 1111111) in a DoublyLinkedList with 'public boolean add(T element)'.\n"
                + "3. Part2: Print employee items from a DoublyLinkedList.\n"
                + "4. Part2: Add new employee (Mikhail2, 2222222) in a DoublyLinkedList at BACK with 'public boolean add(Where where, T element)'.\n"
                + "5. Part2: Add new employee (Mikhail3, 3333333) in a DoublyLinkedList at FRONT with 'public boolean add(Where where, T element)'.\n"
                + "6. Part2: Add new employee (Mikhail4, 4444444) in a DoublyLinkedList in the MIDDLE with index== 4 with 'public boolean add(Where where, int index, T element)'.\n"
                + "7. Part2: Search for employee (Mikhail4, 4444444) in a DoublyLinkedList with 'public boolean contains (T element)'.\n"
                + "8. Part2: Remove employee at index==3 in a DoublyLinkedList with 'public T remove(int index)'.\n"
                + "9. Part3: Add elements one by one to build Binary Search Tree and than rebuild it balanced.\n"
                + "0. Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer
        int lines = 0; //holds number of lines in the file
        int lines2 = 0; //holds number of lines in the file2
        Employee [] empList1 = new Employee[lines]; //array of objects of class Employee
        //Employee [] empList2 = new Employee[lines]; //array of objects of class Employee

        //DoublyLinkedList instantiation
        DoublyLinkedList empDLL = new DoublyLinkedList();

        //instantiating test employees
        Employee emp1 = new Employee(1111111, "Mikhail1");
        Employee emp2 = new Employee(2222222, "Mikhail2");
        Employee emp3 = new Employee(3333333, "Mikhail3");
        Employee emp4 = new Employee(4444444, "Mikhail4");

        //instantiate BST
        BinarySearchTree numbers = new BinarySearchTree();

        Main mn1 = new Main();
        mn1.showMenu();

        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 0) {

            switch (n){

                case 1:

                    FileReader newFile = new FileReader("emp.txt");
                    //count number of lines in the file
                    BufferedReader reader = new BufferedReader(newFile);


                    while (reader.readLine() != null) lines++;
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //empList1 = new Employee[lines]; //array of objects of class Employee
                    int empCounter = 0; //employee counter

                    //read emp.txt file
                    File inpFile = new File("emp.txt");
                    Scanner inpScanner = new Scanner(inpFile);

                    while (inpScanner.hasNextLine()) {

                        String nextLine = inpScanner.nextLine();

                        //splitting line into parts and writing to array
                        String [] empAttr = nextLine.split(" ");

                        //instantiating new Employee
                        Employee employee = new Employee(Integer.parseInt(empAttr[1]), empAttr[0]);

                        //adding instantiated employee to the DoublyLinkedList
                        empDLL.add(employee);

                        //empLL.printList(); //print LinkedList after each insertion
                        System.out.println();
                        empCounter++;
                        //nextLine = inpScanner.nextLine();

                    } //end of while loop

                    System.out.println("Done! Employees have been added to the DoublyLinkedList.\n");
                    mn1.showMenu();
                    break;

                case 2:
                    empDLL.add(emp1);

                    mn1.showMenu();
                    break;

                case 3:
                    empDLL.printDLL();

                    mn1.showMenu();
                    break;

                case 4:
                    empDLL.add(Where.BACK, emp2);

                    mn1.showMenu();
                    break;

                case 5:
                    empDLL.add(Where.FRONT, emp3);

                    mn1.showMenu();
                    break;

                case 6:
                    empDLL.add(Where.MIDDLE, 4, emp4);

                    mn1.showMenu();
                    break;

                case 7:
                    empDLL.contains(emp4);

                    mn1.showMenu();
                    break;

                case 8:
                    System.out.println("Before removing element with index=3: ");
                    empDLL.printDLL();
                    System.out.println();
                    empDLL.remove(3);
                    System.out.println("After removing element with index=3: ");
                    empDLL.printDLL();
                    System.out.println();

                    mn1.showMenu();
                    break;

                case 9:
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

                    System.out.println("Min element is: " + numbers.min());
                    System.out.println("Max element is: " + numbers.max());

                    System.out.println("\nInorder traversal: ");
                    numbers.getIterator(Order.Inorder);

                    //balance tree
                    //get size
                    int size = numbers.size();
                    //instantiate array of size == number of tree elements
                    Integer [] num = new Integer[size];
                    int index = 0;

                    //put all tree elements into array in order
                    Iterator iter = numbers.getIterator(Order.Inorder);
                    while (iter.hasNext()) {
                        num[index] = (int) iter.next();
                        index++;
                    }

                    //instantiating new tree
                    BinarySearchTree numbersBal = new BinarySearchTree<>();
                    //building a balanced tree
                    rebuildTree(numbersBal, num, 0, index-1);
                    System.out.println();
                    System.out.println("Tree was rebuild.");

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
