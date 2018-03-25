package lab8;

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

        System.out.println("1. Part1: Read emp.txt file and create a sorted LinkedList of employee objects.\n"
                + "2. Part1: Add new employee (Mikhail, 1234567) in a sorted way.\n"
                + "3. Part1: Print employee items from a SortedLinkedList.\n"
                + "4. Part2: Add employee objects to the ArrayList.\n"
                + "5. Part2: Print all elements of ArrayList.\n"
                + "6. Part2: Add element in the middle (Middleton 445566).\n"
                + "7. Part2: Add element at the front (Frontier 112211).\n"
                + "8. Part2: Get element with index 3.\n"
                + "9. Part2: Remove element with index 3.\n"
                + "0. Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer
        int lines = 0; //holds number of lines in the file
        int lines2 = 0; //holds number of lines in the file2
        Employee [] empList1 = new Employee[lines]; //array of objects of class Employee
        Employee [] empList2 = new Employee[lines]; //array of objects of class Employee

        //SortedLinkedList instantiation
        SortedLinkedList<Employee> empLL = new SortedLinkedList<>();

        //ArrayList instantiation with size 10
        CS401ArrayImpl empArrayList = new CS401ArrayImpl(10);

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

                    empList1 = new Employee[lines]; //array of objects of class Employee
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

                        //adding instantiated employee to the LinkedList
                        empLL.add(employee);
                        //empLL.printList(); //print LinkedList after each insertion
                        System.out.println();
                        empCounter++;
                        //nextLine = inpScanner.nextLine();

                    } //end of while loop

                    System.out.println("Done! Employees have been added to the SortedLinkedList.\n");
                    mn1.showMenu();
                    break;

                case 2:
                    Employee emp1 = new Employee(123456789, "Mikhail");
                    empLL.add(emp1);

                    mn1.showMenu();
                    break;

                case 3:
                    empLL.printList();

                    mn1.showMenu();
                    break;

                case 4:

                    FileReader newFile2 = new FileReader("emp.txt");
                    //count number of lines in the file
                    BufferedReader reader2 = new BufferedReader(newFile2);


                    while (reader2.readLine() != null) lines2++;
                    try {
                        reader2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    empList2 = new Employee[lines]; //array of objects of class Employee
                    int empCounter2 = 0; //employee counter

                    //read emp.txt file
                    File inpFile2 = new File("emp.txt");
                    Scanner inpScanner2 = new Scanner(inpFile2);

                    while (inpScanner2.hasNextLine()) {

                        String nextLine = inpScanner2.nextLine();

                        //splitting line into parts and writing to array
                        String [] empAttr = nextLine.split(" ");

                        //instantiating new Employee
                        Employee employee = new Employee(Integer.parseInt(empAttr[1]), empAttr[0]);

                        //adding instantiated employee to the ArrayList
                        empArrayList.add(employee);

                        System.out.println();
                        empCounter2++;
                        //nextLine = inpScanner.nextLine();

                    } //end of while loop

                    System.out.println("Done! Employees have been added to the ArrayList.\n");


                    mn1.showMenu();
                    break;

                case 5:
                    System.out.println("Printing all the elements:\n");
                    empArrayList.printAL();

                    mn1.showMenu();
                    break;

                case 6:
                    Employee emp2 = new Employee(445566, "Middleton");
                    System.out.println("Adding element in the middle (index=3) (Middleton 445566)");
                    empArrayList.add(Where.MIDDLE, 3, emp2);


                    mn1.showMenu();
                    break;

                case 7:
                    Employee emp3 = new Employee(112211, "Frontier");
                    System.out.println("Adding element at the front (Frontier 112211)");
                    empArrayList.add(Where.FRONT,emp3);

                    mn1.showMenu();
                    break;

                case 8:
                    System.out.println("Element with index=3: "+empArrayList.get(3));

                    mn1.showMenu();
                    break;

                case 9:
                    System.out.println("Removing element with index=3: "+empArrayList.remove(3));


                    mn1.showMenu();
                    break;

                default:
                    mn1.showMenu();
                    break;
            }//end of switch


        }//end of showMenu while loop


    }//end of main method
}
