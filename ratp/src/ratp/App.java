package ratp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
	Line M14 = buildLine("M14");
	String[] stationNamesM14 = { "Saint-Lazare", "Madeleine", "Pyramides",
		"Chatelet", "Gare de Lyon", "Bercy", "Cour Saint-Emilion",
		"Bibliotheque François-Mitterrand", "Olympiades" };
	int[] durationsM14 = { 2, 2, 2, 4, 3, 1, 1, 1 };
	List<Station> stationsM14 = buildStations(M14, stationNamesM14);
	List<Journey> journeys = buildJourneys(stationsM14, durationsM14);
	itinerary(stationsM14.get(2), stationsM14.get(4), journeys,
		stationsM14);
    }

    static Line buildLine(String name) {
	return new Line(name);
    }

    static List<Station> buildStations(Line line, String[] names) {
	List<Station> list = new ArrayList<>();
	for (String name : names) {
	    Station station = new Station(name, line);
	    list.add(station);
	}
	return list;
    }

    static List<Journey> buildJourneys(List<Station> stations,
	    int[] durations) {
	List<Journey> list = new ArrayList<>();
	for (int i = 0; i < stations.size() - 1; i++) {
	    Journey journey = new Journey(stations.get(i), stations.get(i + 1),
		    durations[i]);
	    list.add(journey);
	}
	return list;
    }

    static int itinerary(Station userDeparture, Station userArrival,
	    List<Journey> journeys, List<Station> stations) {
	int result = 0;
	boolean moving = false;
	boolean reverse = false;
	if (stations.indexOf(userDeparture) > stations.indexOf(userArrival)) {
	    reverse = true;
	    Collections.reverse(journeys);
	}
	for (Journey journey : journeys) {
	    Station departure;
	    Station arrival;
	    if (!reverse) {
		departure = journey.getDeparture();
		arrival = journey.getArrival();
	    } else {
		departure = journey.getArrival();
		arrival = journey.getDeparture();
	    }
	    if (userDeparture != userArrival) {
		if (departure.equals(userDeparture) || moving) {
		    result += journey.getDuration();
		    moving = true;
		}
		if (arrival.equals(userArrival)) {
		    moving = false;
		}
	    }
	}
	System.out
		.println(userDeparture.getName() + "-" + userArrival.getName());
	System.out.println(result);
	return result;
    }
}
