package pacecalc.util;

import java.text.DecimalFormat;

public class Parser {

	public static String parseFromTime(int time) {

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

	public static String parseFromDistance(int distance) {

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

	public static String parseFromPace(int pace) {
		String returnPaceHrs;
		String returnPaceMin;
		String returnPaceSec;
		String returnPace;
		returnPaceHrs = LeadingZero(pace / 3600);
		returnPaceMin = LeadingZero((pace % 3600) / 60);
		returnPaceSec = LeadingZero((pace % 3600) % 60);
		if (returnPaceHrs.compareTo("00") != 0) {
			returnPace = returnPaceHrs + ":" + returnPaceMin + ":" + returnPaceSec;
		} else {

			returnPace = returnPaceMin + ":" + returnPaceSec;
		}

		return returnPace;
	}

	public static String parseFromSpeed(double speed) {
		String pattern = "##0.00";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return decimalFormat.format(speed);
	}

	public static String LeadingZero(int intNumber) {
		String strLeadingZero;
		if (intNumber < 10) {
			strLeadingZero = "0" + Integer.toString(intNumber);
		} else {
			strLeadingZero = Integer.toString(intNumber);
		}
		return strLeadingZero;
	}

	public static int timeStringToInt(String timeString) {
		String delims = ":";
		int timeInt;
		String[] time = timeString.split(delims);
		if (time.length != 3) {
			timeInt = -1;
		} else {
			try {

				int hours = Integer.parseInt(time[0]);
				int min = Integer.parseInt(time[1]);
				int sec = Integer.parseInt(time[2]);
				if (hours > 60 || min > 60 || sec > 60 || min < 0 || sec < 0 || hours < 0) {
					timeInt = -1;
				} else {
					timeInt = hours * 3600 + min * 60 + sec;
					if (timeInt == 0) {
						timeInt = -1;
					}
				}
			} catch (NumberFormatException e) {
				timeInt = -1;
			}
		}
		return timeInt;
	}

	public static int paceStringToInt(String timeString) {
		String delims = ":";
		int timeInt;
		String[] time = timeString.split(delims);
		if (time.length != 2) {
			timeInt = -1;
		} else {
			try {
				int min = Integer.parseInt(time[0]);
				int sec = Integer.parseInt(time[1]);
				if (min > 60 || sec > 60 || min < 0 || sec < 0) {
					timeInt = -1;
				} else {
					timeInt = min * 60 + sec;
					if (timeInt == 0) {
						timeInt = -1;
					}
				}
			} catch (NumberFormatException e) {
				timeInt = -1;
			}
		}

		return timeInt;
	}

	public static int distanceStringToInt(String distanceEnteredP) {
		int distanceInt;
		try {
			distanceInt = Integer.parseInt(distanceEnteredP);
			if (distanceInt < 0 || distanceInt == 0) {
				distanceInt = -1;
			}
		} catch (NumberFormatException e) {
			distanceInt = -1;
		}
		return distanceInt;
	}
}
