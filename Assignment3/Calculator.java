package Assignment3;
import java.util.Scanner;

public class Calculator {
    static int op_count = 0;
    public static void add(int a,int b){
        System.out.println("Sum: of "+a+"and"+b+"is: "+(a+b));
        op_count++;
        return;
    }
    static void add(int a,int b,int c){
        System.out.println("Sum: of "+a+" and "+b+" and "+c+" is: "+(a+b+c));
                op_count++;

    }
    static void add(double a,double b){
        System.out.println("Sum is "+(a+b));
                op_count++;

    }

    static void add(double a,double b,double c){
        System.out.println("Sum is: "+(a+b+c));
                op_count++;

    }

    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        System.out.println("START/STOP : ");
        String status = st.nextLine();
        while(!status.equals("STOP")){
            
        System.out.println("How many numbers do you want to enter: ");
        int num = st.nextInt();
        if(num == 2){
            System.out.println("Enter first number: ");
            if(st.hasNextInt()){
            int num1 = st.nextInt();
            System.out.println("Enter second number: ");
                int num2 = st.nextInt();
                add(num1,num2);
                
            }
            else if(st.hasNextDouble()){
                double num1 = st.nextDouble();
                System.out.println("Enter second number: ");
                double num2 = st.nextDouble();
                add(num1,num2);
            }
        }
        else if(num == 3){
            System.out.println("Enter first number: ");
            if(st.hasNextInt()){
            int num1 = st.nextInt();
            System.out.println("Enter second number: ");
                int num2 = st.nextInt();
            System.out.println("Enter Third Number: ");
            int num3 = st.nextInt();
                add(num1,num2,num3);
                
            }
            else if(st.hasNextDouble()){
                double num1 = st.nextDouble();
                System.out.println("Enter second number: ");
                double num2 = st.nextDouble();
                System.out.println("Enter Third Number: ");
                double num3 = st.nextDouble();
                add(num1,num2,num3);
            }

        }
        st.nextLine();
        System.out.println("START/STOP : ");
        status = st.nextLine();
 
        
    }
    System.out.println("Total Operations : "+op_count);
    
}
}