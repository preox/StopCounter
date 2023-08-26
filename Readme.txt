
Provide a api-key from Trafiklabs api in app.properties file.
If no key is provided, or if user would like to use json-data that has already been downloaded, supply those as follows:


MockedLineResponse.json
Should contain the json-response from a
https://api.sl.se/api2/LineData.json?model=Line&key=<KEY>&DefaultTransportModeCode=BUS request

MockedJourneyResponse.json
Should contain the json-response from a
https://api.sl.se/api2/LineData.json?model=JourneyPatternPointOnLine&key=<KEY>&DefaultTransportModeCode=BUS request


MockedStopdataResponse.json
Should contain the json-response from a
https://api.sl.se/api2/LineData.json?model=Stop&key=<KEY>&DefaultTransportModeCode=BUS request
