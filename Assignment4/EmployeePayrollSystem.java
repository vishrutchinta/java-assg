package Assignment4;
import java.util.Scanner;

public class EmployeePayrollSystem{
    static Scanner st = new Scanner(System.in);
    public static Integer verifyInt(String prompt){
        while(true){
            
            System.out.print(prompt);
            if(st.hasNextInt()){
                int sal = st.nextInt();
                if(sal<0){
                    System.out.println("Salary cannot be negative!");
                    continue;
                }
                return sal;
            }
            else{
                System.out.println("Invalid Format");
                st.next();
            }
        }
    }
    public static Double verifyDouble(String Prompt){
        while(true){
            System.out.print(Prompt);
            if(st.hasNextDouble()){
                double sal = st.nextDouble();
                if(sal<0){
                    System.out.println("Salary cant be negative");
                    continue;
                }
                return sal;
            }
            else{
                System.out.println("Invalid FOrmat");
                st.next();
            }
        }
    }
    public static void main(String[] args) {
        String prompt = "Enter Employee ID: ";
        int id = verifyInt(prompt);
        String salary = "Enter Employee Salary: ";
        double sal = verifyDouble(salary);
        String bons = "Enter Bonus Amount";
        double bonus = verifyDouble(bons);
        
        System.out.println("-------------------------------------------------");
        System.out.println("Employee Payroll System");
        System.out.println("Employee ID: "+id);
        System.out.println("Net Employee Salary: "+(sal+bonus));

    }

    
}
