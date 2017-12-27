package pacecalc.ulils;

import org.testng.Assert;
import org.testng.annotations.Test;

import pacecalc.util.Parser;

public class ParserTest {

	@Test
	public void timeParserTest() {
		Assert.assertEquals(Parser.parseFromTime(3600), "01:00:00", "Test for only hours: Wrong parse time! ");
		Assert.assertEquals(Parser.parseFromTime(3663), "01:01:03", "Test for hours:minutes:seconds: Wrong parse time! ");
		Assert.assertEquals(Parser.parseFromTime(60), "00:01:00", "Test for only minutes: Wrong parse time! ");
		Assert.assertEquals(Parser.parseFromTime(4), "00:00:04", "Test for only seconds: Wrong parse time! ");
		Assert.assertEquals(Parser.parseFromTime(0), "00:00:00", "Test for none time: Wrong parse time! ");
	}

	@Test
	public void parserPaceTest() {
		Assert.assertEquals(Parser.parseFromPace(360), "06:00", "Test for only minutes: Wrong parse pace! ");
		Assert.assertEquals(Parser.parseFromPace(382), "06:22", "Test for minutes and seconds: Wrong parse pace! ");
		Assert.assertEquals(Parser.parseFromPace(9), "00:09", "Test for only seconds: Wrong parse pace! ");
		Assert.assertEquals(Parser.parseFromPace(0), "00:00", "Test for only seconds: Wrong parse pace! ");
	}

	@Test
	public void parseDistanceTest() {
		Assert.assertEquals(Parser.parseFromDistance(2000), "2.0", "Test for only kilometers: Wrong parse distance! ");
		Assert.assertEquals(Parser.parseFromDistance(13430), "13.430", "Test for kilometers with meters: Wrong parse distance! ");
		Assert.assertEquals(Parser.parseFromDistance(31), "0.031", "Test for only meters: Wrong parse distance! ");
		Assert.assertEquals(Parser.parseFromDistance(1), "0.001", "Test for 1 meter: Wrong parse distance! ");
		Assert.assertEquals(Parser.parseFromDistance(0), "0.0", "Test for zero distance: Wrong parse distance! ");
	}

	@Test
	public void parseSpeedTest() {
		Assert.assertEquals(Parser.parseFromSpeed(10.0), "10,00", "Test for only km: Wrong parse speed! ");
		Assert.assertEquals(Parser.parseFromSpeed(10.05), "10,05", "Test for km.m: Wrong parse speed! ");
		Assert.assertEquals(Parser.parseFromSpeed(0.05), "0,05", "Test for only m: Wrong parse speed! ");
		Assert.assertEquals(Parser.parseFromSpeed(0.0), "0,00", "Test for none speed: Wrong parse speed! ");
	}
}
