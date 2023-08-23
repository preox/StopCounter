package org.fakecompany;

public class JourneyStop {

    private int lineNumber;
    private int journeyPatternPointNumber;

    public JourneyStop(int lineNumber, int journeyPatternPointNumber) {
        this.lineNumber = lineNumber;
        this.journeyPatternPointNumber = journeyPatternPointNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getJourneyPatternPointNumber() {
        return journeyPatternPointNumber;
    }

    public void setJourneyPatternPointNumber(int journeyPatternPointNumber) {
        this.journeyPatternPointNumber = journeyPatternPointNumber;
    }
}
