package lab8;

public class Employee implements Comparable<Employee> {


    //instantiating variables
    private int iD;
    private String name;

    //default constructor for class Employee
    public Employee() {
    }

    //constructor for class Employee
    public Employee(int iD, String name) {
        this.iD = iD;
        this.name = name;
    }

    //getters and setters for variables
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int compareTo (Employee other){
        int result;

        if (this.getiD() > other.getiD()) { //id's comparison
            return result = 1; //first ID greater than other
        } else if (this.getiD()<other.getiD()){
            return result = -1; //first ID less than other
        } else {
            return result = 0; //"Employees ID's are equal"
        }

    }//end of compareTo method


    //toString method
    @Override
    public String toString() {
        return String.format("(%s, %d)", name, iD);
    }


}
