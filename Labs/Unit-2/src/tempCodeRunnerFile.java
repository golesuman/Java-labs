import javax.swing.*;
import java.awt.event.*;

class AddNumbersWithActionListener implements ActionListener {
    JTextField t1, t2, t3;
    JButton b1;

    AddNumbersWithActionListener() {
        JFrame f = new JFrame();
        t1 = new JTextField();
        t1.setBounds(50, 50, 150, 20);
        t2 = new JTextField();
        t2.setBounds(50, 80, 150, 20);
        t3 = new JTextField();
        t3.setBounds(50, 110, 150, 20);
        f.add(t1);
        f.add(t2);
        f.add(t3);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(30, 140, 80, 20);
        f.add(b1);

        f.setSize(300, 200);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new AddNumbersWithActionListener();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String txt = t1.getText();
        String txt2 = t2.getText();

        int a = Integer.parseInt(txt);
        int b = Integer.parseInt(txt2);
        if (event.getSource() == b1) {
            int result = a + b;
            t3.setText(String.valueOf(result));
        }
    }
}
