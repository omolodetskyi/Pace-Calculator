package pacecalc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaceCalcTest {

	PaceCalc mycalc = new PaceCalc(); // declare and initiate PaceCalc which
										// will be tested

	@Test
	public void gettersSettersTest() {

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

	@Test
	public void paceCalcTest() {
		int pace;

		// simple usual distance and time

		mycalc.setDistance(10000);
		mycalc.setTime(3600);
		pace = mycalc.calcPace();
		Assert.assertEquals(pace, 360, "Test simple usual distance and time Wrong pace! ");

		// small distance and big time

		mycalc.setDistance(10);
		mycalc.setTime(3600);
		pace = mycalc.calcPace();
		Assert.assertEquals(pace, 360000, "Test distance small, long time Wrong pace! ");

		// halfmarathon distance and 1 hr time

		mycalc.setDistance(21097);
		mycalc.setTime(3600);
		pace = mycalc.calcPace();
		Assert.assertEquals(pace, 170, "Test halfmarathon by 1 hour Wrong pace! ");

		// halfmarathon distance and very small time
		mycalc.setDistance(21097);
		mycalc.setTime(1);
		pace = mycalc.calcPace();
		Assert.assertEquals(pace, 0, "Test halfmarathon by 1 hour Wrong pace! ");

	}
}
