package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final Controller controller;
    private static final int PROPORTION = 3;

    /**
     * Creates a new SimpleGUIWithFileChooser.
     */
    private SimpleGUIWithFileChooser() {
        this.controller = new Controller();
        setUp();
    }

    /**
     * Sets Up the SimpleGUI.
     */
    private void setUp() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton saveButton = new JButton("Write on file");
        canvas.add(saveButton, BorderLayout.SOUTH);
        final JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BorderLayout());
        canvas.add(innerPanel, BorderLayout.NORTH);
        final JTextField textField = new JTextField(controller.getCurrentFile().getPath());
        textField.setEditable(false);
        innerPanel.add(textField, BorderLayout.CENTER);
        final JButton browseButton = new JButton("Browse...");
        innerPanel.add(browseButton, BorderLayout.LINE_END);
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
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser("Choose new file");
                if (chooser.showSaveDialog(browseButton) == JFileChooser.APPROVE_OPTION) {
                    controller.setFileAsCurrent(chooser.getSelectedFile());
                    textField.setText(chooser.getSelectedFile().getPath());
                } else if (chooser.showSaveDialog(browseButton) != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, chooser.showSaveDialog(frame), "Error",
                            JOptionPane.ERROR_MESSAGE);
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
        new SimpleGUIWithFileChooser().display();
    }

}
