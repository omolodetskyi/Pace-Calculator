package util;

import java.util.HashMap;

public class Events {

	// method returns distance depends on event

	public int returnDistance(String eventName) {
		try {
			HashMap<String, Integer> eventArray = new HashMap<String, Integer>();
			eventArray.put("Marathon", Constants.MARATHON_DISTANCE_IN_METERS);
			eventArray.put("Halfmarathon", Constants.HALFMARATHON_DISTANCE_IN_METERS);
			eventArray.put("10k", Constants.TEN_KM_DISTANCE_IN_METERS);
			return eventArray.get(eventName);

		} catch (NullPointerException e) {
			return 0;
		}
	}
}
