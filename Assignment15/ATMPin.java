package Assignment15;

import java.util.Scanner;

public class ATMPin {


    static final int CORRECT_PIN = 4321;

    static void verifyPin(int enteredPin) throws Exception {

        if (enteredPin != CORRECT_PIN) {
            throw new Exception("Invalid PIN! Verification Failed.");
        }

        System.out.println("PIN Verified Successfully.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter ATM PIN: ");
            int pin = sc.nextInt();

            verifyPin(pin);

        } 
        catch (java.util.InputMismatchException e) {

            System.out.println("Please enter a valid numeric PIN.");}
            catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());

        } finally {
            // always shown, success or failure, so user knows process ended
            System.out.println("Verification process has ended.");
        }

        sc.close();
    }
}
