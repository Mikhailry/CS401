package project;

import java.util.ArrayList;

public class Roster {

    protected int numberOfSites; //variable of number of course sites
    protected int studentsSites01; //variable for number of site1 students
    protected int studentsSites02; //variable for number of site2 students
    protected int studentsSites03; //variable for number of site3 students
    protected int totalClassSize; //variable of class size
    protected int numberOfAssignments; //variable of number of assignments
    protected int numberOfProjects; //variable of number of projects
    protected int numberOfExams; //variable of number of exams
    protected String classNumber; //variable of class number


    /*
    * Default constructor
    * takes class number as input
    *
    * Roster with default values created:
    * Number of sites = 3 (precondition: number of sites: 0 <= sites <= 3)
    * Number of students per site1 = 10
    * Number of students per site2 = 5
    * Number of students per site2 = 5
    * --------------------------------
    * Total class size = 20
    * Number of assignments = 10
    * Number of projects = 1
    * Number of exams = 2
    * */
    public Roster(String classNumber){
        numberOfSites = 3;
        studentsSites01 = 10;
        studentsSites02 = 5;
        studentsSites03 = 5;
        totalClassSize = 20;
        numberOfAssignments = 12;
        numberOfProjects = 1;
        numberOfExams = 2;
        this.classNumber = classNumber;

    } // end of default constructor


    //parametric constructor
    public Roster(int numberOfSites, int studentsSites01, int studentsSites02, int studentsSites03, int totalClassSize, int numberOfAssignments, int numberOfProjects, int numberOfExams, String classNumber) {
        this.numberOfSites = numberOfSites;
        this.studentsSites01 = studentsSites01;
        this.studentsSites02 = studentsSites02;
        this.studentsSites03 = studentsSites03;
        this.totalClassSize = totalClassSize;
        this.numberOfAssignments = numberOfAssignments;
        this.numberOfProjects = numberOfProjects;
        this.numberOfExams = numberOfExams;
        this.classNumber = classNumber;
    }





    public void setNumberOfAssignments(int numberOfAssignments) {
        this.numberOfAssignments = numberOfAssignments;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }


    public void setNumberOfExams(int numberOfExams) {
        this.numberOfExams = numberOfExams;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
