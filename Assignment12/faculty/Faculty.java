package Assignment12.faculty;


public class Faculty {
    String name;
    String department;
    double salary;

    public Faculty(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Faculty Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}