package lab1;

public class Circle {

    private int r;
    private double circleArea;

    public double getCircleArea() {
        return circleArea;
    }

    public void setCircleArea(double circleArea) {
        this.circleArea = circleArea;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public double calcCircleArea(int r){
        circleArea = Math.PI*r*r;
        return circleArea;

    }

    @Override
    public String toString() {
        return "Circle with area = "+circleArea+" and r=" + r;
    }


}
