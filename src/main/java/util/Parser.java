package util;

public class Parser {

	// parseFrom methods convert fields' values in usual format in Strings

	// convert time in int (like 3600) to time in String in format hh:mm:ss
	// (like 01:00:00)

	public String parseFromTime(int time) {

		String timeHours;
		String timeMin;
		String timeSec;

		String returnTime;
		timeHours = LeadingZero(time / 3600);
		timeMin = LeadingZero((time % 3600) / 60);
		timeSec = LeadingZero((time % 3600) % 60);
		returnTime = timeHours + ":" + timeMin + ":" + timeSec;

		return returnTime;
	}

	// convert Distance in int(like 10000) to distance in String in km (like
	// 10.000)

	public String parseFromDistance(int distance) {

		int returnDistanceKm;
		int returnDistanceM;
		String leadingZero;
		String returnDistance;
		returnDistanceKm = distance / 1000;
		returnDistanceM = distance % 1000;
		if (returnDistanceM > 99) {
			leadingZero = "";
		} else if (returnDistanceM > 9) {
			leadingZero = "0";
		} else if (returnDistanceM == 0) {
			leadingZero = "";
		} else {
			leadingZero = "00";
		}
		returnDistance = Integer.toString(returnDistanceKm) + "." + leadingZero + Integer.toString(returnDistanceM);
		return returnDistance;
	}

	// convert pace in int (like 360) to pace in String in format mm:ss (like
	// 05:10)

	public String parseFromPace(int pace) {
		String returnPaceMin;
		String returnPaceSec;
		String returnPace;
		returnPaceMin = LeadingZero(pace / 60);
		returnPaceSec = LeadingZero(pace % 360);
		returnPace = returnPaceMin + ":" + returnPaceSec;
		return returnPace;
	}

	// convert speed in double (like 5.34) to speed in String in format mm:ss
	// (like 05:10)

	public String parseFromSpeed(double speed) {
		String returnSpeed = Double.toString(speed);
		return returnSpeed;
	}

	// method to set leading zero to cover situation while you need e.g. 03:01

	public String LeadingZero(int intNumber) {
		String strLeadingZero;
		if (intNumber < 10) {
			strLeadingZero = "0" + Integer.toString(intNumber);
		} else {
			strLeadingZero = Integer.toString(intNumber);
		}
		return strLeadingZero;
	}
}
