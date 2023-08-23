package org.fakecompany;

public class BusStop {
    private int stopId;
    private String stopPointName;

    public BusStop(int stopId, String stopPointName) {
        this.stopId = stopId;
        this.stopPointName = stopPointName;
    }

    public BusStop(int stopId) {
        this.stopId = stopId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopPointName(String stopPointName) {
        this.stopPointName = stopPointName;
    }

    public String getStopPointName() {
        return stopPointName;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "stopPointNumber=" + stopId +
                ", stopPointName='" + stopPointName + '\'' +
                '}';
    }
}
