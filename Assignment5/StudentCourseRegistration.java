package Assignment5;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentCourseRegistration {
    public static void main(String[] args) {
        
    
    Scanner st = new Scanner(System.in);
    ArrayList<String> courses = new ArrayList<String>();
    StringBuffer arr = new StringBuffer();
    int c_no=0;
    while(true){
                System.out.println("-----------------------------------------------");

        System.out.println("1.Add Your Course");
        System.out.println("2.Remove your Course Selection: ");
        System.out.println("3.View Registered Courses");
        System.out.println("4.Exit");
        
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("Select: ");
        int choice = st.nextInt();
        st.nextLine();
        if(choice>4 || choice<1){
            System.out.println("Enter Valid Choice: ");
            st.next();
            continue;
        }
        switch (choice) {
            case 1:
                c_no++;
                System.out.print("Enter Course "+c_no+"'s' name: ");
                courses.add(st.nextLine());
                break;
            case 2:
                System.out.print("Enter the course number that you want to remove: ");
                int no = st.nextInt();
                if(no>c_no-1 || no<0){
                    System.out.println("Course Doesnt Exist");
                    break;
                }
                courses.remove(no-1);
                
                System.out.println("-----------------------------------------------");
                System.out.println("Course "+no+" Successfully removed ");
                        System.out.println("-----------------------------------------------");

                c_no--;
                break;
            case 3: 
                if(courses.isEmpty()){
                    System.out.println("Your choice list is empty");
                    break;
                }
                arr.setLength(0);
                        System.out.println("-----------------------------------------------");

                for (int j = 0; j < courses.size(); j++) {
                arr.append("Course "+(j + 1)+": "+courses.get(j)+"\n");
                        System.out.println("-----------------------------------------------");

        }
    System.out.println(arr);
                break;
        
            default:
                break;
        }
        if(choice ==4){
            System.out.println("The End");
            break;
        }
    }
    
}
}
