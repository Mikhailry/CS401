package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    //ArrayList to store rosters
    ArrayList <Roster> rosters = new ArrayList<>();

    //ArrayList to store students
    ArrayList <Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Console console = new Console();
        console = console.showMainMenu(console);

        System.out.println("Exiting application");

    } //end of main method

    private Console showMainMenu(Console console) throws IOException {
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
    private Console showMenu1(Console console) throws IOException {
        System.out.println("\nHow do you want to create roster?");

        int selection = 0;
        int n=-1; //store input integer for case1
        boolean incInput = true; //variable for while loop


        do {
            System.out.println("[1] Manual data feed\n"
                              +"[2] Default settings\n"
                              +"[3] Back to main menu\n");

            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    //variables for input parameters
                    int numberOfSites=0;
                    int studentsSites01 = 0;
                    int studentsSites02 = 0;
                    int studentsSites03 = 0;
                    int totalClassSize = 0;
                    int numberOfAssignments = 0;
                    int numberOfProjects = 0;
                    int numberOfExams = 0;
                    String classN;

                    System.out.println("Creating a roster");
                    System.out.println("-----------------");
                    System.out.println("PLease, enter the class number, for example 'CS401' :");
                    Scanner input1 = new Scanner(System.in);
                    classN = input1.next();

                    /*number of sites should be in the interval [1:3]*/
                    while (incInput) {
                        System.out.print("Enter number of sites:");
                        numberOfSites = input1.nextInt();
                        if (numberOfSites < 1 || numberOfSites >3) {
                            System.out.println("Please choose at least 1 and up to 3 sites");
                        } else {
                            incInput = false;
                        }
                    }

                    if (numberOfSites == 3) {
                        System.out.println("Please enter the number of students per site 01 :");
                        studentsSites01=input1.nextInt();
                        System.out.println("Please enter the number of students per site 02 :");
                        studentsSites02=input1.nextInt();
                        System.out.println("Please enter the number of students per site 03 :");
                        studentsSites03=input1.nextInt();
                    } else if (numberOfSites == 2) {
                        System.out.println("Please enter the number of students per site 01 :");
                        studentsSites01=input1.nextInt();
                        System.out.println("Please enter the number of students per site 02 :");
                        studentsSites02=input1.nextInt();
                        studentsSites03=0;
                    } else {
                        System.out.println("Please enter the number of students per site 01 :");
                        studentsSites01=input1.nextInt();
                        studentsSites02=0;
                        studentsSites03=0;
                    }
                    totalClassSize = studentsSites01 + studentsSites02 + studentsSites03;

                    System.out.println("Please enter the number of assignments :");
                    numberOfAssignments=input1.nextInt();

                    System.out.println("Please enter the number of projects :");
                    numberOfProjects=input1.nextInt();


                    incInput=true;
                    while (incInput) {
                        System.out.print("Enter number of exams:");
                        numberOfExams = input1.nextInt();
                        if (numberOfExams < 0 || numberOfExams >2) {
                            System.out.println("If you don't plan exams - input '0'\n" +
                                    "For one exam, which will be considered as final - 1\n" +
                                    "For two exams, midterm and final - 2");
                        } else {
                            incInput = false;
                        }
                    }

                    //creating new roster
                    Roster roster = new Roster(numberOfSites, studentsSites01, studentsSites02, studentsSites03, totalClassSize, numberOfAssignments, numberOfProjects, numberOfExams, classN);

                    //add new roster to the rosters
                    rosters.add(roster);

                    return console.showMenu1(console);
                case 2:
                    System.out.println("Creating a default roster");
                    System.out.println("-------------------------");
                    System.out.println("PLease, enter the class number, for example 'CS401' :");
                    Scanner input2 = new Scanner(System.in);
                    classN = input2.next();
                    Roster roster2 = new Roster(classN);

                    System.out.println("Roster " + classN + " with default settings has been created\n"
                            + "Number of sites: 3\n"
                            + "Number of students per site 01: 10\n"
                            + "Number of students per site 02: 5\n"
                            + "Number of students per site 03: 5\n"
                            + "Total class size: 20\n"
                            + "Number of assignments: 10\n"
                            + "Number of projects: 1\n"
                            + "Number of exams: 2\n");

                    rosters.add(roster2);

                    return console.showMenu1(console);
                case 3: return console.showMainMenu(console);
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }
        } while (selection != 3);
        return console;
    }//end of showMenu1

    //submenu2 method
    private Console showMenu2(Console console) throws IOException {
        System.out.println("\nHow do you want to input grades?");

        int selection = 0;
        int lines=0;

        int numberOfHW = 0;
        int numberOfPr = 0;
        int numberOfEx =0;
        int totalHwScore = 0;
        float hwAvg = 0;
        int totalprojScore = 0;
        int midtermExamScore = 0;
        int finalExamScore = 0;
        int totalScore = 0;

        int [] hwScores;
        int [] projScores;
        int [] examScores;

        do {
            System.out.println("[1] From file\n"
                              +"[2] Grade input\n"
                              +"[3] Back to main menu\n");

            System.out.print("Enter your choice: ");
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    //implement set path to file


                    /*Precondition:
                    * gardes file should have the following structure:
                    * FirstName LastName sid class site hw1 hw2 hwn project1 projectn exam1 exam2
                    *
                    * [0]     [1]    [2]        [3]  [4]   [5] [6]  [7]  [8] [9]  [10] [11] [12] [13] [14]  [15]  [16]  [17]  [18] [19]
                    * First   Last    sid       class site  hw1 hw2  hw3  hw4 hw5  hw6  hw7  hw8  hw9  hw10  hw11  hw12  proj  mid  fin
                    * Michael Jordan 9998887777 CS401  01   10  9    8    10   9   9    8    7    7    9     10    9     18    88    95
                    * */


                    FileReader newFile = new FileReader("grades.txt");
                    //count number of lines in the file
                    BufferedReader reader = new BufferedReader(newFile);


                    while (reader.readLine() != null) lines++;
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Student [] studList1 = new Student[lines]; //array of objects of class Student
                    int studCounter = 0; //students counter

                    //read grades.txt file
                    File inpFile = new File("grades.txt");
                    Scanner inpScanner = new Scanner(inpFile);

                    while (inpScanner.hasNextLine()) {

                        String nextLine = inpScanner.nextLine();

                        //splitting line into parts and writing to array
                        String [] studAttr = nextLine.split(" ");

                        //get the class number
                        String classN = studAttr[3];

                        //get number of HWs, projects and exams for that class
                        for (int r=0; r<rosters.size(); r++) {
                            if (rosters.get(r).classNumber == classN) {
                                numberOfHW = rosters.get(r).numberOfAssignments;
                                numberOfPr = rosters.get(r).numberOfProjects;
                                numberOfEx = rosters.get(r).numberOfExams;
                            } else {
                                System.out.println("Class number has not been found.");
                            }
                        }

                        //adding HW scores to an array
                        hwScores = new int [numberOfHW];
                        for (int hws=0; hws<numberOfHW; hws++){
                            hwScores[hws] = Integer.parseInt(studAttr[hws+5]);
                            totalHwScore = totalHwScore + hwScores[hws];
                        }
                        // calculating hw avg
                        hwAvg = totalHwScore/numberOfHW;


                        //adding Project scores to an array
                        projScores = new int [numberOfPr];
                        for (int prs=0; prs<numberOfPr; prs++){
                            projScores[prs] = Integer.parseInt(studAttr[5+numberOfHW+prs]);
                            totalprojScore = totalprojScore + projScores[prs];
                        }

                        //adding exam scores to an array
                        examScores = new int [numberOfEx];
                        for (int exs=0; exs<numberOfEx; exs++){
                            examScores[exs] = Integer.parseInt(studAttr[5+numberOfHW+numberOfPr+exs]);
                        }

                        //extracting exam scores
                        /*Precondition:
                        *number of exams is in the interval [0:2]
                        * */
                        if (numberOfEx==2) {
                            midtermExamScore = examScores[0];
                            finalExamScore = examScores[1];
                        } else if (numberOfEx==1){
                            finalExamScore = examScores[0];
                        } else {
                            midtermExamScore=0;
                            finalExamScore=0;
                        }

                        //calculating total score
                        totalScore = totalHwScore + totalprojScore + midtermExamScore + finalExamScore;

                        //instantiating new Student
                        //public Student(String firstName, String lastName, int sid, String classNumber, int siteNumber, int[] hwScores, int totalHwScore, float hwAvg, int [] projScores, int totalProjectScore, int midtermExamScore, int finalExamScore, int totalScore)

                        // [0]     [1]    [2]        [3]  [4]   [5] [6]  [7]  [8] [9]  [10] [11] [12] [13] [14]  [15]  [16]  [17]  [18] [19]
                        //First   Last    sid       class site  hw1 hw2  hw3  hw4 hw5  hw6  hw7  hw8  hw9  hw10  hw11  hw12  proj  mid  fin
                        //Michael Jordan 9998887777 CS401  01   10  9    8    10   9   9    8    7    7    9     10    9     18    88    95
                        Student student = new Student(studAttr[0], studAttr[1], Integer.parseInt(studAttr[2]), studAttr[3], Integer.parseInt(studAttr[4]), hwScores, totalHwScore, hwAvg, projScores, totalprojScore, midtermExamScore, finalExamScore, totalScore);

//                        //adding instantiated employee to the LinkedList
//                        empLL.add(employee);
//                        //empLL.printList(); //print LinkedList after each insertion
//                        System.out.println();
//                        empCounter++;
                        //nextLine = inpScanner.nextLine();

                    } //end of while loop

                    System.out.println("Grades have been added.\n");

                    //-----------------------------------------
                    return console.showMenu2(console);
                case 2: return console.showMenu2(console);
                case 3: return console.showMainMenu(console);
                default:
                    System.out.println("Invalid selection. Please try again.\n");
            }
        } while (selection != 3);
        return console;
    }//end of showMenu2

    //submenu3 method
    private Console showMenu3(Console console) throws IOException {
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
                case 1:

                    return console.showMenu3(console);
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
    private Console showMenu4(Console console) throws IOException {
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