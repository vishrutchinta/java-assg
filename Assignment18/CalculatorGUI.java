package Assignment18;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calulator");

        JLabel Number1 = new JLabel("First Number: ");
        Number1.setBounds(30,30,110,25);
        JTextField no1 = new JTextField();
        no1.setBounds(150,30,110,25);

        JLabel Number2 = new JLabel("Second Number: ");
        Number2.setBounds(30,70,110,25);
        JTextField no2 = new JTextField();
        no2.setBounds(150,70,110,25);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(30,250,350,60);

        JButton addButton = new JButton("Add");
        addButton.setBounds(30,100,80,25);
        JButton subtractButton = new JButton("Subtract");
        subtractButton.setBounds(110,100,80,25);
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(70,130,80,25);

        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (no1.getText().isEmpty() || no2.getText().isEmpty()) {
                    resultLabel.setText("Fields are Empty!");
                }
                int num1 = Integer.parseInt(no1.getText());
                int num2 = Integer.parseInt(no2.getText());

                int sum = num1+num2;
                
                    resultLabel.setText("<html>The sum of "+num1+" and "+num2+" is "+sum+"</html>");
                

            }
        });

        subtractButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (no1.getText().isEmpty() || no2.getText().isEmpty()) {
                    resultLabel.setText("Fields are Empty!");
                }
                int numm1 = Integer.parseInt(no1.getText());
                int numm2 = Integer.parseInt(no2.getText());
                int diff = numm1+numm2;
                
                    resultLabel.setText("<html>The diff of "+numm1+" and "+numm2+" is "+diff+"</html>");
                

            }
        });

        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                no1.setText("");
                no2.setText("");

            }

        });
        frame.add(Number1);
        frame.add(no1);
        frame.add(Number2);
        frame.add(no2);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(clearButton);
        frame.add(resultLabel);

        frame.setSize(400,350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
    
}
