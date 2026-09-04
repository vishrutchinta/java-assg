package Assignment16;

import java.util.Scanner;


class UnderAgeVotingException extends Exception {


    UnderAgeVotingException(String message) {
        super(message);  
    }
}

public class VotingSystem {


    static void checkVotingEligibility(int age) throws UnderAgeVotingException {

        if (age < 18) {
            throw new UnderAgeVotingException("You are not eligible to vote. Minimum age required is 18.");
        }

        System.out.println("You are eligible to vote.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkVotingEligibility(age);

        } catch (UnderAgeVotingException e) {
            // catches only this custom type
            System.out.println("Custom Exception: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {

            System.out.println("Please enter a valid age.");

        } finally {
            System.out.println("Voting eligibility check completed.");
        }

        sc.close();
    }
}