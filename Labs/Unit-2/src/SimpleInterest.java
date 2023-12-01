import java.awt.event.*;
import javax.swing.*;

public class SimpleInterest implements ActionListener {

    JTextField t1, t2, t3, t4;
    JButton b1, b2;

    SimpleInterest() {
        JFrame f = new JFrame();
        JLabel l1 = new JLabel("Principal");
        l1.setBounds(100, 200, 100, 50); // Set the bounds for the label
        t1 = new JTextField();
        t1.setBounds(200, 200, 100, 50);
        
        JLabel l2 = new JLabel("Time");
        l2.setBounds(100, 250, 100, 50); // Set the bounds for the label
        t2 = new JTextField();
        t2.setBounds(200, 250, 100, 50);
        
        JLabel l3 = new JLabel("Rate");
        l3.setBounds(100, 300, 100, 50); // Set the bounds for the label
        t3 = new JTextField();
        t3.setBounds(200, 300, 100, 50);
        
        JLabel l4 = new JLabel("Result");
        l4.setBounds(100, 350, 100, 50); // Set the bounds for the label
        t4 = new JTextField();
        t4.setBounds(200, 350, 100, 50);
        t4.setEditable(false);
        f.add(l1); f.add(t1); f.add(l2); f.add(t2); f.add(l3); f.add(t3); f.add(l4); f.add(t4);

        b1 = new JButton("Calculate");
        b1.setBounds(200, 400, 100, 30);
        b1.addActionListener(this);
        f.add(b1);

        f.setLayout(null); // Set layout manager to null for absolute positioning
        f.setSize(400, 500); // Set a reasonable size
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String p = t1.getText();
        String t = t2.getText();
        String r = t3.getText();
        float p1 = Float.parseFloat(p);
        float r1 = Float.parseFloat(r);
        int t1 = Integer.parseInt(t);
        if (event.getSource() == b1) {
            double res = (p1 * t1 * r1) / 100;
            t4.setText(String.valueOf(res));
        }
    }

    public static void main(String[] args) {
        new SimpleInterest();
    }
}
