package org.fakecompany;

import java.util.ArrayList;
import java.util.List;

public class BusLine {

    private int lineNumber;
    private String lineDesignation;

    private List<BusStop> stops;

    public BusLine(int lineNumber, String lineDesignation) {
        this.lineNumber = lineNumber;
        this.lineDesignation = lineDesignation;
        stops = new ArrayList<>();
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLineDesignation() {
        return lineDesignation;
    }

    public void addBusStop(BusStop busStop) {
        stops.add(busStop);
    }

    public List<BusStop> getStops(){
        return stops;
    }

    public int getStopCount(){
        return stops.size();
    }


    @Override
    public String toString() {
        return "BusLine{" +
                "lineNumber=" + lineNumber +
                ", lineDesignation='" + lineDesignation + '\'' +
                ", stop count: " + stops.size() +
                '}';
    }
}
