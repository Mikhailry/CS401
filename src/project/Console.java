package project;

//library to split output stream to write log of console operations
import org.apache.commons.io.output.TeeOutputStream;

import java.io.*;
import java.util.*;

public class Console {

    //ArrayList to store rosters
    ArrayList <Roster> rosters = new ArrayList<>();

    //ArrayList to store students
    ArrayList <Student> students = new ArrayList<>();

    //ArrayList to store search results for students
    ArrayList <Student> foundStudents = new ArrayList<>();

    //ArrayList to store grade items
    ArrayList <GradeItems> gradeItems = new ArrayList<>();

    //LinkedList of students instantiation
    LinkedList stuLL = new LinkedList();

    public static void main(String[] args) throws IOException {

        //creating file to store log
        File f = new File("log.txt");
        if(!f.exists())
        {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //creating output stream splitter to write to console and file
        try {
            FileOutputStream fos = new FileOutputStream(f);
            TeeOutputStream myOut=new TeeOutputStream(System.out, fos);
            PrintStream ps = new PrintStream(myOut, true); //true - auto-flush after println
            System.setOut(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Console console = new Console();
        console = console.showMainMenu(console);

        System.out.println("Exiting application");

    } //end of main method

    private Console showMainMenu(Console console) throws IOException {
        try {
            System.out.println("\nWelcome to the GPAMS (Grade Point Average Management) system");

            int selection = 0; //variable to store selection for main menu
            int moves = -1; //variable to store value of moves for travelling list
            int curInd = 0;//variable to store current index for travelling list

            do {
                System.out.println("[1] Roster creation\n"
                        + "[2] Grade input\n"
                        + "[3] Record search\n"
                        + "[4] Show list\n"
                        + "[5] Create Travelling list\n"
                        + "[6] Exit\n");

                System.out.print("Enter your choice: ");
                Scanner input = new Scanner(System.in);
                selection = input.nextInt();
                switch (selection) {
                    case 1:
                        return console.showMenu1(console);
                    case 2:
                        if (rosters.size() > 0)
                            return console.showMenu2(console);
                        else {
                            System.out.println("Please create at least one roster from menu [1]");
                            return console.showMainMenu(console);
                        }
                    case 3:
                        if (students.size() > 0)
                            return console.showMenu3(console);
                        else {
                            System.out.println("Please input grades first from menu [2]");
                            return console.showMainMenu(console);
                        }
                    case 4:
                        if (students.size() > 0)
                            return console.showMenu4(console);
                        else {
                            System.out.println("Please input grades first from menu [2]");
                            return console.showMainMenu(console);
                        }
                    case 5:
                        if (students.size() > 0) {

                            //read ArrayList and add students to LinkedList
                            for (int i = 0; i < students.size(); i++) {

                                stuLL.add(students.get(i));

                            }//end of for loop iterating over students list

                            System.out.println("Here is the list :");
                            //printing Linked list of students
                            printList(stuLL);

                            System.out.println();
                            System.out.println();
                            System.out.println("Current location is :");
                            //printing current location in Linked List
                            printListInd(stuLL, curInd);
                            System.out.println();
                            System.out.println();

                            while (moves != 0) {
                                //getting value and direction to travel list
                                try {
                                    System.out.println("How far and which direction do you want to travel in the list?\n"
                                            + "e.g. input '3' to move 3 students FORWARD in the list\n"
                                            + "input '-3' to move 3 students BACKWARDS in the list\n"
                                            + "to exit input '0' ");
                                    Scanner input5 = new Scanner(System.in);
                                    moves = input5.nextInt();
                                } catch (InputMismatchException exception) {
                                    System.out.print("Incorrect input, please try again\n");
                                }

                                try {
                                    if (students.get(moves + curInd) == null) {
                                        System.out.println("Sorry, index is out of scope");
                                    } else if (moves > 0) {
                                        //moving forward
                                        System.out.print("Travel :");

                                        //printing current index
                                        printListInd(stuLL, curInd);
                                        for (int m = 0; m < moves; m++) {
                                            System.out.print(" -> ");
                                            printListInd(stuLL, curInd + m + 1);
                                        }
                                        curInd = curInd + moves;
                                        System.out.println();
                                        System.out.println();
                                    } else if (moves < 0) {
                                        //moving backwards
                                        System.out.print("Travel :");

                                        //printing current index
                                        printListInd(stuLL, curInd + moves);
                                        for (int m = 0; m < -moves; m++) {
                                            System.out.print(" <- ");
                                            printListInd(stuLL, curInd + moves + m + 1);
                                        }

                                        curInd = curInd + moves;
                                        System.out.println();
                                        System.out.println();
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Sorry, index is out of scope");
                                    System.out.println();
                                }
                            }//end of while loop over travelling
                        } else {
                            System.out.println("Please input grades first from menu [2]");
                        }
                        return console.showMainMenu(console);
                    case 6:
                        //exit application
                        return console;
                    default:
                        System.out.println("Invalid selection. Please try again.\n");
                }
            } while (selection != 6);
            return console;
        }catch (InputMismatchException e){
            System.out.println("Invalid selection. Please try again.\n");
            return console.showMainMenu(console);
        }
        }//end of showMainMenu

    //submenu1 method
    private Console showMenu1(Console console) throws IOException {
        try {
            System.out.println("\nHow do you want to create roster?");

            int selection = 0;
            int n = -1; //store input integer for case1
            boolean incInput = true; //variable for while loop


            do {
                System.out.println("[1] Manual data feed\n"
                        + "[2] Default settings\n"
                        + "[3] Back to main menu\n");

                System.out.print("Enter your choice: ");
                Scanner input = new Scanner(System.in);
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        //variables for input parameters
                        int numberOfSites = 0;
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

                    /*
                    * Only unique roster names are allowed.
                    * */
                        boolean checkRoster = true; //to continue asking for a unique name for roster
                        System.out.println("Please, enter the class number, e.g. 'CS401' :");
                        Scanner input1 = new Scanner(System.in);
                        classN = input1.next();
                        while (checkRoster) {
                            if (rosters.size() > 0) {
                                for (int r = 0; r < rosters.size(); r++) {
                                    if (rosters.get(r).classNumber.equalsIgnoreCase(classN)) {
                                        System.out.println("Roster already exists.");
                                        System.out.println("PLease, enter the class number, e.g. 'CS401' :");
                                        classN = input1.next();
                                    } else {
                                        checkRoster = false;
                                    }
                                }
                            } else {
                                checkRoster = false;
                            }
                        }//end of while loop checking whether the unique roster is created

                    /*
                    *number of sites should be in the interval [1:3]
                    *
                    * in case of incorrect input, e.g. char instead of digit,
                    * user should start roster creation again
                    *
                    * */
                        try {
                            while (incInput) {
                                System.out.print("Enter number of sites:");
                                numberOfSites = input1.nextInt();
                                if (numberOfSites < 1 || numberOfSites > 3) {
                                    System.out.println("Please choose at least 1 and up to 3 sites");
                                } else {
                                    incInput = false;
                                }
                            }

                            if (numberOfSites == 3) {
                                System.out.println("Please enter the number of students per site 01 :");
                                studentsSites01 = input1.nextInt();
                                System.out.println("Please enter the number of students per site 02 :");
                                studentsSites02 = input1.nextInt();
                                System.out.println("Please enter the number of students per site 03 :");
                                studentsSites03 = input1.nextInt();
                            } else if (numberOfSites == 2) {
                                System.out.println("Please enter the number of students per site 01 :");
                                studentsSites01 = input1.nextInt();
                                System.out.println("Please enter the number of students per site 02 :");
                                studentsSites02 = input1.nextInt();
                                studentsSites03 = 0;
                            } else {
                                System.out.println("Please enter the number of students per site 01 :");
                                studentsSites01 = input1.nextInt();
                                studentsSites02 = 0;
                                studentsSites03 = 0;
                            }
                            totalClassSize = studentsSites01 + studentsSites02 + studentsSites03;

                            System.out.println("Please enter the number of assignments :");
                            numberOfAssignments = input1.nextInt();

                            System.out.println("Please enter the number of projects :");
                            numberOfProjects = input1.nextInt();


                            incInput = true;
                            while (incInput) {
                                System.out.print("Enter number of exams:");
                                numberOfExams = input1.nextInt();
                                if (numberOfExams < 0 || numberOfExams > 2) {
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

                        } catch (InputMismatchException exception) {
                            System.out.print("Incorrect input, please try again\n");
                        }

                        return console.showMenu1(console);
                    case 2:
                        System.out.println("Creating a default roster");
                        System.out.println("-------------------------");

                    /*
                    * Only unique roster names are allowed.
                    * */
                        boolean checkRoster2 = true; //to continue asking for a unique name for roster
                        System.out.println("Please, enter the class number, e.g. 'CS401' :");
                        Scanner input2 = new Scanner(System.in);
                        classN = input2.next();
                        while (checkRoster2) {
                            if (rosters.size() > 0) {
                                for (int r = 0; r < rosters.size(); r++) {
                                    if (rosters.get(r).classNumber.equalsIgnoreCase(classN)) {
                                        System.out.println("Roster already exists.");
                                        System.out.println("PLease, enter the class number, e.g. 'CS401' :");
                                        classN = input2.next();
                                    } else {
                                        checkRoster2 = false;
                                    }
                                }
                            } else {
                                checkRoster2 = false;
                            }
                        }//end of while loop checking whether the unique roster is created


                        Roster roster2 = new Roster(classN);

                        System.out.println("Roster " + classN + " with default settings has been created\n"
                                + "Number of sites: 3\n"
                                + "Number of students per site 01: 10\n"
                                + "Number of students per site 02: 5\n"
                                + "Number of students per site 03: 5\n"
                                + "Total class size: 20\n"
                                + "Number of assignments: 12\n"
                                + "Number of projects: 1\n"
                                + "Number of exams: 2\n");

                        rosters.add(roster2);


                        return console.showMenu1(console);
                    case 3:
                        return console.showMainMenu(console);
                    default:
                        System.out.println("Invalid selection. Please try again.\n");
                }
            } while (selection != 3);
            return console;
        } catch (InputMismatchException e){
            System.out.println("Invalid selection. Please try again.\n");
            return console.showMenu1(console);
        }
    }//end of showMenu1

    //submenu2 method
    private Console showMenu2(Console console) throws IOException {
        try {
            System.out.println("\nHow do you want to input grades?");

            int selection = 0; //variable used to store user selection
            int lines = 0; //variable to store number of files in the input file

            do {
                System.out.println("[1] From file\n"
                        + "[2] Grade input\n"
                        + "[3] Back to main menu\n");

                System.out.print("Enter your choice: ");
                Scanner input = new Scanner(System.in);
                selection = input.nextInt();

                switch (selection) {
                    case 1:

                    /*Precondition:
                    * grades file should have the following structure:
                    * FirstName LastName sid class site hw1 hw2 hwn project1 projectn exam1 exam2
                    *
                    * [0]     [1]    [2]        [3]  [4]   [5] [6]  [7]  [8] [9]  [10] [11] [12] [13] [14]  [15]  [16]  [17]  [18] [19]
                    * First   Last    sid       class site  hw1 hw2  hw3  hw4 hw5  hw6  hw7  hw8  hw9  hw10  hw11  hw12  proj  mid  fin
                    * Michael Jordan 9998887777 CS401  01   10  9    8    10   9   9    8    7    7    9     10    9     18    88    95
                    * */

                        FileReader newFile;

                        final String dir = System.getProperty("user.dir");
                        System.out.println("You are in the directory = " + dir);
                        System.out.println("Please specify a path and filename with grades: ");

                        Scanner inpScanner0 = new Scanner(System.in);
                        String path = inpScanner0.next();
                        //newFile = new FileReader(path);

                        try {
                            newFile = new FileReader(path);
                        } catch (FileNotFoundException ex) {
                            System.out.println("File not found in the current dir = " + dir);
                            System.out.println("Returning to the previous menu.");

                            return console.showMenu2(console);
                        }


                        //count number of lines in the file
                        BufferedReader reader = new BufferedReader(newFile);

                        while (reader.readLine() != null) lines++;
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Student[] studList1 = new Student[lines]; //array of objects of class Student

                        //read grades file
                        File inpFile = new File(path);
                        Scanner inpScanner = new Scanner(inpFile);

                        try {
                            while (inpScanner.hasNextLine()) {

                                int numberOfHW = 0;
                                int numberOfPr = 0;
                                int numberOfEx = 0;
                                int totalHwScore = 0;
                                float hwAvg = 0;
                                int totalprojScore = 0;
                                int midtermExamScore = 0;
                                int finalExamScore = 0;
                                int totalScore = 0;

                                int[] hwScores;
                                int[] projScores;
                                int[] examScores;

                                String nextLine = inpScanner.nextLine();

                                //splitting line into parts and writing to array
                                String[] studAttr = nextLine.split(" ");

                                //get the class number
                                String classN = studAttr[3];

                                //get number of HWs, projects and exams for that class
                                for (int r = 0; r < rosters.size(); r++) {
                                    if (rosters.get(r).classNumber.equalsIgnoreCase(classN)) {
                                        numberOfHW = rosters.get(r).numberOfAssignments;
                                        numberOfPr = rosters.get(r).numberOfProjects;
                                        numberOfEx = rosters.get(r).numberOfExams;

                                        //adding HW scores to an array
                                        hwScores = new int[numberOfHW];
                                        for (int hws = 0; hws < numberOfHW; hws++) {
                                            hwScores[hws] = Integer.parseInt(studAttr[hws + 5]);
                                            totalHwScore = totalHwScore + hwScores[hws];
                                        }
                                        // calculating hw avg
                                        hwAvg = (float) totalHwScore / numberOfHW;

                                        //adding Project scores to an array
                                        projScores = new int[numberOfPr];
                                        for (int prs = 0; prs < numberOfPr; prs++) {
                                            projScores[prs] = Integer.parseInt(studAttr[5 + numberOfHW + prs]);
                                            totalprojScore = totalprojScore + projScores[prs];
                                        }

                                        //adding exam scores to an array
                                        examScores = new int[numberOfEx];
                                        for (int exs = 0; exs < numberOfEx; exs++) {
                                            examScores[exs] = Integer.parseInt(studAttr[5 + numberOfHW + numberOfPr + exs]);
                                        }

                                        //extracting exam scores
                                /*Precondition:
                                *number of exams is in the interval [0:2]
                                * */
                                        if (numberOfEx == 2) {
                                            midtermExamScore = examScores[0];
                                            finalExamScore = examScores[1];
                                        } else if (numberOfEx == 1) {
                                            finalExamScore = examScores[0];
                                        } else {
                                            midtermExamScore = 0;
                                            finalExamScore = 0;
                                        }

                                        totalScore = totalHwScore + totalprojScore + midtermExamScore + finalExamScore;

                                        //instantiating new Student
                                        // [0]     [1]    [2]        [3]  [4]   [5] [6]  [7]  [8] [9]  [10] [11] [12] [13] [14]  [15]  [16]  [17]  [18] [19]
                                        //First   Last    sid       class site  hw1 hw2  hw3  hw4 hw5  hw6  hw7  hw8  hw9  hw10  hw11  hw12  proj  mid  fin
                                        //Michael Jordan 9998887777 CS401  01   10  9    8    10   9   9    8    7    7    9     10    9     18    88    95
                                        //Cindy Crawford 9995671234 CS401  03    9  8    7     6   6   7    8    9    9   10      8    8     10    97    85
                                        Student student = new Student(studAttr[0], studAttr[1], Long.parseLong(studAttr[2]), studAttr[3], Integer.parseInt(studAttr[4]), hwScores, totalHwScore, hwAvg, projScores, totalprojScore, midtermExamScore, finalExamScore, totalScore);

                                        //adding instantiated Student to the ArrayList
                                        students.add(student);
                                    }//end of if searching for class number in rosters

                                }//end of for loop

                            } //end of while loop
                            System.out.println("Grades have been added.\n");
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("File's data is corrupted.");
                        }


                    /*
                    * checking if grade items (weights) were added previously
                    * if yes - calculating total weighted score for students
                    * */
                        if (students.size() > 0 && gradeItems.size() > 0) {
                            calculateTotalWeightedScore(rosters, gradeItems, students);
                        }

                        return console.showMenu2(console);
                    case 2:
                        //temporary variables
                        int numberOfHW = 0;
                        int numberOfPr = 0;
                        int numberOfEx = 0;
                        int totalHwScore = 0;
                        float hwAvg = 0;
                        int totalprojScore = 0;
                        int midtermExamScore = 0;
                        int finalExamScore = 0;
                        int totalScore = 0;

                        int[] hwScores;
                        int[] projScores;
                        int[] examScores;

                        Student student1 = new Student();

                        //manual input of student's grades
                        Scanner input3 = new Scanner(System.in);
                        System.out.println("Adding student scores manually");
                        System.out.println("-------------------------");

                        try {
                            System.out.println("Please enter the first name :");
                            student1.setFirstName(input3.next());

                            System.out.println("Please enter the last name :");
                            student1.setLastName(input3.next());

                            System.out.println("Please enter sid :");
                            student1.setSid(input3.nextInt());

                            System.out.println("Please enter class number :");
                            student1.setClassNumber(input3.next());

                            System.out.println("Please enter class site number (e.g. for section 3 input '3'):");
                            student1.setSiteNumber(input3.nextInt());

                            //get number of HWs, projects and exams for that class
                            boolean classFound = false;
                            for (int r = 0; r < rosters.size(); r++) {
                                if (rosters.get(r).getClassNumber().equalsIgnoreCase(student1.getClassNumber())) {
                                    System.out.println(rosters.get(r).getClassNumber());
                                    numberOfHW = rosters.get(r).numberOfAssignments;
                                    numberOfPr = rosters.get(r).numberOfProjects;
                                    numberOfEx = rosters.get(r).numberOfExams;
                                    classFound=true;
                                }
                            }

                            if (!classFound) {
                                System.out.println("There is no such class. Please create roster from menu [1]");
                                return console.showMainMenu(console);
                            }

                            //input HW scores and add them to an array
                            hwScores = new int[numberOfHW];
                            for (int hws = 0; hws < numberOfHW; hws++) {
                                System.out.println("Please enter HW " + (hws + 1) + " score :");
                                hwScores[hws] = input3.nextInt();
                                totalHwScore = totalHwScore + hwScores[hws];
                            }
                            student1.setHwScores(hwScores);

                            // calculating hw avg
                            hwAvg = (float) totalHwScore / numberOfHW;
                            student1.setHwAvg(hwAvg);

                            //input project scores and add them to an array
                            projScores = new int[numberOfPr];
                            for (int prs = 0; prs < numberOfPr; prs++) {
                                System.out.println("Please enter project " + prs + 1 + " score :");
                                projScores[prs] = input3.nextInt();
                                totalprojScore = totalprojScore + projScores[prs];
                            }
                            student1.setProjScores(projScores);

                            //input exam scores and add them to an array
                            examScores = new int[numberOfEx];

                            if (numberOfEx == 2) {
                                System.out.println("Please enter midterm exam score :");
                                midtermExamScore = input3.nextInt();
                                System.out.println("Please enter final exam score :");
                                finalExamScore = input3.nextInt();
                                examScores[0] = midtermExamScore;
                                examScores[1] = finalExamScore;

                            } else if (numberOfEx == 1) {
                                System.out.println("Please enter final exam score :");
                                finalExamScore = input3.nextInt();
                                examScores[0] = finalExamScore;
                            } else {
                                midtermExamScore = 0;
                                finalExamScore = 0;
                                examScores[0] = 0;
                                examScores[1] = 0;
                            }

                            //calculating total score
                            totalScore = totalHwScore + totalprojScore + midtermExamScore + finalExamScore;

                            student1.setTotalHwScore(totalHwScore);
                            student1.setTotalProjectScore(totalprojScore);
                            student1.setMidtermExamScore(midtermExamScore);
                            student1.setFinalExamScore(finalExamScore);
                            student1.setTotalScore(totalScore);

                            //adding student to an ArrayList of students
                            students.add(student1);

                    /*
                    * checking if grade items (weights) were added previously
                    * if yes - calculating total weighted score for students
                    * */
                            if (students.size() > 0 && gradeItems.size() > 0) {
                                calculateTotalWeightedScore(rosters, gradeItems, students);
                            }

                            System.out.println("Student has been added\n" +
                                    "Returning to Main menu");

                            return console.showMainMenu(console);

                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect input. Please try again.");
                            return console.showMenu2(console);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Incorrect input. Please try again.");
                            return console.showMenu2(console);
                        }

                    case 3:
                        return console.showMainMenu(console);
                    default:
                        System.out.println("Invalid selection. Please try again.\n");
                }
            } while (selection != 3);
            return console;
        } catch (InputMismatchException e){
            System.out.println("Invalid selection. Please try again.\n");
            return console.showMenu2(console);
        }
    }//end of showMenu2

    //submenu3 method
    private Console showMenu3(Console console) throws IOException {
        try {
            System.out.println("\nHow do you want to search for records?");

            int selection = 0;
            String searchKey;
            long searchKeyLong = 0;

            do {
                System.out.println("[1] By first name\n"
                        + "[2] By last name\n"
                        + "[3] By SID\n"
                        + "[4] Back to main menu\n");

                System.out.print("Enter your choice: ");
                Scanner input = new Scanner(System.in);
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        //search by first name
                        System.out.println("Please, enter the First Name to search for :");
                        Scanner input3 = new Scanner(System.in);
                        searchKey = input3.next();

                        //public ArrayList<Student> searchByFirstName(ArrayList<Student> students, String searchKey) {
                        searchByFirstName(students, searchKey);

                        //sorting by LFS (last name/first name/site)
                        Collections.sort(foundStudents, new Student.SortByLFS());
                        printAll(foundStudents);

                        foundStudents.clear();

                        return console.showMenu3(console);
                    case 2:
                        //search by last name
                        System.out.println("Please, enter the Last Name to search for :");
                        Scanner input4 = new Scanner(System.in);
                        searchKey = input4.next();

                        searchByLastName(students, searchKey);

                        //sorting by LFS (last name/first name/site)
                        Collections.sort(foundStudents, new Student.SortByLFS());
                        printAll(foundStudents);

                        foundStudents.clear();

                        return console.showMenu3(console);
                    case 3:
                        //search by SID
                        try {
                            System.out.println("Please, enter SID to search for :");
                            Scanner input5 = new Scanner(System.in);
                            searchKeyLong = input5.nextLong();

                            searchBySID(students, searchKeyLong);

                            //sorting by LFS (last name/first name/site)
                            Collections.sort(foundStudents, new Student.SortByLFS());
                            printAll(foundStudents);

                            foundStudents.clear();
                        } catch (InputMismatchException e) {
                            System.out.println("Incorrect input. Please try again.");
                        }

                        return console.showMenu3(console);
                    case 4:
                        return console.showMainMenu(console);
                    default:
                        System.out.println("Invalid selection. Please try again.\n");
                }
            } while (selection != 4);
            return console;
        } catch (InputMismatchException e){
            System.out.println("Invalid selection. Please try again.\n");
            return console.showMenu3(console);
        }
    }//end of showMenu3

    //submenu4 method
    private Console showMenu4(Console console) throws IOException {
        try {
            System.out.println("\nPlease make your choice: ");

            int selection = 0;

            do {
                System.out.println("[1] Scoring weight by item\n"
                        + "[2] Sorted list by last name per class\n"
                        + "[3] Rankings by total score per class\n"
                        + "[4] Rankings by homework average per class\n"
                        + "[5] Ranking by project score per class\n"
                        + "[6] Ranking by Grade\n"
                        + "[7] Back to main menu\n");

                System.out.print("Enter your choice: ");
                Scanner input = new Scanner(System.in);
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        //set weight of grade items
                        //Final Exam 30
                        //Midterm Exam 30
                        //Project 20
                        //Homework 20
                        //Total 100

                        int finalExamW = 0;
                        int midtermExamW = 0;
                        int projectW = 0;
                        int hwW = 0;

                        /*
                        variables for the next version
                        to hold additional grade items values

                        int quizW = 0;
                        int participationW = 0;
                        int extraPointsW = 0;*/
                        int totalW = 0;

                        int numberOfHW = 0;
                        int numberOfPr = 0;
                        int numberOfEx = 0;

                        String classN;

                        System.out.println("Setting grade items weight by class");
                        System.out.println("Total weight should sum-up to 100%");
                        System.out.println("-----------------");
                        System.out.println("Please, enter the class number, e.g. 'CS401' :");
                        Scanner input2 = new Scanner(System.in);
                        classN = input2.next();

                        boolean classExists = false;
                        for (int r = 0; r < rosters.size(); r++) {
                            if (rosters.get(r).classNumber.equalsIgnoreCase(classN)) {
                                classExists = true;
                            }
                        }

                        if (classExists = false)  {
                                System.out.println("There is no such class. Please create roster from menu [1]");
                                return console.showMenu4(console);
                        }


                        numberOfHW = getNumberOfAssignmentsForClass(rosters, classN);
                        numberOfPr = getNumberOfProjectsForClass(rosters, classN);
                        numberOfEx = getNumberOfExamsForClass(rosters, classN);


                        //holds the status of weights assigned
                        boolean weightIncomplete = true;
                        while (weightIncomplete) {

                            if (numberOfHW != 0) {
                                System.out.println("Please enter weight of assignments in the total grade, e.g. '20' :");
                                hwW = input2.nextInt();
                            }

                            if (numberOfPr != 0) {
                                System.out.println("Please enter weight of projects in the total grade, e.g. '20'  :");
                                projectW = input2.nextInt();
                            }

                            if (numberOfEx != 0) {
                                if (numberOfEx == 2) {
                                    System.out.println("Please enter weight of midterm exam in the total grade, e.g. '30'  :");
                                    midtermExamW = input2.nextInt();
                                    System.out.println("Please enter weight of final exam in the total grade, e.g. '30'  :");
                                    finalExamW = input2.nextInt();
                                } else if (numberOfEx == 1) {
                                    System.out.println("Please enter weight of final exam in the total grade, e.g. '30'  :");
                                    finalExamW = input2.nextInt();
                                }
                            }

                            totalW = hwW + projectW + midtermExamW + finalExamW;
                            if (totalW == 100) {
                                weightIncomplete = false;
                            } else {
                                System.out.println("Total number of weights is not equal 100%. Please try again.");
                            }

                            /*
                            *For next version. Check if total weights entered is less
                            * than 100, ask the user if they want to add extra items or
                            * replay input.
                            * */
//                            else if (totalW < 100 && totalW > 0) {
//                                System.out.println("Total number of weights is less 100%");
//                                System.out.println("Would you like to add extra grade items to the course?");
//                                System.out.println("[1] Add extra items\n"
//                                        + "[2] No, re-enter weights for main grade items\n");
//                                selection = input2.nextInt();
//                                switch (selection) {
//                                    case 1:
//                                        //set extra weights
//                                        System.out.println("Please set weight of quiz in the total grade, e.g. 10 :");
//
//
//                                        break;
//                                    case 2:
//                                        System.out.println("Going back to setting weight");
//                                        break;
//                                    default:
//                                        System.out.println("Invalid selection. Please try again.\n");
//                                }//end of switch
//                            }

                        }//end of while loop

                        //creating Grade items
                        GradeItems gradeItem = new GradeItems(finalExamW, midtermExamW, projectW, hwW, classN);
                        gradeItems.add(gradeItem);

                        //calculating total score based on weights
                        calculateTotalWeightedScore(rosters, gradeItems, students);

                        return console.showMenu4(console);
                    case 2:
                        //sorting by last name
                        Collections.sort(students, new Student.SortByLastName());
                        printAll(students);

                        return console.showMenu4(console);
                    case 3:
                        //sorting by total score
                        Collections.sort(students, new Student.SortByTotalScore());
                        printByTotalScore(students);

                        return console.showMenu4(console);
                    case 4:
                        //sorting by HwAvg
                        Collections.sort(students, new Student.SortByHwAvg());
                        printByHwAvg(students);

                        return console.showMenu4(console);
                    case 5:
                        //sorting by ProjScore
                        Collections.sort(students, new Student.SortByProjScore());
                        printByProjScore(students);

                        return console.showMenu4(console);
                    case 6:
                        //sorting by Grade
                        Collections.sort(students, new Student.SortByGradeDesc());
                        printByGrade(students);

                        return console.showMenu4(console);
                    case 7:
                        return console.showMainMenu(console);
                    default:
                        System.out.println("Invalid selection. Please try again.\n");
                }
            } while (selection != 6);
            return console;
        } catch (InputMismatchException e){
            System.out.println("Invalid selection. Please try again.\n");
            return console.showMenu4(console);
        }
    }//end of showMenu4

    public static void printAll(ArrayList arr){

        // Print the list objects in tabular format.
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%5s %5s %15s %10s %10s %6s %6s %6s %6s %6s %6s", "CLASS", "SITE", "LAST NAME", "FIRST NAME", "SID", "HW AVG", "PROJECT", "MIDTERM", "FINAL", "TOTAL", "GRADE");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------");
        for (int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------------------");

    }//end of printAll method

    public static void printList(LinkedList<Student> students){

        // Print the list of objects in line

        for (int i=0; i<students.size(); i++) {
            //System.out.println(students.get(i));
            System.out.printf("%12s %10s %3s", students.get(i).getLastName(), students.get(i).getFirstName(), students.get(i).getSiteNumber());
            System.out.print(" -> ");
        }
    }//end of printList method

    public static void printListInd(LinkedList<Student> students, int ind){
        if (students.get(ind)!=null){
            //System.out.printf("%12s %10s %3s", students.get(ind).getLastName(), students.get(ind).getFirstName(), students.get(ind).getSiteNumber());
            System.out.printf("%s %s %s", students.get(ind).getLastName(), students.get(ind).getFirstName(), students.get(ind).getSiteNumber());
        }//end of if
        else {
            System.out.println("Element is out of scope");
        }
    }

    //Last name, first name, Site, TS
    public static void printByTotalScore(ArrayList<Student> arr){

        // Print the list objects in tabular format.
        System.out.println("---------------------------------------------------------");
        System.out.printf("%5s %5s %15s %10s %6s", "CLASS", "SITE", "LAST NAME", "FIRST NAME", "TOTAL");
        System.out.println();
        System.out.println("---------------------------------------------------------");
        for (int i=0; i<arr.size(); i++) {

            System.out.printf("%5s %4d %15s %10s %6d", arr.get(i).classNumber, arr.get(i).siteNumber, arr.get(i).lastName, arr.get(i).firstName, arr.get(i).totalScore);
            System.out.println();
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

    }//end of printByTotalScore method

    //Last name, first name, Site, HwAvg
    public static void printByHwAvg(ArrayList<Student> arr){

        // Print the list objects in tabular format.
        System.out.println("---------------------------------------------------------");
        System.out.printf("%5s %5s %15s %10s %7s", "CLASS", "SITE", "LAST NAME", "FIRST NAME", "HW AVG");
        System.out.println();
        System.out.println("---------------------------------------------------------");
        for (int i=0; i<arr.size(); i++) {

            System.out.printf("%5s %4d %15s %10s %7.2f", arr.get(i).classNumber, arr.get(i).siteNumber, arr.get(i).lastName, arr.get(i).firstName, arr.get(i).hwAvg);
            System.out.println();
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

    }//end of printByHwAvg method

    //Last name, first name, Site, Project score
    public static void printByProjScore(ArrayList<Student> arr){

        // Print the list objects in tabular format.
        System.out.println("---------------------------------------------------------");
        System.out.printf("%5s %5s %15s %10s %6s", "CLASS", "SITE", "LAST NAME", "FIRST NAME", "PROJECT");
        System.out.println();
        System.out.println("---------------------------------------------------------");
        for (int i=0; i<arr.size(); i++) {

            System.out.printf("%5s %4d %15s %10s %6d", arr.get(i).classNumber, arr.get(i).siteNumber, arr.get(i).lastName, arr.get(i).firstName, arr.get(i).totalProjectScore);
            System.out.println();
        }

        System.out.println();
        System.out.println("---------------------------------------------------------");

    }//end of printByProjScore method

    //Last name, first name, Grade
    public static void printByGrade(ArrayList<Student> arr){

        System.out.println("--------------------------------------------------------------");
        System.out.printf("%5s %5s %15s %10s %6s %10s", "CLASS", "SITE", "LAST NAME", "FIRST NAME", "GRADE", "TOTAL SCORE(W)");
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        for (int i=0; i<arr.size(); i++) {

            System.out.printf("%5s %4d %15s %10s %6s %7.2f", arr.get(i).classNumber, arr.get(i).siteNumber, arr.get(i).lastName, arr.get(i).firstName, arr.get(i).grade, arr.get(i).totalWeightedScore);
            System.out.println();
        }

        System.out.println();
        System.out.println("--------------------------------------------------------------");

    }//end of printByGrade method

    public static int getHwWForClass(ArrayList<GradeItems> gradeItem, String classN) {

        //get weight of HWs for the specified class
        int hwW=0;
        for (int r = 0; r<gradeItem.size(); r++) {
            if (gradeItem.get(r).classNumber.equalsIgnoreCase(classN)) {
                hwW = gradeItem.get(r).hwW;
            }
        }
        return hwW;
    }

    public static int getProjectWForClass(ArrayList<GradeItems> gradeItems, String classN) {

        //get weight of Projects for the specified class
        int projectW = 0;
        for (int r=0; r<gradeItems.size(); r++) {
            if (gradeItems.get(r).classNumber.equalsIgnoreCase(classN)) {
                projectW = gradeItems.get(r).projectW;
            }
        }
        return projectW;
    }

    public static int getMidtermExamWForClass(ArrayList<GradeItems> gradeItems, String classN) {

        //get weight of midterm for the specified class
        int midtermExamW = 0;
        for (int r=0; r<gradeItems.size(); r++) {
            if (gradeItems.get(r).classNumber.equalsIgnoreCase(classN)) {
                midtermExamW = gradeItems.get(r).midtermExamW;
            }
        }
        return midtermExamW;
    }

    public static int getFinalExamWForClass(ArrayList<GradeItems> gradeItems, String classN) {

        //get weight of final exam for the specified class
        int finalExamW = 0;
        for (int r=0; r<gradeItems.size(); r++) {
            if (gradeItems.get(r).classNumber.equalsIgnoreCase(classN)) {
                finalExamW = gradeItems.get(r).finalExamW;
            }
        }
        return finalExamW;
    }

    public static int getNumberOfAssignmentsForClass(ArrayList<Roster> roster, String classN) {

        //get number of HWs for that class
        int numberOfAssignments = 0;
        for (int r=0; r<roster.size(); r++) {
            if (roster.get(r).classNumber.equalsIgnoreCase(classN)) {
                numberOfAssignments = roster.get(r).numberOfAssignments;
            }
        }
        return numberOfAssignments;
    }

    public static int getNumberOfProjectsForClass(ArrayList<Roster> roster, String classN) {

        //get number of projects for that class
        int numberOfProjects = 0;
        for (int r=0; r<roster.size(); r++) {
            if (roster.get(r).classNumber.equalsIgnoreCase(classN)) {
                numberOfProjects = roster.get(r).numberOfProjects;
            }
        }
        return numberOfProjects;
    }


    public static int getNumberOfExamsForClass(ArrayList<Roster> roster, String classN) {

        //get number of exams for that class
        int numberOfExams = 0;
        for (int r=0; r<roster.size(); r++) {
            if (roster.get(r).classNumber.equalsIgnoreCase(classN)) {
                numberOfExams = roster.get(r).numberOfExams;
            }
        }
        return numberOfExams;
    }

    /*
        * Precondition:
        * Each HW max score = 10
        * Each project max score = 20
        * Each exam max score = 100
        * */
    public static void calculateTotalWeightedScore(ArrayList<Roster> roster, ArrayList<GradeItems> gradeItems, ArrayList<Student> students) {

        //weight variables
        float finalExamW = 0;
        float midtermExamW = 0;
        float projectW = 0;
        float hwW = 0;
//        float quizW = 0;
//        float participationW = 0;
//        float extraPointsW = 0;
        float totalWeightedScore = 0;

        //quantitative variables
        int numberOfHw = 0;
        int numberOfProj = 0;
        //int numberOfExams = 0;

        //other variables
        String classN;

        for (int i = 0; i < students.size(); i++) {

            //get class number
            classN = students.get(i).getClassNumber();

            //get number of HW, Projects, exams for the class number from rosters
            numberOfHw = getNumberOfAssignmentsForClass(roster, classN);
            numberOfProj = getNumberOfProjectsForClass(roster, classN);

            //get weights for hw, projects, exams
            hwW = getHwWForClass(gradeItems, classN);
            projectW = getProjectWForClass(gradeItems, classN);
            midtermExamW = getMidtermExamWForClass(gradeItems, classN);
            finalExamW = getFinalExamWForClass(gradeItems, classN);

            float totalHwScore = students.get(i).getTotalHwScore();
            float totalProjScore = students.get(i).getTotalProjectScore();
            float midtermExamScore = students.get(i).getMidtermExamScore();
            float finalExamScore = students.get(i).getFinalExamScore();


            totalWeightedScore = totalHwScore/(numberOfHw*10)*hwW
                    + totalProjScore/(numberOfProj*20)*projectW
                    + midtermExamScore/100*midtermExamW
                    + finalExamScore/100*finalExamW;

            //setting student total score
            students.get(i).setTotalWeightedScore(totalWeightedScore);

            //calculating and setting grade
            if (totalWeightedScore>=90) {
                students.get(i).setGrade('A');
            } else if (totalWeightedScore< 90 && totalWeightedScore>=80) {
                students.get(i).setGrade('B');
            } else if (totalWeightedScore< 80 && totalWeightedScore>=70) {
                students.get(i).setGrade('C');
            } else if (totalWeightedScore< 70) {
                students.get(i).setGrade('E');
            }

        }//end of for loop over students
    }//end of calculateTotalWeightedScore method

    public ArrayList<Student> searchByFirstName(ArrayList<Student> students, String searchKey) {
        for (int i = 0; i < students.size(); i++) {
            //if match is found, adding student to the list of founded students
            if (students.get(i).getFirstName().equalsIgnoreCase(searchKey)) {
                foundStudents.add(students.get(i));
            }//end of if
        }//end of for loop
        return foundStudents;
    }//end of searchByFirstName

    public ArrayList<Student> searchByLastName(ArrayList<Student> students, String searchKey) {
        for (int i = 0; i < students.size(); i++) {
            //if match is found, adding student to the list of founded students
            if (students.get(i).getLastName().equalsIgnoreCase(searchKey)) {
                foundStudents.add(students.get(i));
            }//end of if
        }//end of for loop
        return foundStudents;
    }//end of searchByLastName

    public ArrayList<Student> searchBySID(ArrayList<Student> students, long searchKeyLong) {
        for (int i = 0; i < students.size(); i++) {
            //if match is found, adding student to the list of founded students
            if (students.get(i).getSid() == searchKeyLong) {
                foundStudents.add(students.get(i));
            }//end of if
        }//end of for loop
        return foundStudents;
    }//end of searchBySID

}