package project;

import java.lang.reflect.Array;

public class Student<T> {

    protected String firstName;
    protected String lastName;
    protected int sid;
    protected String classNumber;
    protected int siteNumber;
    protected int totalHwScore;
    protected int totalProjectScore;
    protected int midtermExamScore;
    protected int finalExamScore;
    protected int totalScore;
    protected float hwAvg;
    protected char grade;
    protected int [] hwScores;
    protected int [] projScores;

    //parametric constructor
    public Student(String firstName, String lastName, int sid, String classNumber, int siteNumber, int[] hwScores, int totalHwScore, float hwAvg, int [] projScores, int totalProjectScore, int midtermExamScore, int finalExamScore, int totalScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sid = sid;
        this.classNumber = classNumber;
        this.siteNumber = siteNumber;
        this.hwScores = hwScores;
        this.totalHwScore = totalHwScore;
        this.hwAvg = hwAvg;
        this.projScores = projScores;
        this.totalProjectScore = totalProjectScore;
        this.midtermExamScore = midtermExamScore;
        this.finalExamScore = finalExamScore;
        this.totalScore = totalScore;
        this.grade = '\0';

    }

    //    //method to search student by first name
//    public T searchFirstName(){
//
//        return
//    }//end of searchFirstName method
//
//    //method to search student by last name
//    public T searchLastName(){
//
//        return
//    }//end of searchLastName method
//
//    //method to search student by sid
//    public T searchSid(){
//
//        return
//    }//end of sid method
//
//    //method to sort students by last name
//    public T sortByLastName(){
//
//        return
//    }//end of sortByLastName method
//
//    //method to sort students by total Score
//    public T sortByTotalScore(){
//
//        return
//    }//end of sortByTotalScore method
//
//    //method to sort students by HW avg
//    public T sortByHwAvg(){
//
//        return
//    }//end of sortByHwAvg method
//
//    //method to sort students by project score
//    public T sortByProjectScore(){
//
//        return
//    }//end of sortByProjectScore method
//
//    //method to sort students by grade
//    public T sortByGrade(){
//
//        return
//    }//end of sortByGrade method

}
