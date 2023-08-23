package org.fakecompany.LineData;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("LineNumber")
    private int lineNumber;
    @JsonProperty("LineDesignation")
    private String lineDesignation;
    @JsonProperty("DefaultTransportMode")
    private String defaultTransportMode;
    @JsonProperty("DefaultTransportModeCode")
    private String defaultTransportModeCode;
    @JsonProperty("LastModifiedUtcDateTime")
    private String lastModifiedUtcDateTime;
    @JsonProperty("ExistsFromDate")
    private String existsFromDate;
    public int getLineNumber() {
        return lineNumber;
    }
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
    public String getLineDesignation() {
        return lineDesignation;
    }
    public void setLineDesignation(String lineDesignation) {
        this.lineDesignation = lineDesignation;
    }
    public String getDefaultTransportMode() {
        return defaultTransportMode;
    }
    public void setDefaultTransportMode(String defaultTransportMode) {
        this.defaultTransportMode = defaultTransportMode;
    }
    public String getDefaultTransportModeCode() {
        return defaultTransportModeCode;
    }
    public void setDefaultTransportModeCode(String defaultTransportModeCode) {
        this.defaultTransportModeCode = defaultTransportModeCode;
    }
    public String getLastModifiedUtcDateTime() {
        return lastModifiedUtcDateTime;
    }
    public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
        this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
    }
    public String getExistsFromDate() {
        return existsFromDate;
    }
    public void setExistsFromDate(String existsFromDate) {
        this.existsFromDate = existsFromDate;
    }
}
