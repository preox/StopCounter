package org.fakecompany;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class TrafikLabClient {

    private static String model = "line";
    private static String transportMode = "bus";
    private static String apiKey;
    private static String baseURI = "https://api.sl.se/api2/LineData.json";
    private boolean useMockedData;

    public TrafikLabClient(String keyFromProperties, boolean useMockedData) {
        apiKey = keyFromProperties;
        this.useMockedData = useMockedData;
    }

    public List<JourneyStop> getBusStopList() {
        String responseBody;
        if (useMockedData) {

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("MockedJourneyResponse.txt");

            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
                responseBody = resultStringBuilder.toString();
            } catch (Exception exception) {
                throw new RuntimeException("Error " + exception);
            }
        } else {
            URI requestUri = null;
            try {
                requestUri = new URI(baseURI + "?model=JourneyPatternPointOnLine&key=" + apiKey + "&DefaultTransportModeCode=BUS");
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(requestUri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            responseBody = response.body();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            org.fakecompany.JourneyPatternData.Root root = mapper.readValue(responseBody, org.fakecompany.JourneyPatternData.Root.class);


            return root.getResponseData().getResult().stream().map(s -> new JourneyStop( s.lineNumber, s.journeyPatternPointNumber)).collect(Collectors.toList());


        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<BusLine> getBusLineList() {
        String responseBody;
        if (useMockedData) {

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("MockedLineResponse.txt");

            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
                responseBody = resultStringBuilder.toString();
            } catch (Exception exception) {
                throw new RuntimeException("Error " + exception);
            }
        } else {
            URI requestUri = null;
            try {
                requestUri = new URI(baseURI + "?model=Line&key=" + apiKey + "&DefaultTransportModeCode=BUS");
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(requestUri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            responseBody = response.body();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            org.fakecompany.LineData.Root root = mapper.readValue(responseBody, org.fakecompany.LineData.Root.class);

            return root.getResponseData().getResult()
                    .stream().map(s -> new BusLine(s.getLineNumber(), s.getLineDesignation())).collect(Collectors.toList());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
