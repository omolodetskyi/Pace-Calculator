package pacecalc.services.impl;

import pacecalc.services.UI;

public class ClientUI implements UI {

	private final static String lineSeparator = System.getProperty("line.separator");

	public void showSelectionMsg() {
		System.out.println(
				"Please select what you would like to do:" + lineSeparator
				+ "* If you would like to calculate pace based on time and distance enter 1;" + lineSeparator
				+ "* If you would like to calculate time based on pace and distance enter 2;" + lineSeparator
				+ "* If you would like to calculate distance based on time and pace enter 3;" + lineSeparator
				+ "* If you would like to calculate speed based on pace enter 4;" + lineSeparator
				+ "* If you would like to exit enter 0;" + lineSeparator + lineSeparator + "Enter your choice here:"
		);
	}

	public void showContinueMsg() {
		System.out.println("Continue to work with Pace Calculator? Please type yes or no");
	}

	public void showWelcomeMsg() {
		System.out.println("************* Welcome to Pace Calculator! *************");
	}

	public void showErrorMsg() {
		System.out.println("You entered a wrong value!");
	}

	public void showCalculatePaceMsg() {
		System.out.println("You selected to calculate pace.");
	}

	public void showCalculateSpeed() {
		System.out.println("You selected to calculate speed.");
	}

	public void showCalculateDistanceMsg() {
		System.out.println("You selected to calculate distance.");
	}

	public void showCalculateTimeMsg() {
		System.out.println( "You selected to calculate time.");
	}

	public void showCalculateSpeedMsg() {
		System.out.println("You selected to calculate speed.");
	}

	public void showEnterTimeMsg() {
		System.out.println("Please enter time you are going to run in following format hh:mm:ss:");
	}

	public void showEnterDistanceMsg() {
		System.out.println("Please enter distance you are going to run in integer meters:");
	}

	public void showEnterPaceMsg() {
		System.out.println("Please enter pace you are going to run in following format mm:ss");
	}

	public void showExitQuestionMsg() {
		System.out.println("You selected exit the application. Are you sure? Please type yes or no");
	}

	public void showExitMsg() {
		System.out.println("Thank you for using Pace Calculator. Bye bye!");
	}

	public void showCalculatedPace(String pace) {
		System.out.println("Calculated! Based on your input pace should be " + pace);
	}

	public void showCalculatedSpeed(String speed) {
		System.out.println("Calculated! Based on your input speed should be " + speed);
	}

	public void showCalculatedTime(String time) {
		System.out.println("Calculated! Based on your input time should be " + time);
	}

	public void showCalculatedPaceWrong() {
		System.out.println(
				"Pace calculated! But it appears to be too big (bigger than 59:59) or too small (less than 00:00)."
						+ lineSeparator + "Please, check your input, re-enter and calculate again");
	}

	public void showCalculatedTimeWrong() {
		System.out.println(
				"Time calculated! But it appears to be too big (bigger than 59:59:59) or too small (less than 00:00:00)."
						+ lineSeparator + "Please, check your input, re-enter and calculate again");
	}

	public void showCalculatedDistance(String distance) {
		System.out.println("Calculated! Based on your input distance should be " + distance + " km");
	}

	public void showCalculatedDistanceWrong() {
		System.out.println("Distance calculated! But it appears to be  too small (less than 0.0 km)." + lineSeparator
				+ "Please, check your input, re-enter and calculate again");
	}
}
