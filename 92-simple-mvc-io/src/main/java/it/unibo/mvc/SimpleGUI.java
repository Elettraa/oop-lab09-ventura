package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.io.PrintStream;
//import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Controller controller;
    private static final int PROPORTION = 3;

    /**
     * Builds a new SimpleGUI.
     */
    private SimpleGUI() {
        this.controller = new Controller();
        setUp();
    }

    /**
     * Sets up the panels.
     */
    private void setUp() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton saveButton = new JButton("Write on file");
        canvas.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * Handlers.
         */
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.write(textArea.getText() + "\n");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Displays on screen the panels.
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
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }

}
