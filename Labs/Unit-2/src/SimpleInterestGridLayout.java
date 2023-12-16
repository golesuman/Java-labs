import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class SimpleInterestGridLayout implements ActionListener {
    JButton b1;
    JTextField principalField, timeField, rateField, resultField;
    SimpleInterestGridLayout(){
        JFrame frame = new JFrame();

        b1 = new JButton("Calculate");
        b1.setBounds(200, 280, 20, 20);
        b1.addActionListener(this);

        JLabel l1 = new JLabel("Principal");
        l1.setBounds(150, 220, 50, 20);
        principalField = new JTextField();
        principalField.setBounds(200, 200, 100, 20);
        JLabel l2 = new JLabel("Time");
        l2.setBounds(150, 220, 50, 20);
        timeField = new JTextField();
        timeField.setBounds(200, 220, 100, 20);
        JLabel l3 = new JLabel("Rate");
        l3.setBounds(150, 240, 50, 20);
        rateField = new JTextField();
        rateField.setBounds(200, 240, 100, 20);
        JLabel l4 = new JLabel("Result");
        l4.setBounds(150, 260, 50, 20);
        resultField = new JTextField();
        resultField.setBounds(200, 260, 100, 20);
        resultField.setEditable(false);
        frame.add(l1);
        frame.add(principalField);
        frame.add(l2);
        frame.add(timeField);
        frame.add(l3);
        frame.add(rateField);
        frame.add(l4);
        frame.add(resultField);
        frame.add(b1);
        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String principal = principalField.getText();
        String time = timeField.getText();
        String rate = rateField.getText();
        double principalValue = Double.parseDouble(principal);
        double timeValue = Double.parseDouble(time);
        double rateValue = Double.parseDouble(rate);

        if (actionEvent.getSource() == b1) {
            double result = (principalValue * timeValue * rateValue) / 100;
            String stringResult = String.valueOf(result);
            resultField.setText(stringResult);
        }
    }
    public static void main(String[] args){
        new SimpleInterestGridLayout();
    }
}
