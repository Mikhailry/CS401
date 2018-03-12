package lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
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
                + "5. Convert infix expressions to postfix and print results\n"
                + "6. Evaluate whether expression is a palindrome\n"
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

                    try {
                        System.out.println("Input target ID: ");
                        Scanner sc1 = new Scanner(System.in);
                        target = sc1.nextInt();
                    }catch (IndexOutOfBoundsException exception) {
                        System.out.print("IndexOutOfBounds\n");
                    } catch (InputMismatchException exception) {
                        System.out.print("InputMismatch\n");
                    }

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
                    String exp1 = "1+3*8";
                    String exp2 = "8-3-4*6+3";
                    String exp3 = "4*(5-(7+2))";

                    //convert infix to postfix
                    String exp1Conv = InfixToPostfix.infixToPostfix(exp1);
                    String exp2Conv = InfixToPostfix.infixToPostfix(exp2);
                    String exp3Conv = InfixToPostfix.infixToPostfix(exp3);

                    //calculate result for postfix
                    int exp1Res=PostFixEvaluator.evaluate(exp1Conv);
                    int exp2Res=PostFixEvaluator.evaluate(exp2Conv);
                    int exp3Res=PostFixEvaluator.evaluate(exp3Conv);

                    System.out.println("For expression "+exp1+" Postfix expression is "+exp1Conv+" and result is "+exp1Res);
                    System.out.println("For expression "+exp2+" Postfix expression is "+exp2Conv+" and result is "+exp2Res);
                    System.out.println("For expression "+exp3+" Postfix expression is "+exp3Conv+" and result is "+exp3Res);
                    System.out.println();

                    mn1.showMenu();
                    break;

                case 6:

                    String expression;
                        System.out.println("Detect if String is a Palindrome.");
                        System.out.println("Enter expression for evaluation: ");
                        Scanner sc2 = new Scanner(System.in);
                        expression = sc2.nextLine();
                        boolean isPalindrome = Palindrome.palEval(expression);

                        if (isPalindrome) {
                            System.out.println("Expression you've entered is a palindrome.\n");
                        } else {
                            System.out.println("Expression you've entered is NOT a palindrome.\n");
                        }

                    mn1.showMenu();
                    break;

//                case 7:
//
//
//                    mn1.showMenu();
//                    break;
//
//                case 8:
//
//
//                    mn1.showMenu();
//                    break;
//
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
}
