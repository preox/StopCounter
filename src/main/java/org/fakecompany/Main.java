package org.fakecompany;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static String appKey;
    private static String propFileName = "app.properties";

    public static void main(String[] args) {
        try {
            PropertiesReader propReader = new PropertiesReader(propFileName);
            appKey = propReader.getProperty("api-key");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + e);
        }

        TrafikLabClient client = new TrafikLabClient(appKey, true);

        List<BusLine> busLineList = client.getBusLineList();
        System.out.println("Got " + busLineList.size() + " number of buslines");

        List<JourneyStop> journeyStops = client.getBusStopList();


        busLineList.forEach( s -> {
            // för varje linje, kolla i journeystop om den hittas, och lägg på alla jag hittar i linjens egna lista med stop
            journeyStops.stream().filter(t -> t.getLineNumber()==s.getLineNumber()).forEach( u -> s.addBusStop(new BusStop(u.getJourneyPatternPointNumber())));

        });
        List<BusLine> topLines = busLineList.stream().sorted(Comparator.comparingInt(BusLine::getStopCount).reversed()).collect(Collectors.toList()).subList(0, 10);

        System.out.println("Top 10 list: ");
        System.out.println("-------------");
        topLines.stream().forEach( s -> System.out.println(s));


    }





}