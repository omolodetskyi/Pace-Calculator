package pacecalc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaceCalcTest {
	@Test
	public void test() {
		PaceCalc mycalc = new PaceCalc();
		mycalc.setDistance(2000);
		int distance = mycalc.getDistance();
		Assert.assertEquals(distance, 2000, "Wrong distance!");
		mycalc.setTime(3600);
		int time = mycalc.getTime();
		Assert.assertEquals(time, 3600, "Wrong time!");
		mycalc.setPace(360);
		int pace = mycalc.getPace();
		Assert.assertEquals(pace, 360, "Wrong pace!");
		mycalc.setSpeed(5.34);
		double speed = mycalc.getSpeed();
		Assert.assertEquals(speed, 5.34, "Wrong speed!");

	}
}
