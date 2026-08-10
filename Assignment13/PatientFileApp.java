package Assignment13;

import java.io.*;

public class PatientFileApp {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("patient.txt");
        writer.write("P001,Rohan Mehta,45,Diabetes\n");
        writer.write("P002,Sneha Rao,29,Fracture\n");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("patient.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            System.out.println("Patient ID: " + details[0]);
            System.out.println("Name: " + details[1]);
            System.out.println("Age: " + details[2]);
            System.out.println("Diagnosis: " + details[3]);
            System.out.println("-----");
        }
        reader.close();
    }
}