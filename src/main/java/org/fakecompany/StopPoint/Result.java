package org.fakecompany.StopPoint;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result{
    @JsonProperty("StopPointNumber")
    private int stopPointNumber;
    @JsonProperty("StopPointName")
    private String stopPointName;
    @JsonProperty("StopAreaNumber")
    private int stopAreaNumber;
    @JsonProperty("LocationNorthingCoordinate")
    private String locationNorthingCoordinate;
    @JsonProperty("LocationEastingCoordinate")
    private String locationEastingCoordinate;
    @JsonProperty("ZoneShortName")
    private String zoneShortName;
    @JsonProperty("StopAreaTypeCode")
    private String stopAreaTypeCode;
    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    public int getStopPointNumber() {
        return stopPointNumber;
    }

    public String getStopPointName() {
        return stopPointName;
    }

    public int getStopAreaNumber() {
        return stopAreaNumber;
    }

    public String getLocationNorthingCoordinate() {
        return locationNorthingCoordinate;
    }

    public String getLocationEastingCoordinate() {
        return locationEastingCoordinate;
    }

    public String getZoneShortName() {
        return zoneShortName;
    }

    public String getStopAreaTypeCode() {
        return stopAreaTypeCode;
    }

    public String getLastModifiedUtcDateTime() {
        return lastModifiedUtcDateTime;
    }

    public String getExistsFromDate() {
        return existsFromDate;
    }
}