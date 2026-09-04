package Assignment14;
import java.util.Scanner;

import javax.naming.InsufficientResourcesException;
public class BankAccoutWithdraw {

    public static class InsufficientBalanceException extends Exception{
        public InsufficientBalanceException(String message){
            super(message);
        }
    }
    public static void main(String[] args) {
        Scanner st = new Scanner(System.in);
        try{
            System.out.println("Enter you balance: ");
            double bal = st.nextDouble();
            
                System.out.println("Enter amount to withdraw: ");
                double with = st.nextDouble();
                double newbal = bal-with;
                if(newbal<0){
                    throw new InsufficientBalanceException("Insufficeint Balance");
                }
                System.out.println("Balance Remaining: "+newbal);
            }catch(InsufficientBalanceException e){
                System.out.println(e.getMessage());
            
        }catch(java.util.InputMismatchException e){
            System.out.println("Invalid Format");
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }

        }
    }
    

