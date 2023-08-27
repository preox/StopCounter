package org.fakecompany;

public class BusStop {
    private int stopId;
    private String stopPointName;
    private int stopAreaNumber;

    public BusStop(int stopId, String stopPointName, int stopAreaNumber) {
        this.stopId = stopId;
        this.stopPointName = stopPointName;
        this.stopAreaNumber = stopAreaNumber;
    }

    public int getStopId() {
        return stopId;
    }


    public String getStopPointName() {
        return stopPointName;
    }

}
