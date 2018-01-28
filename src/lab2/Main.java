package lab2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int iD;
        String name;
        boolean wrongInput=true; //true while user does the right input

        //!!!!!the section below is for testing purposes
        //instantiating objects
        //Employee employee1 = new Employee(001, "John");
        //Employee employee2 = new Employee(002, "Sara");
        //Employee employee3 = new Employee(003, "John");


        //Declare an ArrayList of type Employee to hold all created employees
        ArrayList<Employee> listOfEmployees = new ArrayList<>();

        //instantiating new employees
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        //adding new employees to the list
        listOfEmployees.add(employee1);
        listOfEmployees.add(employee2);

        //user input

        boolean repeat = true;
        while (repeat) {

            for (int counter = 1; counter < listOfEmployees.size() + 1; counter++) {

                wrongInput = true;

                Scanner scName = new Scanner(System.in);
                System.out.println("Enter Employee" + counter + " name:");
                listOfEmployees.get(counter - 1).setName(scName.next());


                while (wrongInput) {

                    try {
                        Scanner scId = new Scanner(System.in);
                        System.out.println("Enter Employee" + counter + " ID:");
                        iD = scId.nextInt();

                        if (iD == (int) iD) {
                            listOfEmployees.get(counter - 1).setiD(iD);
                            wrongInput = false;
                        }

                    } catch (IndexOutOfBoundsException exception) {
                        System.out.print("IndexOutOfBounds\n");
                    } catch (InputMismatchException exception) {
                        System.out.print("InputMismatch\n");
                    }

                } //end of while loop 'Wrong Input'

            } // end of for loop for Arraylist itteration


            System.out.println("\nComparison using equals method:");
            employee1.equals(employee2); //equals method


            System.out.println("\nComparison using compareTo:");
            int result1 = employee1.compareTo(employee2); //compareTo method

            if (result1 == 0) {
                System.out.println("Employees are equal");
            } else {
                System.out.println("Employees are NOT equal");
            }


            System.out.println("\nComparison using Comparator:");
            int result2  = Employee.EmpComparator.compare(employee1, employee2);

            if (result2 == 0) {
                System.out.println("Employees are equal");
            } else {
                System.out.println("Employees are NOT equal");
            }

            System.out.println();
            System.out.println(employee1.toString());
            System.out.println(employee2.toString());

            System.out.println("\nDo you want to repeat input?");
            System.out.println("1:Yes || 2:Quit");
            Scanner scRepeat = new Scanner(System.in);

            if (scRepeat.nextInt() != 1){
                repeat = false;
            }

        }

    } //end of main method
}
