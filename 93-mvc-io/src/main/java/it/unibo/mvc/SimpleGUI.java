package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame();
    private final SimpleController controller;

    /**
     * Builds a new SimpleGUI.
     */
    public SimpleGUI() {
        this.controller = new SimpleController();
        setUp();
    }

    /**
     * 
     */
    private void setUp() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField mainText = new JTextField();
        canvas.add(mainText, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        canvas.add(textArea, BorderLayout.CENTER);
        final JPanel buttonPanel = new JPanel(new BorderLayout());
        canvas.add(buttonPanel, BorderLayout.SOUTH);
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show history");
        buttonPanel.add(printButton, BorderLayout.WEST);
        buttonPanel.add(historyButton, BorderLayout.EAST);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * handlers
         */
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.setString(mainText.getText());
                    controller.printString();
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(frame, ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    for (final String previous : controller.getHistory()) {
                        textArea.append(previous + "\n");
                    }
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(frame, ex, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * 
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * 
     * @param args
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
