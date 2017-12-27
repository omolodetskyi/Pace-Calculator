package pacecalc.ulils;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pacecalc.util.Converter;

public class ConverterTest {

	@Test(dataProvider = "setParametersForConvertKmToMileTest")
	public void convertKMtoMileTest(int distanceKm, String distanceMileExpected, String message) {
		Assert.assertEquals(Converter.convertKmToMile(distanceKm), distanceMileExpected, message);
	}

	@DataProvider(name = "setParametersForConvertKmToMileTest")
	private Object[][] setParametersForConvertKmToMileTest() {
		Object[][] params = new Object[3][3];

		// usual distance

		params[0][0] = 10000;
		params[0][1] = "6.214";
		params[0][2] = "Test converting usual distance km to mile";

		// small distance

		params[1][0] = 10;
		params[1][1] = "0.006";
		params[1][2] = "Test converting small distance km to mile";

		// big distance

		params[2][0] = 10000000;
		params[2][1] = "6214.0";
		params[2][2] = "Test converting big distance km to mile";

		return params;
	}

	@Test(dataProvider = "setParametersForConvertMileToKmTest")
	public void convertMileToKmTest(int distanceKmExpected, String distanceMile, String message) {
		Assert.assertEquals(Converter.convertMileToKm(distanceMile), distanceKmExpected, message);
	}

	@DataProvider(name = "setParametersForConvertMileToKmTest")
	private Object[][] setParametersForConvertMileToKmTest() {
		Object[][] params = new Object[3][3];

		// usual distance

		params[0][0] = 9999;
		params[0][1] = "6.214";
		params[0][2] = "Test converting usual distance mile to km";

		// small distance

		params[1][0] = 10;
		params[1][1] = "0.006";
		params[1][2] = "Test converting usual distance mile to km";

		// big distance

		params[2][0] = 9998326;
		params[2][1] = "6214.0";
		params[2][2] = "Test converting usual distance mile to km";

		return params;
	}

	@Test(dataProvider = "setParametersForConvertSpeedKmToMileTest")
	public void convertSpeedKmToMileTest(double speedKmH, String speedMpHExpected, String message) {
		Assert.assertEquals(Converter.convertSpeedKmhToMpH(speedKmH), speedMpHExpected, message);
	}

	@DataProvider(name = "setParametersForConvertSpeedKmToMileTest")
	private Object[][] setParametersForConvertSpeedKmToMileTest() {
		Object[][] params = new Object[3][3];

		// usual speed

		params[0][0] = 10.0;
		params[0][1] = "6.214";
		params[0][2] = "Test converting usual speed kmh to mph";

		// small speed

		params[1][0] = 0.01;
		params[1][1] = "0.007";
		params[1][2] = "Test converting small speed kmh to mph";

		// big speed
		// TODO should think about precise, in this particular case I've lost
		// 1674 m - almost 1 mile

		params[2][0] = 10000.0;
		params[2][1] = "6214.0";
		params[2][2] = "Test converting big speed mile to km";

		return params;
	}

	@Test
	public void convertSpeedMphToKmH() {
		Assert.assertEquals(Converter.convertSpeedMpHtoKmh("6.214"), 10.0, "Test converting usual speed mph to kmh");
		Assert.assertEquals(Converter.convertSpeedMpHtoKmh("0.007"), 0.02, "Test converting small speed mph to kmh");
		Assert.assertEquals(Converter.convertSpeedMpHtoKmh("6214.0"), 9998.33, "Test converting big speed mph to kmh");
	}
}
