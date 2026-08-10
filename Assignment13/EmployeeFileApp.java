package Assignment13;

import java.io.*;

public class EmployeeFileApp {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("employee.txt");
        writer.write("101,Vishrut Chinta,55000.0\n");
        writer.write("102,Parth Kulkarni,48000.0\n");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split(",");
            System.out.println("Emp ID: " + details[0] + ", Name: " + details[1] + ", Salary: " + details[2]);
        }
        reader.close();
    }
}