package org.fakecompany.StopPoint;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @JsonProperty("StatusCode")
    private int statusCode;
    @JsonProperty("Message")
    private Object message;
    @JsonProperty("ExecutionTime")
    private int executionTime;
    @JsonProperty("ResponseData")
    private ResponseData responseData;

    public int getStatusCode() {
        return statusCode;
    }

    public Object getMessage() {
        return message;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public ResponseData getResponseData() {
        return responseData;
    }
}