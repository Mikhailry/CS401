package lab2;


import java.util.Comparator;

public class Employee {


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

    //method to compare 2 Employees with Equals method
    public boolean equals(Employee other) {

        if (this.getName().equals(other.getName())){   //names comparison
            if (this.getiD() == other.getiD()){ //id's comparison
                System.out.println("Employees names and ID's are equal");
                System.out.println(this.toString());
                System.out.println(other.toString());

            } else {System.out.println("Employees names ARE equal, ID's are NOT equal");
                    System.out.println(this.toString());
                    System.out.println(other.toString());
            }
        } else if (this.getiD() == other.getiD()){ //id's comparison
            System.out.println("Employees names are NOT equal, ID's ARE equal");
            System.out.println(this.toString());
            System.out.println(other.toString());
        } else {
            System.out.println("Employees names and ID's are NOT equal");
            System.out.println(this.toString());
            System.out.println(other.toString());
        }

        return super.equals(other);
    }


    //method to compare 2 Employees with compareTo method
    public int compareTo (Employee other){
        int result;

        if (this.getName().compareTo(other.getName()) == 0){  //names comparison
            if (this.getiD() == other.getiD()) {              //id's comparison
                return result = 0; //("Employees names and ID's are equal");
            } else {
                return result = - 1; //"Employees names ARE equal, ID's are NOT equal"
            }
        } else {
            return result=-1; //"Employees names and ID's are NOT equal"
        }
    }

    //method to compare 2 Employees with compare method
    public static Comparator<Employee> EmpComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            int result = e1.getName().compareTo(e2.getName());
            if(result==0) result = e1.getiD() - (e2.getiD());
            return result;
        }
    };


    //toString method
    @Override
    public String toString() {
        return "Employee{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                '}';
    }


}
