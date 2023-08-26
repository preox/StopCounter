package org.fakecompany.StopPoint;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResponseData{
    @JsonProperty("Version")
    private String version;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Result")
    private ArrayList<Result> result;

    public String getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Result> getResult() {
        return result;
    }
}