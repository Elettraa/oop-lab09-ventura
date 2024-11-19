package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output" + ".txt";

    private File current;

    /**
     * Builds a new controller.
     */
    public Controller() {
        this.current = new File(PATH);
    }

    /**
     * A method for setting a File as current file.
     * 
     * @param newFile
     */
    public final void setFileAsCurrent(final File newFile) {
        Objects.requireNonNull(newFile);
        this.current = newFile;
    }

    /**
     * A method that returns the current File.
     * 
     * @return current file
     */
    public final File getCurrentFile() {
        return this.current;
    }

    /**
     * A method for getting the path (in form of String) of the current File.
     * 
     * @return path of current file
     */
    public final String getCurrentPath() {
        return this.current.getPath();
    }

    /**
     * A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * @param input
     * @throws IOException
     */
    public final void write(final String input) throws IOException {
        try (PrintStream ps = new PrintStream(getCurrentPath(), StandardCharsets.UTF_8)) {
            ps.print(input);
        }
    }

}
