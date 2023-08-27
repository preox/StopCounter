package org.fakecompany.JourneyPatternData;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("LineNumber")
    private int lineNumber;
    @JsonProperty("DirectionCode")
    private int directionCode;
    @JsonProperty("JourneyPatternPointNumber")
    private int journeyPatternPointNumber;
    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String existsFromDate;

    public int getLineNumber() {
        return lineNumber;
    }

    public int getDirectionCode() {
        return directionCode;
    }

    public int getJourneyPatternPointNumber() {
        return journeyPatternPointNumber;
    }

    public String getLastModifiedUtcDateTime() {
        return lastModifiedUtcDateTime;
    }

    public String getExistsFromDate() {
        return existsFromDate;
    }
}
