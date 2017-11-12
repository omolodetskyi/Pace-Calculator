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

	// test for calcPace method

	public void calcPaceTest() {
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

	// test for calcDistance method

	public void calcDistanceTest() {

		// simple usual pace and time

		mycalc.setPace(360);
		mycalc.setTime(3600);
		distance = mycalc.calcDistance();
		Assert.assertEquals(distance, 10000, "Test simple usual pace and time Wrong distance! ");

		// small pace and big time

		mycalc.setPace(10);
		mycalc.setTime(3600);
		distance = mycalc.calcDistance();
		Assert.assertEquals(distance, 360000, "Test pace small, long time Wrong distance! ");

		// halfmarathon pace and 1:30 hr time

		mycalc.setPace(256);
		mycalc.setTime(5401);
		distance = mycalc.calcDistance();
		Assert.assertEquals(distance, 21097, "Test halfmarathon pace by 1:30 hour Wrong distance! ");

		// small time and big pace

		mycalc.setPace(720);
		mycalc.setTime(20);
		distance = mycalc.calcDistance();
		Assert.assertEquals(distance, 27, "Test small time and big pace Wrong pace! ");

	}

	@Test

	// test for calcTime method
	public void calcTimeTest() {

		// small pace and big distance

		mycalc.setPace(10);
		mycalc.setDistance(42195);
		time = mycalc.calcTime();
		Assert.assertEquals(time, 421, "Test marathon distance, small pace. Wrong time! ");

		// halfmarathon distance and 5min/km pace

		mycalc.setPace(300);
		mycalc.setDistance(21097);
		time = mycalc.calcTime();
		Assert.assertEquals(time, 6329, "Test halfmarathon distance and 5min/km pace Wrong time! ");

		// small distance and big pace

		mycalc.setPace(36000);
		mycalc.setDistance(10);
		time = mycalc.calcTime();
		Assert.assertEquals(time, 360, "Small distance and big pace Wrong time! ");

	}

	@Test

	// test for calcSpeed method

	public void calcSpeedTest() {

		// simple usual pace

		mycalc.setPace(360);
		speed = mycalc.calcSpeed();
		Assert.assertEquals(speed, 10.0, "Test simple usual pace Wrong speed! ");

		// small pace

		mycalc.setPace(10);
		speed = mycalc.calcSpeed();
		Assert.assertEquals(speed, 360.0, "Test small pace Wrong speed! ");

		// halfmarathon 5min/km pace

		mycalc.setPace(300);
		speed = mycalc.calcSpeed();
		Assert.assertEquals(speed, 12.0, "Test  5min/km pace Wrong speed! ");

		// big pace

		mycalc.setPace(36000);
		speed = mycalc.calcSpeed();
		Assert.assertEquals(speed, 0.1, "big pace Wrong speed! ");
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
