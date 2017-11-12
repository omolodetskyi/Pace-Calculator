package pacecalc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaceCalcTest {

	PaceCalc mycalc = new PaceCalc(); // declare and initiate PaceCalc which
										// will be tested
	int distance, time, pace;
	double speed;

	@Test

	// test for get and set methods

	public void gettersSettersTest() {

		// test set and get for distance

		mycalc.setDistance(2000);
		distance = mycalc.getDistance();
		Assert.assertEquals(distance, 2000, "Wrong distance!");

		// test set and get for time

		mycalc.setTime(3600);
		time = mycalc.getTime();
		Assert.assertEquals(time, 3600, "Wrong time!");

		// test set and get for pace

		mycalc.setPace(360);
		pace = mycalc.getPace();
		Assert.assertEquals(pace, 360, "Wrong pace!");

		// test set and get for speed

		mycalc.setSpeed(5.34);
		speed = mycalc.getSpeed();
		Assert.assertEquals(speed, 5.34, "Wrong speed!");

	}

	@Test

	// test for paceCalc method

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

	@Test

	// test for second constructor of PaceCalc = PaceCalc(int pace, int
	// distance, int time, double speed)

	public void secondConstructorTest() {
		// check constructor PaceCalc(int pace, int distance, int time, double
		// speed)
		PaceCalc mycalcSecondConst = new PaceCalc(276, 30034, 42781, 12.7);

		// check distance which is set by constructor
		distance = mycalcSecondConst.getDistance();
		Assert.assertEquals(distance, 30034, "Wrong distance! ");

		// check time which is set by constructor

		time = mycalcSecondConst.getTime();
		Assert.assertEquals(time, 42781, "Wrong time! ");

		// check time which is set by constructor

		pace = mycalcSecondConst.getPace();
		Assert.assertEquals(pace, 276, "Wrong pace! ");

		// check speed which is set by constructor

		speed = mycalcSecondConst.getSpeed();
		Assert.assertEquals(speed, 12.7, "Wrong speed! ");

	}
}
