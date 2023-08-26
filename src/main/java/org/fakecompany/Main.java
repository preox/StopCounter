package org.fakecompany;

import com.google.common.collect.Multimap;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {


    public static void main(String[] args) {

        TrafikLabClient client = new TrafikLabClient();

        List<BusLine> busLineList = client.getBusLineList();
        Multimap<Integer, Integer> busLineStopMap = client.getBusLineStopMap();
        List<BusStop> busStops = client.getBusStop();

        busLineList.forEach(line -> busLineStopMap.get(line.getLineNumber())
                .forEach(stop -> line.addBusStopName(getStopPointNameFromId(stop, busStops))));

        List<BusLine> topLines = busLineList.stream()
                .sorted(Comparator.comparingInt(BusLine::getStopCount).reversed()).toList().subList(0, 10);
        System.out.println("Top 10 list: ");
        System.out.println("-------------");
        topLines.forEach(System.out::println);

        System.out.println("-------------");
        System.out.println("Stop points for line " + topLines.get(0) + "\n");
        topLines.get(0).stopPointNames.forEach(System.out::println);

    }

    private static String getStopPointNameFromId(int id, List<BusStop> busStops) {
        Optional<BusStop> first = busStops.stream().filter(s -> s.getStopId() == id).findFirst();
        if (first.isEmpty()) {
            return "";
        } else {
            return first.get().getStopPointName();
        }

    }


}