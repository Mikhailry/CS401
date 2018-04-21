package project;

import java.util.ArrayList;

public class GradeItems {

    protected int finalExamW;
    protected int midtermExamW;
    protected int projectW;
    protected int hwW;
    protected String classNumber;

    /*
    * For the next version.
    * Variables to hold additional items values.
    *
    * */
    /*protected int quizW;
    protected int participationW;
    protected int extraPointsW;*/

    //default constructor
    public GradeItems() {
    }

    //parametrized constructor
    public GradeItems(int finalExamW, int midtermExamW, int projectW, int hwW, String classNumber) {
        this.finalExamW = finalExamW;
        this.midtermExamW = midtermExamW;
        this.projectW = projectW;
        this.hwW = hwW;
        this.classNumber = classNumber;
        /*this.quizW = quizW;
        this.participationW = participationW;
        this.extraPointsW = extraPointsW;*/

    }

}
