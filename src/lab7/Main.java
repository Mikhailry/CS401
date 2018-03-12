package lab7;

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

        System.out.println("1. Read emp.txt file and create an array of employee objects.\n"
                + "2. Sort employee items by ID using Selection Sort method.\n"
                + "3. Print employee items\n"
                + "4. Search employee using Binary Search\n"
                + "5. NA\n"
                + "6. NA\n"
                + "7. NA\n"
                + "8. NA\n"
                + "9. NA\n"
                + "0. Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer
        int lines = 0; //holds number of lines in the file
        Employee [] empList1 = new Employee[lines]; //array of objects of class Employee

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

                        //adding instantiated employee to the array
                        empList1[empCounter] = employee;

                        empCounter++;
                        //nextLine = inpScanner.nextLine();

                    } //end of while loop

                    System.out.println("Done! Employees have been added to the array.\n");
                    mn1.showMenu();
                    break;

                case 2:
                    SelectionSort obj = new SelectionSort();
                    obj.sort(empList1);
                    System.out.println("Done! Employees have been sorted.\n");

                    mn1.showMenu();
                    break;

                case 3:
                    SelectionSort obj1 = new SelectionSort();
                    obj1.printArray(empList1);

                    mn1.showMenu();
                    break;

                case 4:

                    int target=0;
                    int first=0;
                    int last=0;

                    System.out.println("Input target ID: ");
                    Scanner sc1 = new Scanner(System.in);
                    target = sc1.nextInt();

                    int k=empList1.length;
                    if (k>0) {
                        first = 0;
                        last = k - 1;

                        BinarySearch obj2 = new BinarySearch();
                        boolean result = obj2.binarySearch(empList1, target, first, last);
                        if (result==true) {System.out.println("Employee is in the list\n");}
                        else {System.out.println("Employee is NOT in the list\n");}
                    }
                    else {
                        System.out.println("First, read the emp.txt file");
                    }

                    mn1.showMenu();
                    break;

                case 5:


                    mn1.showMenu();
                    break;

                case 6:


                    mn1.showMenu();
                    break;

                case 7:


                    mn1.showMenu();
                    break;

                case 8:


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
