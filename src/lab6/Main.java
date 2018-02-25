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
                + "5. Read file (emp.txt) and add Employee obj on queue (LL)\n"
                + "6. Read file (emp.txt) and Enqueue to Fixed front Array\n"
                + "7. Dequeue with Fixed front Array\n"
                + "8. Read file (emp.txt) and Enqueue to Floating front Array\n"
                + "9. Dequeue with Floating front Array\n"
                + "0. Exit program\n");
    }

    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer

        Main mn1 = new Main();
        mn1.showMenu();

        //LinkedStack instantiation
        StackInterface<Employee> empStack;
        empStack=new LinkedStack();

        //ArrayBoundedQueue instantiation
        QueueInterface<Employee> empQueue;
        empQueue = new ArrayBoundedQueue<Employee>();

        //FixedFrontArrayQueue instantiation
        QueueInterface<Employee> empFixedQueue;
        empFixedQueue = new FixedFrontArrayQueue<Employee>();

        //LinkedList queue
        QueueInterface empLLQueue;
        empLLQueue = new LinkedQueue();

        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 0) {

            switch (n){

                case 1:

                    //read emp.txt file
                    File inpFile = new File("emp.txt");
                    Scanner inpScanner = new Scanner(inpFile);

                    while (inpScanner.hasNextLine()) {

                        String nextLine = inpScanner.nextLine();

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
                    try {
                        System.out.println("Peek - Look at the top object...");
                        System.out.println("Top element: " + empStack.top());
                        System.out.println();
                        System.out.println();
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                case 3:
                    try {
                        System.out.println("3. POP and show the top...");
                        empStack.pop();
                        System.out.println("Top element: " + empStack.top());
                        System.out.println();
                        System.out.println();
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                        System.out.println();
                    }

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
                    //read emp.txt file
                    File inpFile1 = new File("emp.txt");
                    Scanner inpScanner1 = new Scanner(inpFile1);

                    while (inpScanner1.hasNextLine()) {

                        String nextLine1 = inpScanner1.nextLine();

                        //splitting line into parts and writing to array
                        String [] empAttr = nextLine1.split(" ");

                        //instantiating new Employee
                        Employee employee = new Employee(Integer.parseInt(empAttr[1]), empAttr[0]);

                        //adding instantiated employee to the queue
                        empLLQueue.enqueue(employee);

                    } //end of while loop

                    System.out.println("Done! Employees have been added to the LinkedList.\n");

                    mn1.showMenu();
                    break;

                case 6:
                    //read emp.txt file
                    File inpFile2 = new File("emp.txt");
                    Scanner inpScanner2 = new Scanner(inpFile2);

                    while (inpScanner2.hasNextLine()) {

                        String nextLine2 = inpScanner2.nextLine();

                        //splitting line into parts and writing to array
                        String [] empAttr = nextLine2.split(" ");

                        //instantiating new Employee
                        Employee employee = new Employee(Integer.parseInt(empAttr[1]), empAttr[0]);

                        //adding instantiated employee to the queue
                        empFixedQueue.enqueue(employee);

                    } //end of while loop

                    System.out.println("Done! Test Queue operations from the menu.\n");

                    mn1.showMenu();
                    break;

                case 7:
                    try {
                        System.out.println("7. Dequeue Employee...");
                        Employee empTest3 = empFixedQueue.dequeue();
                        System.out.println(empTest3 + " removed from queue\n");
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
                        System.out.println();
                    }

                    mn1.showMenu();
                    break;

                case 8:
                    //read emp.txt file
                    File inpFile3 = new File("emp.txt");
                    Scanner inpScanner3 = new Scanner(inpFile3);

                    while (inpScanner3.hasNextLine()) {

                        String nextLine3 = inpScanner3.nextLine();

                        //splitting line into parts and writing to array
                        String [] empAttr = nextLine3.split(" ");

                        //instantiating new Employee
                        Employee employee = new Employee(Integer.parseInt(empAttr[1]), empAttr[0]);

                        //adding instantiated employee to the queue
                        empQueue.enqueue(employee);

                    } //end of while loop

                    System.out.println("Done! Test Queue operations from the menu.\n");

                    mn1.showMenu();
                    break;

                case 9:
                    try {
                        System.out.println("9. Dequeue Employee...");
                        Employee empTest2 = empQueue.dequeue();
                        System.out.println(empTest2 + " removed from queue\n");
                    }
                    catch (Exception e) {
                        System.out.println("Error : " + e.getMessage());
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
}
