package it.unibo.mvc;

/**
 * Controller interface, manages I/O access.
 */
public interface Controller {

    /**
     * 
     */
    void printString();

    /**
     * 
     * @return the current string of data
     */
    String getString();

    /**
     * 
     * @param newInput
     */
    void setString(String newInput);

}
