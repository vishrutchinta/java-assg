package Assignment11;

interface Printable {
    void print();
}

class Student implements Printable {
    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void print() {
        System.out.println("Student Name: " + name + ", Roll No: " + rollNo);
    }
}

class Employee implements Printable {
    String name;
    int empId;

    Employee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    public void print() {
        System.out.println("Employee Name: " + name + ", Emp ID: " + empId);
    }
}

public class PrintableApp {
    public static void main(String[] args) {
        Printable s = new Student("Vishrut Chinta", 218);
        Printable e = new Employee("Parth Kulkarni", 4521);
        s.print();
        e.print();
    }
}
