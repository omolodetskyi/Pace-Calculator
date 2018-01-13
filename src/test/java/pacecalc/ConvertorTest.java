package pacecalc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Convertor;

public class ConvertorTest {

	Convertor convertor = new Convertor();
	int distanceKm;
	String distanceMile;
	double speedKmH;
	String speedMpH;

	@Test(dataProvider = "setPrametersForConvertKmtoMileTest")

	// test method which convert km to mile

	public void convertKMtoMileTest(int distanceKm, String distanceMileExpected, String message) {

		distanceMile = convertor.convertKmToMile(distanceKm);
		Assert.assertEquals(distanceMile, distanceMileExpected, message);

	}

	@DataProvider(name = "setPrametersForConvertKmtoMileTest")
	private Object[][] setPrametersForConvertKmtoMileTest() {
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

	@Test(dataProvider = "setPrametersForConvertMileToKmTest")

	// test method which convert mile to km

	public void convertMileToKmTest(int distanceKmExpected, String distanceMile, String message) {

		distanceKm = convertor.convertMileToKm(distanceMile);
		Assert.assertEquals(distanceKm, distanceKmExpected, message);

	}

	@DataProvider(name = "setPrametersForConvertMileToKmTest")
	private Object[][] setPrametersForConvertMileToKmTest() {
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

	@Test(dataProvider = "setPrametersForConvertSpeedKmToMileTest")

	// test method which convert km/h to mile/h

	public void convertSpeedKmToMileTest(double speedKmH, String speedMpHExpected, String message) {
		speedMpH = convertor.convertSpeedKmhToMpH(speedKmH);
		Assert.assertEquals(speedMpH, speedMpHExpected, message);
	}

	@DataProvider(name = "setPrametersForConvertSpeedKmToMileTest")
	private Object[][] setPrametersForConvertSpeedKmToMileTest() {
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

	@Test(dataProvider = "setPrametersForConvertSpeedMphToKmH")

	// test method which convert m/h to km/h

	public void convertSpeedMphToKmH(String speedMpH, double speedKmHexpected, String message) {

		speedKmH = convertor.convertSpeedMpHtoKmh(speedMpH);
		Assert.assertEquals(speedKmH, speedKmHexpected, message);

	}

	@DataProvider(name = "setPrametersForConvertSpeedMphToKmH")
	private Object[][] setPrametersForConvertSpeedMphToKmH() {
		Object[][] params = new Object[3][3];

		// usual speed

		params[0][0] = "6.214";
		params[0][1] = 10.0;
		params[0][2] = "Test converting small speed mph to kmh";

		// small speed

		params[1][0] = "0.007";
		params[1][1] = 0.02;
		params[1][2] = "Test converting small speed mph to kmh";

		// big speed
		// TODO should think about precise, in this particular case I've lost
		// 1674 m - almost 1 mile

		params[2][0] = "6214.0";
		params[2][1] = 9998.33;
		params[2][2] = "Test converting big speed mph to kmh";

		return params;
	}
}
