package pacecalc;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.Parser;

public class ParserTest {

	Parser parser = new Parser(); // declare and initiate Parser which will be
									// tested
	int time, distance, pace;
	double speed;
	String parseTime, parsePace, parseDistance, parseSpeed;

	@Test
	public void timeParserTest() {

		// ***** time parsing *****

		// only hours

		time = 3600;
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals(parseTime, "01:00:00", "Test for only hours: Wrong parse time! ");

		// hours:minutes:seconds

		time = 3663;
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals(parseTime, "01:01:03", "Test for hours:minutes:seconds: Wrong parse time! ");

		// only minutes
		time = 60;
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals(parseTime, "00:01:00", "Test for only minutes: Wrong parse time! ");

		// only seconds

		time = 4;
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals(parseTime, "00:00:04", "Test for only seconds: Wrong parse time! ");

		// none time

		time = 0;
		parseTime = parser.parseFromTime(time);
		Assert.assertEquals(parseTime, "00:00:00", "Test for none time: Wrong parse time! ");
	}

	@Test
	public void parserPaceTest() {

		// ***** pace parsing ****

		// only minutes
		pace = 360;
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals(parsePace, "06:00", "Test for only minutes: Wrong parse pace! ");

		// minutes and seconds

		pace = 382;
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals(parsePace, "06:22", "Test for minutes and seconds: Wrong parse pace! ");

		// only seconds

		pace = 9;
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals(parsePace, "00:09", "Test for only seconds: Wrong parse pace! ");

		// none pace

		pace = 0;
		parsePace = parser.parseFromPace(pace);
		Assert.assertEquals(parsePace, "00:00", "Test for only seconds: Wrong parse pace! ");

	}

	@Test
	public void parseDistanceTest() {

		// ***** distance parsing *****

		// only kilometers

		distance = 2000;
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals(parseDistance, "2.0", "Test for only kilometers: Wrong parse distance! ");

		// kilometers with meters

		distance = 13430;
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals(parseDistance, "13.430", "Test for kilometers with meters: Wrong parse distance! ");

		// only meters

		distance = 31;
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals(parseDistance, "0.031", "Test for only meters: Wrong parse distance! ");

		// only 1 meter

		distance = 1;
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals(parseDistance, "0.001", "Test for 1 meter: Wrong parse distance! ");

		// zero value

		distance = 0;
		parseDistance = parser.parseFromDistance(distance);
		Assert.assertEquals(parseDistance, "0.0", "Test for zero distance: Wrong parse distance! ");

	}

	@Test
	public void parseSpeedTest() {
		// ***** speed parsing *****

		// only km

		double speed = 10.0;
		parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals(parseSpeed, "10.0", "Test for only km: Wrong parse speed! ");

		// km.m

		speed = 10.05;
		parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals(parseSpeed, "10.05", "Test for km.m: Wrong parse speed! ");

		// only m

		speed = 0.05;
		parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals(parseSpeed, "0.05", "Test for only m: Wrong parse speed! ");

		// none speed

		speed = 0.0;
		parseSpeed = parser.parseFromSpeed(speed);
		Assert.assertEquals(parseSpeed, "0.0", "Test for none speed: Wrong parse speed! ");

	}
}
