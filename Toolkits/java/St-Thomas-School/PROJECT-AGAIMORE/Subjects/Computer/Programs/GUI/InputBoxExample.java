package Subjects.Computer.Programs.GUI;


/**
 * Write a description of class InputBoxExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;

public class InputBoxExample {
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Input Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        // Create a panel to hold the input box
        JPanel panel = new JPanel();

        // Create a label and a JTextField
        JLabel label = new JLabel("Enter your text:");
        JTextField inputBox = new JTextField(20); // 20 columns wide

        // Add the label and input box to the panel
        panel.add(label);
        panel.add(inputBox);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
