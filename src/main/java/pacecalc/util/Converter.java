package pacecalc.util;

public class Converter {

	public static String convertKmToMile(int distanceKm) {
		return Double.toString(Math.floor(((double) (distanceKm) / 1000) * 621.4) / 1000.0);
	}

	public static int convertMileToKm(String distanceMile) {
		return (int) Math.ceil(Double.parseDouble(distanceMile) * 1609.0);
	}

	public static String convertSpeedKmhToMpH(double speedKm) {
		return Double.toString(Math.ceil(speedKm * 621.4) / 1000.0);
	}

	public static double convertSpeedMpHtoKmh(String speedMpH) {
		return Math.ceil(Double.parseDouble(speedMpH) * 160.9) / 100.0;
	}
}
