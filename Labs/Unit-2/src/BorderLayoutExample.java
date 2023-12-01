import javax.swing.*;

public class BorderLayoutExample extends JFrame {

    public BorderLayoutExample() {
        // Set up the frame
        setTitle("BorderLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");
        JButton centerButton = new JButton("Center");

        // Set up BorderLayout
        setLayout(new java.awt.BorderLayout());

        // Add buttons to the frame with specified regions
        add(northButton, java.awt.BorderLayout.NORTH);
        add(southButton, java.awt.BorderLayout.SOUTH);
        add(eastButton, java.awt.BorderLayout.EAST);
        add(westButton, java.awt.BorderLayout.WEST);
        add(centerButton, java.awt.BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderLayoutExample().setVisible(true);
            }
        });
    }
}
