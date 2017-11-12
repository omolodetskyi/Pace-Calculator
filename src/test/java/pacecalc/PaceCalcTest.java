package pacecalc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaceCalcTest {

	PaceCalc mycalc = new PaceCalc(); // declare and initiate PaceCalc which
										// will be tested

	@Test
	public void test() {

		// test set and get for distance

		mycalc.setDistance(2000);
		int distance = mycalc.getDistance();
		Assert.assertEquals(distance, 2000, "Wrong distance!");

		// test set and get for time

		mycalc.setTime(3600);
		int time = mycalc.getTime();
		Assert.assertEquals(time, 3600, "Wrong time!");

		// test set and get for pace

		mycalc.setPace(360);
		int pace = mycalc.getPace();
		Assert.assertEquals(pace, 360, "Wrong pace!");

		// test set and get for speed

		mycalc.setSpeed(5.34);
		double speed = mycalc.getSpeed();
		Assert.assertEquals(speed, 5.34, "Wrong speed!");

	}
}
