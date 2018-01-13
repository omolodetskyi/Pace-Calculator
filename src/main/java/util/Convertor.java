package util;

public class Convertor {

	public String convertKmToMile(int distanceKm) {
		String distanceMile;
		double distanceMileDouble;
		distanceMileDouble = Math.floor(((double) (distanceKm) / Constants.ONE_KM_IN_METERS) * 621.4) / 1000.0;
		distanceMile = Double.toString(distanceMileDouble);
		return distanceMile;
	}

	// method converts miles in miles to km in meters

	public int convertMileToKm(String distanceMile) {
		int distanceKm;
		distanceKm = (int) Math.ceil(Double.parseDouble(distanceMile) * Constants.ONE_MILE_IN_KM);
		return distanceKm;
	}

	// method converts speed in km/h to m/h

	public String convertSpeedKmhToMpH(double speedKm) {
		String speedMpH;
		speedMpH = Double.toString(Math.ceil(speedKm * Constants.ONE_KM_IN_MILE * 1000) / 1000.0); // *1000
																									// and
																									// /1000.0
																									// is
																									// used
																									// to
																									// make
																									// precise
																									// for
																									// Math.ceil
																									// function

		return speedMpH;
	}

	// method converts speed in m/h to km/h

	public double convertSpeedMpHtoKmh(String speedMpH) {
		double speedKm;
		speedKm = Math.ceil(Double.parseDouble(speedMpH) * Constants.ONE_MILE_IN_KM / 10) / 100.0; // *10
																									// /
																									// 100.0
																									// is
																									// used
																									// to
																									// make
																									// precise
																									// for
																									// Math.ceil
																									// function
		return speedKm;
	}
}
