package lab4;

import java.io.File;
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

        System.out.println("1. Read file for names and IDs: (emp.txt)\n"
                + "2. Peek - Look at the top object\n"
                + "3. POP TWO items and Peek at the top\n"
                + "4. POP one item\n"
                + "5. Check if Stack is Empty\n"
                + "6. Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer

        Main mn1 = new Main();
        mn1.showMenu();
        StackInterface<Employee> empStack;
        empStack=new ArrayListStack<Employee>();

        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 6) {

            switch (n){

                case 1:

                    //read emp.txt file
                    File inpFile = new File("emp.txt");
                    Scanner inpScanner = new Scanner(inpFile);

                    //reading by lines
                    String nextLine = inpScanner.nextLine();

                    //String line = null;
                    while (inpScanner.hasNextLine()) {

                        nextLine = inpScanner.nextLine();

                        //splitting line into parts and writing to array
                        String [] empAttr = nextLine.split(" ");

                        //instantiating new Employee
                        Employee employee = new Employee(Integer.parseInt(empAttr[1]), empAttr[0]);

                        //adding instantiated employee to the stack
                        empStack.push(employee);

                    } //end of while loop


                    mn1.showMenu();
                    break;

                case 2:
                    System.out.println("Peek - Look at the top object...");
                    System.out.println("Top element: " + empStack.peek());
                    System.out.println();
                    System.out.println();
                    mn1.showMenu();
                    break;

                case 3:
                    System.out.println("3. POP TWO items and Peek at the top...");
                    empStack.pop();
                    empStack.pop();
                    System.out.println("Top element: " + empStack.peek());
                    System.out.println();
                    System.out.println();
                    mn1.showMenu();
                    break;

                case 4:
                    System.out.println("4. POP one item...");
                    empStack.pop();
                    System.out.println("Top element: " + empStack.peek());
                    System.out.println();
                    System.out.println();
                    mn1.showMenu();
                    break;

                case 5:
                    if (empStack.isEmpty()){
                        System.out.println("Stack is Empty");
                    }
                    else{
                        System.out.println("Stack is not empty");
                    }
                    break;
                default:
                    mn1.showMenu();
                    break;
            }//end of switch


        }//end of showMenu while loop


    }//end of main method
}
