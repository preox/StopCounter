package org.fakecompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class TrafikLabClient {

    private String apiKey;
    private static String propFileName = "app.properties";
    private String baseURI;
    private boolean useMockedData = false;
    public TrafikLabClient() {

        try {
            PropertiesReader propReader = new PropertiesReader(propFileName);
            apiKey = propReader.getProperty("api-key");
            if (apiKey.isEmpty() || apiKey.isBlank()){
                System.out.println("No api-key supplied, using mocked data");
                useMockedData = true;
            }
            baseURI = propReader.getProperty("baseURI");
            System.out.println("BaseURI: " + baseURI);

        } catch (Exception ex) {
            throw new RuntimeException("Problems while reading properties-file!");
        }

    }

    private String performHttpRequest(String URI) {
        try {
            URI requestUri = new URI(URI);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(requestUri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Received HTTP response: " + response.statusCode() + " Body: " + response.body());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String readMockedJsonFile(String fileName) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            StringBuilder resultStringBuilder = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
            return resultStringBuilder.toString();
        } catch (Exception exception) {
            throw new RuntimeException("Error " + exception);
        }
    }

    /**
     * Returns a Multimap of Keys (buslines) with a set of values corresponding to stoppoints.
     */
    public Multimap<Integer, Integer> getBusLineStopMap() {
        String responseBody;
        if (useMockedData) {
            responseBody = readMockedJsonFile("MockedJourneyResponse.json");
        } else {
            responseBody = this.performHttpRequest(baseURI + "?model=JourneyPatternPointOnLine&key=" + apiKey + "&DefaultTransportModeCode=BUS");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            org.fakecompany.JourneyPatternData.Root root = mapper.readValue(responseBody, org.fakecompany.JourneyPatternData.Root.class);
            if (root.getStatusCode() != 0) {
                throw new RuntimeException("Response not ok! " + root.getMessage());
            }

            Multimap<Integer, Integer> result = ArrayListMultimap.create();
            root.getResponseData().getResult().forEach(s -> result.put(s.getLineNumber(), s.getJourneyPatternPointNumber()));

            return result;

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Returns  the line of available bus lines
     */
    public List<BusLine> getBusLineList() {
        String responseBody;
        if (useMockedData) {
            responseBody = readMockedJsonFile("MockedLineResponse.json");
        } else {
            responseBody = this.performHttpRequest(baseURI + "?model=Line&key=" + apiKey + "&DefaultTransportModeCode=BUS");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            org.fakecompany.LineData.Root root = mapper.readValue(responseBody, org.fakecompany.LineData.Root.class);

            if (root.getStatusCode() != 0) {
                throw new RuntimeException("Response not ok! " + root.getMessage());
            }

            return root.getResponseData().getResult()
                    .stream().map(s -> new BusLine(s.getLineNumber(), s.getLineDesignation())).collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Returns the list of all available stop points. For buses.
     */
    public List<BusStop> getBusStop() {
        String responseBody;
        if (useMockedData) {
            responseBody = readMockedJsonFile("MockedStopdataResponse.json");
        } else {
            responseBody = this.performHttpRequest(baseURI + "?model=Stop&key=" + apiKey + "&DefaultTransportModeCode=BUS");
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            org.fakecompany.StopPoint.Root root = mapper.readValue(responseBody, org.fakecompany.StopPoint.Root.class);
            if (root.getStatusCode() != 0) {
                throw new RuntimeException("Response not ok! " + root.getMessage());
            }

            return root.getResponseData().getResult().stream()
                    .filter(s -> s.getStopAreaTypeCode().equalsIgnoreCase("BUSTERM"))
                    .map(s -> new BusStop(s.getStopPointNumber(), s.getStopPointName(), s.getStopAreaNumber()))
                    .collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
