package Assignment4;
import java.util.Scanner;


public class StudentMArksConv{
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        int i = 1;
        int sum = 0;
        Integer markss;
        while(true){
            System.out.print("Enter Student Marks for Subject "+i+": ");
            String marks = st.nextLine();
            markss = Integer.valueOf(marks);
            if(markss<0){
                System.out.println("marks must be positive");
                
                continue;
            }
            else if(markss>100){
                System.out.println("Marks must be between 0-100");
                continue;
            }
            sum += markss;
            i++;
            if(i>5){
                break;
            }
        }
        System.out.println("Total Marks of the student are: "+sum);
    }
}


