package Assignment18;
import javax.swing.*;
import java.awt.event.*;

public class BankBalanceCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Balance Calculator");

        JLabel balanceLabel = new JLabel("Initial Balance: ");
        balanceLabel.setBounds(30,30,120,25);
        JTextField balanceField = new JTextField();
        balanceField.setBounds(160,30,120,25);

        JLabel transactionLabel = new JLabel("Transaction Amount: ");
        transactionLabel.setBounds(30,70,120,25);
        JTextField transactionField = new JTextField();
        transactionField.setBounds(160,70,120,25);

        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(30,250,350,60);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(30,110,90,25);
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(130,110,90,25);
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(80,140,90,25);

        depositButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (balanceField.getText().isEmpty() || transactionField.getText().isEmpty()) {
                    resultLabel.setText("Fields are Empty!");
                    return;
                }

                try {
                    int balance = Integer.parseInt(balanceField.getText());
                    int amount = Integer.parseInt(transactionField.getText());
                    int updatedBalance = balance + amount;

                    balanceField.setText(String.valueOf(updatedBalance));
                    resultLabel.setText("<html>Deposited " + amount + ". Updated Balance: " + updatedBalance + "</html>");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers!");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (balanceField.getText().isEmpty() || transactionField.getText().isEmpty()) {
                    resultLabel.setText("Fields are Empty!");
                    return;
                }

                try {
                    int balance = Integer.parseInt(balanceField.getText());
                    int amount = Integer.parseInt(transactionField.getText());

                    if (amount > balance) {
                        resultLabel.setText("Insufficient Balance!");
                        return;
                    }

                    int updatedBalance = balance - amount;
                    balanceField.setText(String.valueOf(updatedBalance));
                    resultLabel.setText("<html>Withdrew " + amount + ". Updated Balance: " + updatedBalance + "</html>");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers!");
                }
            }
        });

        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                balanceField.setText("");
                transactionField.setText("");
                resultLabel.setText("");
            }
        });

        frame.add(balanceLabel);
        frame.add(balanceField);
        frame.add(transactionLabel);
        frame.add(transactionField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(clearButton);
        frame.add(resultLabel);

        frame.setSize(400,350);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}