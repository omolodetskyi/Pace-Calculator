package pacecalc;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.Convertor;

public class ConvertorTest {

	Convertor convertor = new Convertor();
	int distanceKm;
	String distanceMile;
	double speedKmH;
	String speedMpH;

	@Test

	// test method which convert km to mile

	public void convertKMtoMileTest() {

		// usual distance

		distanceKm = 10000;
		distanceMile = convertor.convertKmToMile(distanceKm);
		Assert.assertEquals(distanceMile, "6.214", "Test converting usual distance km to mile");

		// small distance
		distanceKm = 10;
		distanceMile = convertor.convertKmToMile(distanceKm);
		Assert.assertEquals(distanceMile, "0.006", "Test converting usual distance km to mile");

		// big distance
		distanceKm = 10000000;
		distanceMile = convertor.convertKmToMile(distanceKm);
		Assert.assertEquals(distanceMile, "6214.0", "Test converting usual distance km to mile");

	}

	@Test

	// test method which convert mile to km

	public void convertMileToKmTest() {

		// usual distance

		distanceMile = "6.214";
		distanceKm = convertor.convertMileToKm(distanceMile);
		Assert.assertEquals(distanceKm, 9999, "Test converting usual distance mile to km");

		// small distance

		distanceMile = "0.006";
		distanceKm = convertor.convertMileToKm(distanceMile);
		Assert.assertEquals(distanceKm, 10, "Test converting usual distance mile to km");

		// big distance
		// TODO should think about precise, in this particular case I've lost
		// 1674 m - almost 1 mile

		distanceMile = "6214.0";
		distanceKm = convertor.convertMileToKm(distanceMile);
		Assert.assertEquals(distanceKm, 9998326, "Test converting usual distance mile to km");

	}

	@Test

	// test method which convert km/h to mile/h

	public void convertSpeedKmToMileTest() {

		// usual speed

		speedKmH = 10.0;
		speedMpH = convertor.convertSpeedKmhToMpH(speedKmH);
		Assert.assertEquals(speedMpH, "6.214", "Test converting usual speed kmh to mph");

		// small speed

		speedKmH = 0.01;
		speedMpH = convertor.convertSpeedKmhToMpH(speedKmH);
		Assert.assertEquals(speedMpH, "0.007", "Test converting small speed kmh to mph");

		// big speed
		// TODO should think about precise, in this particular case I've lost
		// 1674 m - almost 1 mile

		speedKmH = 10000.0;
		speedMpH = convertor.convertSpeedKmhToMpH(speedKmH);
		Assert.assertEquals(speedMpH, "6214.0", "Test converting big speed mile to km");
	}

	@Test

	// test method which convert m/h to km/h

	public void convertSpeedMphToKmH() {

		// usual speed
		speedMpH = "6.214";

		speedKmH = convertor.convertSpeedMpHtoKmh(speedMpH);
		Assert.assertEquals(speedKmH, 10.0, "Test converting usual speed mph to kmh");

		// small speed

		speedMpH = "0.007";
		speedKmH = convertor.convertSpeedMpHtoKmh(speedMpH);
		Assert.assertEquals(speedKmH, 0.02, "Test converting small speed mph to kmh");

		// big speed

		speedMpH = "6214.0";
		speedKmH = convertor.convertSpeedMpHtoKmh(speedMpH);
		Assert.assertEquals(speedKmH, 9998.33, "Test converting big speed mph to kmh");
	}
}
