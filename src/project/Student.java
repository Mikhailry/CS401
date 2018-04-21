package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Student<T>{

    protected String firstName;
    protected String lastName;
    protected long sid;
    protected String classNumber;
    protected int siteNumber;
    protected int totalHwScore;
    protected int totalProjectScore;
    protected int midtermExamScore;
    protected int finalExamScore;
    protected int totalScore;
    protected int quizScore;
    protected int particScore;
    protected int extraScore;
    protected float hwAvg;
    protected float totalWeightedScore;
    protected char grade;
    protected int [] hwScores;
    protected int [] projScores;

    //default constructor
    public Student(){
    }

    //parametrized constructor
    public Student(String lastName, String firstName, long sid) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.sid = sid;
    }

    //parametrized constructor
    public Student(String firstName, String lastName, long sid, String classNumber, int siteNumber, int[] hwScores, int totalHwScore, float hwAvg, int [] projScores, int totalProjectScore, int midtermExamScore, int finalExamScore, int totalScore) {
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
        this.quizScore = 0;
        this.particScore = 0;
        this.extraScore = 0;
        this.totalWeightedScore = 0;
        this.grade = '\0';

    }





    public float getTotalWeightedScore() {
        return totalWeightedScore;
    }

    public void setTotalWeightedScore(float totalWeightedScore) {
        this.totalWeightedScore = totalWeightedScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public int getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(int siteNumber) {
        this.siteNumber = siteNumber;
    }

    public int getTotalHwScore() {
        return totalHwScore;
    }

    public void setTotalHwScore(int totalHwScore) {
        this.totalHwScore = totalHwScore;
    }

    public int getTotalProjectScore() {
        return totalProjectScore;
    }

    public void setTotalProjectScore(int totalProjectScore) {
        this.totalProjectScore = totalProjectScore;
    }

    public int getMidtermExamScore() {
        return midtermExamScore;
    }

    public void setMidtermExamScore(int midtermExamScore) {
        this.midtermExamScore = midtermExamScore;
    }

    public int getFinalExamScore() {
        return finalExamScore;
    }

    public void setFinalExamScore(int finalExamScore) {
        this.finalExamScore = finalExamScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public float getHwAvg() {
        return hwAvg;
    }

    public void setHwAvg(float hwAvg) {
        this.hwAvg = hwAvg;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int[] getHwScores() {
        return hwScores;
    }

    public void setHwScores(int[] hwScores) {
        this.hwScores = hwScores;
    }

    public int[] getProjScores() {
        return projScores;
    }

    public void setProjScores(int[] projScores) {
        this.projScores = projScores;
    }


    @Override
    public String toString() {
            return String.format("%5s %4d %15s %10s %10d %7.2f %6d %6d %6d %6d %6c", classNumber, siteNumber, lastName, firstName, sid, hwAvg, totalProjectScore, midtermExamScore, finalExamScore, totalScore, grade);
        }
        //Last name, first name, SID, Site, homework average, project, midterm, final, total score, Grad


//    //second toString method to print a different subset of params
//    public String toString() {
//        return String.format("%15s %10s %10d", lastName, firstName, sid);
//        //Last name, first name, SID
//    }

    //asc - ascending; desc - descending
    //sorting for menu 4.2 in the order: Class asc/Site asc/Last name asc
    static class SortByLastName implements Comparator<Student> {
        public int compare(Student a, Student b) {
            //first compare by class number
            int order = a.classNumber.compareToIgnoreCase(b.classNumber);
            if (order == 0) {
                order = a.siteNumber-b.siteNumber;
                if (order == 0) {
                    order = a.lastName.compareToIgnoreCase(b.lastName);
                }
            }
            return order;
        }
    }

    //sorting for menu 4.3 in the order: TS desc, site asc, Last name asc
    static class SortByTotalScore implements Comparator<Student> {
        public int compare(Student a, Student b) {
            int order = a.classNumber.compareToIgnoreCase(b.classNumber);
            if (order==0) {
                order = (a.totalScore - b.totalScore) * (-1);
                if (order == 0) {
                    order = a.siteNumber - b.siteNumber;
                    if (order == 0) {
                        order = a.lastName.compareToIgnoreCase(b.lastName);
                    }
                }
            }
            return order;
        }
    }

    //sorting for menu 4.4 in the order: HWavg desc, site asc, Last name asc
    static class SortByHwAvg implements Comparator<Student> {
        public int compare(Student a, Student b) {
            int order = a.classNumber.compareToIgnoreCase(b.classNumber);
            if (order==0) {
                order = Double.compare(a.hwAvg, b.hwAvg) * (-1);
                if (order == 0) {
                    order = a.siteNumber - b.siteNumber;

                    if (order == 0) {
                        order = a.lastName.compareToIgnoreCase(b.lastName);
                    }
                }
            }
            return order;
        }
    }

    //sorting for menu 4.5 in the order: Project score desc, site asc, Last name asc
    static class SortByProjScore implements Comparator<Student> {
        public int compare(Student a, Student b) {
            int order = a.classNumber.compareToIgnoreCase(b.classNumber);
            if (order==0) {
                order = (a.totalProjectScore - b.totalProjectScore) * (-1);
                if (order == 0) {
                    order = a.siteNumber - b.siteNumber;
                    if (order == 0) {
                        order = a.lastName.compareToIgnoreCase(b.lastName);
                    }
                }
            }
            return order;
        }
    }


    //sorting for menu 4.6 in the order of grades (from A to E) and per course
    static class SortByGradeDesc implements Comparator<Student> {
        public int compare(Student a, Student b) {
            int order = a.classNumber.compareToIgnoreCase(b.classNumber);
            if (order == 0) {
                order = a.grade-b.grade;
            }
            return order;
        }
    }

    //sorting for search menu 3.1 in the order: last name asc/first name/Site asc
    static class SortByLFS implements Comparator<Student> {
        public int compare(Student a, Student b) {
            //first compare by last name
            int order = a.lastName.compareToIgnoreCase(b.lastName);
            if (order == 0) {
                order = a.firstName.compareToIgnoreCase(b.firstName);
                if (order == 0) {
                    order = a.siteNumber-b.siteNumber;
                }
            }
            return order;
        }
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
