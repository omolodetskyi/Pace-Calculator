package pacecalc;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.Events;

public class EventsTest {

	@Test

	// test verifies that Events class returns corresponded distance in meters

	public void returnDistanceTest() {
		Events event = new Events();
		int eventDistance;

		// Marathon should return 42195
		eventDistance = event.returnDistance("Marathon");
		Assert.assertEquals(eventDistance, 42195, "Test marathon distance return. Wrong value!");

		// Halfarathon should return 21097
		eventDistance = event.returnDistance("Halfmarathon");
		Assert.assertEquals(eventDistance, 21097, "Test halfmarathon distance return. Wrong value!");

		// 10k should return 10000
		eventDistance = event.returnDistance("10k");
		Assert.assertEquals(eventDistance, 10000, "Test 10k distance return. Wrong value!");
	}

}
