package pacecalc.ulils;

import org.testng.Assert;
import org.testng.annotations.Test;

import pacecalc.util.Events;

public class EventsTest {

	@Test
	public void returnDistanceTest() {
		Assert.assertEquals(Events.returnDistance("Marathon"), 42195, "Test marathon distance return. Wrong value!");
		Assert.assertEquals(Events.returnDistance("Halfmarathon"), 21097, "Test halfmarathon distance return. Wrong value!");
		Assert.assertEquals(Events.returnDistance("10k"), 10000, "Test 10k distance return. Wrong value!");
	}
}
