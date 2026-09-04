package Assignment15;

import java.util.Scanner;

public class LoginProgram {


    static final String CORRECT_PASSWORD = "admin123";


    static void login(String enteredPassword) throws Exception {

        if (!enteredPassword.equals(CORRECT_PASSWORD)) {

            throw new Exception("Invalid Password! Login Failed.");
        }

        System.out.println("Login Successful. Welcome!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            login(password); 

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());

        } finally {

            System.out.println("Login attempt process completed.");
        }

        sc.close();
    }
}
