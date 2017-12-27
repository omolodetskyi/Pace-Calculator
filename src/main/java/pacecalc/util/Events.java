package pacecalc.util;

import java.util.HashMap;

public class Events {

	private static HashMap<String, Integer> eventArray = new HashMap<>();

	static {
		eventArray.put("Marathon", 42195);
		eventArray.put("Halfmarathon", 21097);
		eventArray.put("10k", 10000);
	}

	public static int returnDistance(String eventName) {
		return eventArray.getOrDefault(eventName, 0);
	}
}
