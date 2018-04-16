package project;

import java.util.ArrayList;

public class GradeItems {

    protected int finalExamW;
    protected int midtermExamW;
    protected int projectW;
    protected int hwW;
    protected int quizW;
    protected int participationW;
    protected int extraPointsW;
    protected String classNumber;

    //default constructor
    public GradeItems() {
    }

    //parametrized constructor
    public GradeItems(int finalExamW, int midtermExamW, int projectW, int hwW, int quizW, int participationW, int extraPointsW, String classNumber) {
        this.finalExamW = finalExamW;
        this.midtermExamW = midtermExamW;
        this.projectW = projectW;
        this.hwW = hwW;
        this.quizW = quizW;
        this.participationW = participationW;
        this.extraPointsW = extraPointsW;
        this.classNumber = classNumber;
    }

}
