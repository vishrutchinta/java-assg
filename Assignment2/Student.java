package Assignment2;
public class Student {
    
    String name;
    int std;
    int rollno;
    Student(){

    }
    Student(String n , int s,int r){
        name=n;
        std=s;
        rollno=r;
    }
    void print(){
        System.out.println("Name: "+name);
        System.out.println("Grade: "+std);
        System.out.println("Roll No.: "+rollno);
    }

    public static void main(String args[]){
        Student st1 = new Student();
        st1.print();
        System.out.println("---------------------------------------------------------------------------------");
        Student st2 = new Student("Vishrut",12,250701222);
        st2.print();

    }
}
    

