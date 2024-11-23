package it.unibo.mvc;

import java.util.List;

/**
 * Controller interface, manages I/O access.
 */
public interface Controller {

    /**
     * A method that prints the current string. If the current string is unset, an
     * IllegalStateException should be thrown.
     */
    void printString();

    /**
     * A method for getting the next string to print.
     * 
     * @return the current string of data
     */
    String getString();

    /**
     * A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced.
     * 
     * @param newInput
     */
    void setString(String newInput);

    /**
     * 
     * @return history of previous strings.
     */
    List<String> getHistory();

}
