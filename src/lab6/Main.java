package lab6;

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

        System.out.println("1. Read file (emp.txt) and push Employee obj on stack (LL)\n"
                + "2. Peek\n"
                + "3. Pop and show the top\n"
                + "4. Push and show the top\n"
                + "5. Read file (emp.txt) and push Employee obj on queue (LL)\n"
                + "5. Enqueue with Fixed front Array\n"
                + "6. Dequeue with Fixed front Array\n"
                + "7. Enqueue with Floating front Array\n"
                + "8. Dequeue with Floating front Array\n"
                + "9. Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer

        Main mn1 = new Main();
        mn1.showMenu();
        StackInterface<Employee> empStack;
        empStack=new LinkedStack();

        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 9) {

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
                        //empStack.push(employee);
                        empStack.push(employee);

                    } //end of while loop

                    System.out.println("Done! Test Stack operations from the menu.\n");
                    mn1.showMenu();
                    break;

                case 2:
                    System.out.println("Peek - Look at the top object...");
                    System.out.println("Top element: " + empStack.top());
                    System.out.println();
                    System.out.println();
                    mn1.showMenu();
                    break;

                case 3:
                    System.out.println("3. POP and show the top...");
                    empStack.pop();
                    System.out.println("Top element: " + empStack.top());
                    System.out.println();
                    System.out.println();
                    mn1.showMenu();
                    break;

                case 4:
                    System.out.println("4. Push new Employee Mikhail and show the top...");
                    Employee empTest = new Employee(1234567890, "Mikhail");
                    empStack.push(empTest);
                    System.out.println("Top element: " + empStack.top());
                    System.out.println();
                    System.out.println();
                    mn1.showMenu();
                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                default:
                    mn1.showMenu();
                    break;
            }//end of switch


        }//end of showMenu while loop


    }//end of main method
}
