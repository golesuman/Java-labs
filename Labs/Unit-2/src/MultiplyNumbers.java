import java.awt.event.*;
import javax.swing.*;

public class MultiplyNumbers implements ActionListener{
    JButton b1, b2;
    JTextField f1, f2, f3;
    MultiplyNumbers(){
        JFrame f = new JFrame();
        f1 = new JTextField();
        f1.setBounds(200, 200, 100, 50);
        f2 = new JTextField();
        f2.setBounds(200, 250, 100, 50);
        f3 = new JTextField();
        f3.setBounds(200, 300, 100, 50);
        f3.setEditable(false);
        f.add(f1);
        f.add(f2);
        f.add(f3);
        b1 = new JButton("Multiply");
        b1.setBounds(200, 350,100, 50);
        b1.addActionListener(this);
        f.add(b1);
        f.setSize(200, 300);
        f.setLayout(null);
        f.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent event) {
        String txt1 = f1.getText();
        String txt2 = f2.getText();
        int num1 = Integer.parseInt(txt1);
        int num2 = Integer.parseInt(txt2);
        if(event.getSource() == b1){

            int result = num1 * num2;
            f3.setText(String.valueOf(result));

        }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    public static void main(String[] args) {
        new MultiplyNumbers();
    }

}
