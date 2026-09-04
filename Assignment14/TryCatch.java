package Assignment14;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        try{
            System.out.println("Enter First Number: ");
            int a = st.nextInt();
            System.out.println("Eneter Second Number: ");
            int b = st.nextInt();

            try{
                int div = a / b ;
                System.out.println("The Division of the two numbers is: "+div);

                int[] arr = {1,3,2,4,5};
                System.out.println("The elemnt is array is"+arr[5]);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Nested Catch: Index is out of Bounds");
            }
        }
            catch(ArithmeticException e){
                System.out.println("Cannot Divide by Zero");
            }
            catch(java.util.InputMismatchException e){
                System.out.println("Eneter valid numbers!");
            }
            catch(Exception e){
                System.out.println("General Exception "+e);
            }
            st.close();

        
    }
}


    

