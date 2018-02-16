package lab5;

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

        System.out.println("1. Calculate Jacobsthal numbers recursive\n"
                + "2. Calculate Jacobsthal numbers iterative\n"
                + "3. Array smallest value recursive\n"
                + "4. Exit program\n");
    } //end of showMenu method


    public static long Jacobsthal_recursive(int n){

        //variable to store result
        long recursiveResult=0;

        //precondition n>=0
        if (n==0) {
            return (0);
        } else if (n==1){
            return (1);
        } else {
            return recursiveResult=Jacobsthal_recursive(n-1)+ 2*Jacobsthal_recursive(n-2);
        }

    }//end of Jacobsthal_recursive method

    public static long Jacobsthal_iterative(int n){

        long firstElement=0;
        long secondElement=1;
        long nextElement=0;
        long iterativeResult=0;
        double start,end=0; //variables to measure complexity

        System.out.println("Jacobsthal number sequence for n="+n+":");
        System.out.print(firstElement+", "+secondElement);

        start=System.nanoTime();
        for (int i = 0; i<n-2; i++){

            nextElement=2*firstElement+secondElement;
            System.out.print(", "+nextElement);
            firstElement=secondElement;
            secondElement=nextElement;

        }//end of for loop
        end=System.nanoTime()-start;
        System.out.println("\nIterative method took "+end+" nanoseconds\n");

        return iterativeResult;
    }//end of Jacobsthal iterative method

    public static int minimum(int A[], int size){

        if (size==1) {
            return A[0];
        }

        for (int i=0; i<size-1; i++){

            if (A[i]>A[i+1]){
                int temp=A[i];
                A[i]=A[i+1];
                A[i+1]=temp;
            }

        }//end of for loop
        minimum(A, size-1);
        return A[0];
    }//end of method minimum


    public static void main(String[] args) throws IOException {


        int n=-1; //store input integer
        int size=0; //size of sequence
        double start,end=0; //variables to measure complexity

        Main mn1 = new Main();
        mn1.showMenu();

        Scanner input = new Scanner(System.in);
        while ((n = input.nextInt()) != 4) {

            switch (n){

                case 1:
                    System.out.println("Enter the Jacobsthal number sequence size (greater or equal than zero): ");
                    Scanner sc1 = new Scanner(System.in);
                    size = sc1.nextInt();

                    start=System.nanoTime();
                    Jacobsthal_recursive(size);
                    System.out.println("Jacobsthal number sequence for n="+size+":");

                    int i=0;
                    while (i<size){
                        System.out.print(Jacobsthal_recursive(i));
                        i++;
                        if (i<size) {System.out.print(", "); }
                    }//end of while loop
                    end=System.nanoTime()-start;

                    System.out.println("\nRecursive method took "+end+" nanoseconds");

                    mn1.showMenu();
                    break;

                case 2:

                    System.out.println("Enter the Jacobsthal number sequence size (greater or equal than zero): ");
                    Scanner sc2 = new Scanner(System.in);
                    size = sc2.nextInt();
                    Jacobsthal_iterative(size);


                    mn1.showMenu();
                    break;

                case 3:

                    int A[]={10,-20,1,2,0,5,100};
                    int s = minimum(A, A.length);
                    System.out.println("Smallest number of the array: "+s+"\n");

                    mn1.showMenu();
                    break;

                default:

                    mn1.showMenu();
                    break;
            }//end of switch


        }//end of showMenu while loop


    }//end of main method
}
