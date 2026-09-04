package Assignment16;

import java.util.Scanner;


class UnderAgeLicenseException extends Exception {

    UnderAgeLicenseException(String message) {
        super(message);
    }
}

public class DrivingLicenseSystem {


    static void checkLicenseEligibility(int age) throws UnderAgeLicenseException {

        if (age < 18) {
            throw new UnderAgeLicenseException("You are not eligible for a driving license. Minimum age required is 18.");
        }


        System.out.println("You are eligible for a driving license.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkLicenseEligibility(age);

        } catch (UnderAgeLicenseException e) {
            System.out.println("Custom Exception: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Please enter a valid age.");

        } finally {
            System.out.println("License eligibility check completed.");
        }

        sc.close();
    }
}