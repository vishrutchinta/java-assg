package Assignment17;
import javax.swing.*;
import java.awt.event.*;

public class StudentGUISwing {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Student Resgistration Form");

        JLabel label_name = new JLabel("Name:");
        label_name.setBounds(30,30,80,25);
        JTextField nameField = new JTextField();
        nameField.setBounds(130,30,180,25);

        JLabel prn = new JLabel("PRN: ");
        prn.setBounds(30,70,180,25);
        JTextField prnField = new JTextField();
        prnField.setBounds(130,70,180,25);

        JLabel branch = new JLabel("Branch: ");
        branch.setBounds(30,110,80,25);

        String[] branches = {"CSE","IT","ENTC","Mech","Civil"};
        JComboBox<String> branchBox = new JComboBox<>(branches);
        branchBox.setBounds(130,110,180,25);

        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(30,150,80,25);

        JRadioButton male = new JRadioButton("Male: ");
        male.setBounds(130,150,80,25);

        JRadioButton female = new JRadioButton("Female: ");
        female.setBounds(200,150,80,30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(80,200,100,30);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(200,200,100,30);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(30,250,350,60);

        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText();
                String prnn = prnField.getText();
                String Branch = (String) branchBox.getSelectedItem();
                String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "not Specified";

                if(name.isEmpty() || prnn.isEmpty()){
                    resultLabel.setText("Please fill name and roll no. correctly");
                }else{
                    resultLabel.setText("<html>Registered: "+name+
                        "<br>Roll No: "+prnn+
                        "<br>Branch: "+Branch+
                        "<br>Gender: "+gender+"</html>");
                    
                }

            }
        });

        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                nameField.setText("");
                prnField.setText("");
                branchBox.setSelectedIndex(0);
                genderGroup.clearSelection();
                resultLabel.setText("");

            }

            
        });
        frame.add(label_name);
        frame.add(nameField);
        frame.add(prn);
        frame.add(prnField);
        frame.add(branch);
        frame.add(branchBox);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);
        frame.add(submitButton);
        frame.add(clearButton);
        frame.add(resultLabel);

        frame.setSize(400, 350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);










    }

    
}
