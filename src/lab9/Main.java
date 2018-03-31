package lab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
                + "8. Part2: Remove employee at indeces==30,1,3 in a DoublyLinkedList with 'public T remove(int index)'.\n"
                + "9. Part3: Build the Binary Search Tree.\n"
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


                    mn1.showMenu();
                    break;

                default:
                    mn1.showMenu();
                    break;
            }//end of switch


        }//end of showMenu while loop


    }//end of main method
}
