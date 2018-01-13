package util;

import java.text.DecimalFormat;

public class Parser {

	// parseFrom methods convert fields' values in usual format in Strings

	// convert time in int (like 3600) to time in String in format hh:mm:ss
	// (like 01:00:00)

	public String parseFromTime(int time) {

		String timeHours;
		String timeMin;
		String timeSec;

		String returnTime;
		timeHours = LeadingZero(time / Constants.ONE_HOUR_IN_SEC);
		timeMin = LeadingZero((time % Constants.ONE_HOUR_IN_SEC) / Constants.ONE_HOUR_IN_MIN);
		timeSec = LeadingZero((time % Constants.ONE_HOUR_IN_SEC) % Constants.ONE_MIN_IN_SEC);
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
		returnDistanceKm = distance / Constants.ONE_KM_IN_METERS;
		returnDistanceM = distance % Constants.ONE_KM_IN_METERS;
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
		String returnPaceHrs;
		String returnPaceMin;
		String returnPaceSec;
		String returnPace;
		returnPaceHrs = LeadingZero(pace / Constants.ONE_HOUR_IN_SEC);
		returnPaceMin = LeadingZero((pace % Constants.ONE_HOUR_IN_SEC) / Constants.ONE_HOUR_IN_MIN);
		returnPaceSec = LeadingZero((pace % Constants.ONE_HOUR_IN_SEC) % Constants.ONE_MIN_IN_SEC);
		if (returnPaceHrs.compareTo("00") != 0) {
			returnPace = returnPaceHrs + ":" + returnPaceMin + ":" + returnPaceSec;
		} else {

			returnPace = returnPaceMin + ":" + returnPaceSec;
		}

		return returnPace;
	}

	// convert speed in double (like 5.34) to speed in String in format mm:ss
	// (like 05:10)

	public String parseFromSpeed(double speed) {
		String pattern = "##0.00";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		String returnSpeed = decimalFormat.format(speed);
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

	// method takes time in string and parse it to int
	// in case if String returns not valid int or not valid for time value
	// method returns -1

	public int timeStringToInt(String timeString) {
		String delims = ":";
		int timeInt;
		String[] time = timeString.split(delims);
		if (time.length != 3) {
			timeInt = Constants.ERROR_CODE;
		} else {
			try {

				int hours = Integer.parseInt(time[0]);
				int min = Integer.parseInt(time[1]);
				int sec = Integer.parseInt(time[2]);
				if (hours > Constants.ONE_HOUR_IN_MIN || min > Constants.ONE_MIN_IN_SEC
						|| sec > Constants.ONE_MIN_IN_SEC || min < 0 || sec < 0 || hours < 0) {
					timeInt = Constants.ERROR_CODE;
				} else {
					timeInt = hours * Constants.ONE_HOUR_IN_SEC + min * Constants.ONE_MIN_IN_SEC + sec;
					if (timeInt == 0) {
						timeInt = Constants.ERROR_CODE;
					}
				}
			} catch (NumberFormatException e) {
				timeInt = Constants.ERROR_CODE;
			}
		}
		return timeInt;
	}

	// method takes pace in String and parse it to int
	// in case if String returns not valid int or not valid for pace value
	// method returns Constants.ERROR_CODE

	public int paceStringToInt(String timeString) {
		String delims = ":";
		int timeInt;
		String[] time = timeString.split(delims);
		if (time.length != 2) {
			timeInt = Constants.ERROR_CODE;
		} else {
			try {
				int min = Integer.parseInt(time[0]);
				int sec = Integer.parseInt(time[1]);
				if (min > 60 || sec > 60 || min < 0 || sec < 0) {
					timeInt = -1;
				} else {
					timeInt = min * Constants.ONE_MIN_IN_SEC + sec;
					if (timeInt == 0) {
						timeInt = Constants.ERROR_CODE;
					}
				}
			} catch (NumberFormatException e) {
				timeInt = Constants.ERROR_CODE;
			}
		}

		return timeInt;
	}

	// method takes pace in String and parse it to int
	// in case if String returns not valid int or not valid for distance value
	// method returns Constants.ERROR_CODE

	public int distanceStringToInt(String distanceEnteredP) {
		int distanceInt;
		try {
			distanceInt = Integer.parseInt(distanceEnteredP);
			if (distanceInt < 0 || distanceInt == 0) {
				distanceInt = Constants.ERROR_CODE;
			}
		} catch (NumberFormatException e) {
			distanceInt = Constants.ERROR_CODE;
		}
		return distanceInt;
	}

}
