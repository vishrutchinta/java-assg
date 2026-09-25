package Assignment17;
import javax.swing.*;
import java.awt.event.*;

public class EmployeeRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Registration Form");

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(30, 30, 100, 25);
        JTextField idField = new JTextField();
        idField.setBounds(150, 30, 180, 25);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 70, 180, 25);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(30, 110, 100, 25);
        JTextField deptField = new JTextField();
        deptField.setBounds(150, 110, 180, 25);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(30, 150, 100, 25);
        JTextField salaryField = new JTextField();
        salaryField.setBounds(150, 150, 180, 25);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(130, 200, 100, 30);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String dept = deptField.getText();
                String salary = salaryField.getText();

                if (id.isEmpty() || name.isEmpty() || dept.isEmpty() || salary.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Please fill all fields before submitting.",
                            "Incomplete Form",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    String message = "Employee Details\n" +
                            "-----------------------\n" +
                            "Employee ID: " + id + "\n" +
                            "Name: " + name + "\n" +
                            "Department: " + dept + "\n" +
                            "Salary: " + salary;

                    JOptionPane.showMessageDialog(frame,
                            message,
                            "Employee Registered",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.add(idLabel);
        frame.add(idField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(deptLabel);
        frame.add(deptField);
        frame.add(salaryLabel);
        frame.add(salaryField);
        frame.add(submitButton);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
