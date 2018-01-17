package lab1;

import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int r=-1; //variable to store input of radius
        boolean wrongInput=true; //true while user does the right input

        //Declare an ArrayList of type Circle to hold all created circles
        ArrayList<Circle> listOfCircles = new ArrayList();


        Circle circle1 = new Circle(); //instantiating first object
        Circle circle2 = new Circle(); //instantiating second object
        listOfCircles.add(circle1);
        listOfCircles.add(circle2);


        for (int counter=1; counter<listOfCircles.size()+1; counter++ ) {

            wrongInput=true;

            while (wrongInput) {

                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter 'Circle"+counter+" radius:");
                    r = sc.nextInt();

                    if (r == (int) r) {

                        listOfCircles.get(counter-1).setR(r);

                        listOfCircles.get(counter-1).calcCircleArea(r);

                        wrongInput = false;
                    }


                } catch (IndexOutOfBoundsException exception) {
                    System.out.print("IndexOutOfBounds\n");
                } catch (InputMismatchException exception) {
                    System.out.print("InputMismatch\n");
                }

            }

        }


        System.out.println(circle1.toString());
        System.out.println(circle2.toString());

        if (circle1.getR()==(circle2.getR())) {
            System.out.println("Areas of the circles are the same");
        }

        else {
            System.out.println("Areas of the circles are different");
        }


    }
}
