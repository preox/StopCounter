package org.fakecompany.JourneyPatternData;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("LineNumber")
    public int lineNumber;
    @JsonProperty("DirectionCode")
    public String directionCode;
    @JsonProperty("JourneyPatternPointNumber")
    public int journeyPatternPointNumber;
    @JsonProperty("LastModifiedUtcDateTime")
    public String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    public String existsFromDate;
}
