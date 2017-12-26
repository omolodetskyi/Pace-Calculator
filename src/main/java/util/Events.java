package util;

import java.util.HashMap;

public class Events {

	// method returns distance depends on event

	public int returnDistance(String eventName) {
		try {
			HashMap<String, Integer> eventArray = new HashMap<String, Integer>();
			eventArray.put("Marathon", Constants.MARATHON_DISTANCE_INMETERS);
			eventArray.put("Halfmarathon", Constants.HALFMARATHON_DISTANCE_INMETERS);
			eventArray.put("10k", Constants.TENKM_DISTANCE_INMETERS);
			return eventArray.get(eventName);

		} catch (NullPointerException e) {
			return 0;
		}

	}
}
