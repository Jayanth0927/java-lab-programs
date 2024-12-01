import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingDemo {
    SwingDemo() {
        // Create JFrame container
        JFrame jfrm = new JFrame("Divider App");
        jfrm.setSize(300, 200);
        jfrm.setLayout(new FlowLayout());

        // Terminate program on close
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel jlab = new JLabel("Enter the dividend and divisor:");
        JTextField ajtf = new JTextField(8);
        JTextField bjtf = new JTextField(8);
        JButton button = new JButton("Calculate");

        JLabel err = new JLabel(); // Error label
        JLabel alab = new JLabel(); // A value label
        JLabel blab = new JLabel(); // B value label
        JLabel anslab = new JLabel(); // Result label

        // Add components to the frame
        jfrm.add(jlab);
        jfrm.add(ajtf);
        jfrm.add(bjtf);
        jfrm.add(button);
        jfrm.add(err);
        jfrm.add(alab);
        jfrm.add(blab);
        jfrm.add(anslab);

        // Add action listener for the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    int a = Integer.parseInt(ajtf.getText());
                    int b = Integer.parseInt(bjtf.getText());

                    // Check for division by zero
                    if (b == 0) {
                        throw new ArithmeticException("Divisor cannot be zero.");
                    }

                    int ans = a / b;
                    err.setText(""); // Clear error messages
                    alab.setText("A = " + a);
                    blab.setText("B = " + b);
                    anslab.setText("Ans = " + ans);
                } catch (NumberFormatException e) {
                    err.setText("Enter valid integers!");
                    alab.setText("");
                    blab.setText("");
                    anslab.setText("");
                } catch (ArithmeticException e) {
                    err.setText("Divisor cannot be zero!");
                    alab.setText("");
                    blab.setText("");
                    anslab.setText("");
                }
            }
        });

        // Display the frame
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
        // Create frame on Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo();
            }
        });
    }
}
