package Assignment12;

import Assignment12.student.Student;
import Assignment12.faculty.Faculty;

public class CollegeApp {
    public static void main(String[] args) {
        Student s = new Student("Vishrut Chinta", 218, "B.Tech CSE");
        Faculty f = new Faculty("Dr. Kulkarni", "Computer Science", 95000.00);

        s.display();
        f.display();
    }
}