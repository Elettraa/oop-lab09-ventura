package it.unibo.mvc;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * SimpleController implementation of Controller interface.
 */
public final class SimpleController implements Controller {
    private String currentData;
    private final List<String> historyOfPreviousData;

    /**
     * Builds a new SimpleController.
     */
    public SimpleController() {
        this.currentData = "";
        historyOfPreviousData = new ArrayList<>();
    }

    @Override
    public void printString() {
        if (this.currentData.isBlank() || this.currentData.isEmpty()) {
            throw new IllegalStateException("Empty or blank string");
        }
        out.println(this.currentData);
        historyOfPreviousData.add(this.currentData);
    }

    @Override
    public String getString() {
        return this.currentData;
    }

    @Override
    public void setString(final String newInput) {
        if (newInput.isBlank() || newInput.isEmpty()) {
            throw new IllegalStateException("Empty or blank string");
        }
        this.currentData = newInput;
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(historyOfPreviousData);
    }

}
