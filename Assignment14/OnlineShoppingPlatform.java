package Assignment14;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineShoppingPlatform {

    public static class InsufficeintQuantity extends Exception{
        public InsufficeintQuantity(String message){
            super(message);
        }

    }
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        try{
            System.out.println("Enter Product Name:");
            String id = st.nextLine();

            System.out.println("Enter Product Quantity: ");
            int quantity = st.nextInt();
            if(quantity<0){
                throw new InsufficeintQuantity("Invalid Quantity!");
            }
            boolean purchase = false;
            System.out.println("Do you want to purchase? (Y -> Yes || N->No");
            String resp = st.next();
            if(resp.equals("Y") ){
                purchase = true;
            }
            if(purchase){
                quantity--;
                
                if(quantity<0){
                throw new InsufficeintQuantity("Insufficient Quantity!");
                }
                System.out.println("Purchased "+id+" and remaining quantity is: "+quantity);
                
            
            }
        }catch(InsufficeintQuantity e){
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Invalid Format");
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }
    
}
