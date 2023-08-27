package org.fakecompany.JourneyPatternData;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    @JsonProperty("StatusCode")
    private Integer statusCode;
    @JsonProperty("Message")
    private Object message;
    @JsonProperty("ExecutionTime")
    private Integer executionTime;
    @JsonProperty("ResponseData")
    private ResponseData responseData;
    public Integer getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    public Object getMessage() {
        return message;
    }
    public void setMessage(Object message) {
        this.message = message;
    }
    public Integer getExecutionTime() {
        return executionTime;
    }
    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }
    public ResponseData getResponseData() {
        return responseData;
    }
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }
}
