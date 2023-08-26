package org.fakecompany;

import java.util.*;

public class BusLine {

    private int lineNumber;
    private String lineDesignation;


    HashSet<String> stopPointNames = new HashSet<>();

    public BusLine(int lineNumber, String lineDesignation) {
        this.lineNumber = lineNumber;
        this.lineDesignation = lineDesignation;
    }

    public int getLineNumber() {
        return lineNumber;
    }


    public void addBusStopName(String name) {
        stopPointNames.add(name);
    }

    public int getStopCount() {
        return stopPointNames.size();
    }


    @Override
    public String toString() {
        return "BusLine " +
                "lineNumber=" + lineNumber +
                ", number of stops='" + stopPointNames.size();
    }
}
