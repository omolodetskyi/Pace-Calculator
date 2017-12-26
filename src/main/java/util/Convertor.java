package util;

public class Convertor {

	public String convertKmToMile(int distanceKm) {
		String distanceMile;
		double distanceMileDouble;
		distanceMileDouble = Math.floor(((double) (distanceKm) / Constants.ONEKM_INMETERS) * 621.4) / 1000.0;
		distanceMile = Double.toString(distanceMileDouble);
		return distanceMile;
	}

	// method converts miles in miles to km in meters

	public int convertMileToKm(String distanceMile) {
		int distanceKm;
		distanceKm = (int) Math.ceil(Double.parseDouble(distanceMile) * Constants.ONEMILE_INKM);
		return distanceKm;
	}

	// method converts speed in km/h to m/h

	public String convertSpeedKmhToMpH(double speedKm) {
		String speedMpH;
		speedMpH = Double.toString(Math.ceil(speedKm * 621.4) / 1000.0);

		return speedMpH;
	}

	// method converts speed in m/h to km/h

	public double convertSpeedMpHtoKmh(String speedMpH) {

		double speedKm;
		speedKm = Math.ceil(Double.parseDouble(speedMpH) * 160.9) / 100.0;
		return speedKm;
	}
}
