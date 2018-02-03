package lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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

        System.out.println("1. Input array of integers\n"
                + "2. Read read file for names and IDs: (emp.txt)\n"
                + "3. Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer
        double start, end; //variables to measure complexity

        Main mn1 = new Main();
        mn1.showMenu();

        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 3) {

            switch (n){

                case 1:
                    int size=0;
                    System.out.println("Input array size: ");
                    Scanner sc1 = new Scanner(System.in);
                    size = sc1.nextInt();

                    int [] inputArray = new int [size]; //instantiating new array of 'size'

                    Scanner sc2 = new Scanner(System.in);

                    int q=0;
                    while (q < size) {
                        System.out.println((size-q)+" integers to input:");
                        inputArray[q]=sc2.nextInt();
                        q++;
                    }

                    BubbleSort bs1 = new BubbleSort(); //instantiating new object of class BubbleSort
                    System.out.println("Array BEFORE sorting: ");
                    bs1.printArray(inputArray);


                    System.out.println("Array AFTER sorting: ");
                    start=System.nanoTime();
                    bs1.bubbleSort(inputArray);
                    end=System.nanoTime()-start;
                    System.out.println("bubble sort took "+end+" nanoseconds");

                    bs1.printArray(inputArray);
                    System.out.println();

                    //Main mn1 = new Main();
                    mn1.showMenu();

                    break;

                case 2:

                    FileReader newFile = new FileReader("emp.txt");
                    //count number of lines in the file
                    BufferedReader reader = new BufferedReader(newFile);
                    int lines = 0; //holds number of lines in the file

                    while (reader.readLine() != null) lines++;
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Employee [] empList1 = new Employee[lines-1]; //array of objects of class Employee

                    //read emp.txt file
                    File inpFile = new File("emp.txt");
                    Scanner inpScanner = new Scanner(inpFile);
                    //reading by lines
                    String nextLine = inpScanner.nextLine();

                    int empCounter = 0; //employee counter
                    while (inpScanner.hasNextLine()) {
                        //
                        //System.out.println("Next line:" +nextLine);

                        //splitting line into parts and writing to array
                        String [] empAttr = nextLine.split(" ");

                        //instantiating new Employee
                        Employee employee = new Employee(Integer.parseInt(empAttr[1]), empAttr[0]);

                        //adding instantiated familyCar to the familyCarInventory array
                        empList1[empCounter] = employee;

                        empCounter++;
                        nextLine = inpScanner.nextLine();
                    } //end of while loop


                    System.out.println("Before sorting: " + Arrays.toString(empList1));
                    start=System.nanoTime();
                    Arrays.sort(empList1);
                    end=System.nanoTime()-start;
                    System.out.println("After sorting: " + Arrays.toString(empList1));
                    System.out.println("Sorting for array of employees took "+end+" nanoseconds");
                    System.out.println();
                    System.out.println();


                    mn1.showMenu();

                    break;

                default:
                    mn1.showMenu();
                    break;
            }//end of switch



        }//end of showMenu while loop


    }//end of main method
}
