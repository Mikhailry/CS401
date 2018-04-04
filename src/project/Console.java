package project;

import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        Console console = new Console();
        console = console.showMainMenu(console);
        System.out.println("Exiting application");
    } //end of main method

    private Console showMainMenu(Console console) {
        System.out.println("\nWelcome to the GPAMS (Grade Point Average Management) system");

        int selection = 0; //variable to store selection

        do {
            System.out.println("[1] Roster creation\n"
                              +"[2] Grade input\n"
                              +"[3] Record search\n"
                              +"[4] Show list\n"
                              +"[5] Create Travelling list\n"
                              +"[6] Exit\n");

            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();
            switch (selection) {
                case 1: return console.showMenu1(console);
                case 2: return console.showMenu2(console);
                case 3: return console.showMenu3(console);
                case 4: return console.showMenu4(console);
                case 5: return console.showMainMenu(console);
                case 6: return console;
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }
        } while (selection != 6);
        return console;
    }//end of showMainMenu

    //submenu1 method
    private Console showMenu1(Console console) {
        System.out.println("\nHow do you want to create roster?");

        int selection = 0;

        do {
            System.out.println("[1] Manual data feed\n"
                              +"[2] Default settings\n"
                              +"[3] Back to main menu\n");

            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
                case 1: return console.showMenu1(console);
                case 2: return console.showMenu1(console);
                case 3: return console.showMainMenu(console);
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }
        } while (selection != 3);
        return console;
    }//end of showMenu1

    //submenu2 method
    private Console showMenu2(Console console) {
        System.out.println("\nHow do you want to input grades?");

        int selection = 0;

        do {
            System.out.println("[1] From file\n"
                              +"[2] Grade input\n"
                              +"[3] Back to main menu\n");

            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
                case 1: return console.showMenu2(console);
                case 2: return console.showMenu2(console);
                case 3: return console.showMainMenu(console);
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }
        } while (selection != 3);
        return console;
    }//end of showMenu2

    //submenu3 method
    private Console showMenu3(Console console) {
        System.out.println("\nHow do you want to search for records?");

        int selection = 0;

        do {
            System.out.println("[1] By first name\n"
                              +"[2] By last name\n"
                              +"[3] By SID\n"
                              +"[4] Back to main menu\n");

            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
                case 1: return console.showMenu3(console);
                case 2: return console.showMenu3(console);
                case 3: return console.showMenu3(console);
                case 4: return console.showMainMenu(console);
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }
        } while (selection != 4);
        return console;
    }//end of showMenu3

    //submenu4 method
    private Console showMenu4(Console console) {
        System.out.println("\nPlease make your choice: ");

        int selection = 0;

        do {
            System.out.println("[1] Scoring weight by item\n"
                              +"[2] Sorted list by last name\n"
                              +"[3] Rankings by total score\n"
                              +"[4] Rankings by homework average\n"
                              +"[5] Ranking by project score\n"
                              +"[6] Back to main menu\n");

            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
                case 1: return console.showMenu4(console);
                case 2: return console.showMenu4(console);
                case 3: return console.showMenu4(console);
                case 4: return console.showMenu4(console);
                case 5: return console.showMenu4(console);
                case 6: return console.showMainMenu(console);
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }
        } while (selection != 6);
        return console;
    }//end of showMenu4

}