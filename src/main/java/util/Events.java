package util;

import java.util.HashMap;

public class Events {

	// method returns distance depends on event

	public int returnDistance(String eventName) {
		try {
			HashMap<String, Integer> eventArray = new HashMap<String, Integer>();
			eventArray.put("Marathon", 42195);
			eventArray.put("Halfmarathon", 21097);
			eventArray.put("10k", 10000);
			return eventArray.get(eventName);

		} catch (NullPointerException e) {
			return 0;
		}

	}
}
