package pacecalc;

public class CLUI {

	// return line separator depending on the system settings
	private String lineseparator = System.getProperty("line.separator");

	public void showSelectionMsg() {

		// this string is shown in order inform user about possible choices to
		// calculate

		String selectionMsg = "Please select what you would like to do:" + lineseparator
				+ "* If you would like to calculate pace based on time and distance enter 1;" + lineseparator
				+ "* If you would like to calculate time based on pace and distance enter 2;" + lineseparator
				+ "* If you would like to calculate distance based on time and pace enter 3;" + lineseparator
				+ "* If you would like to calculate speed based on pace enter 4;" + lineseparator
				+ "* If you would like to exit enter 0;" + lineseparator + lineseparator + "Enter your choice here:";
		System.out.println(selectionMsg);
	}

	public void showContinueMsg() {

		// this string is shown in order to ask user if he would like continue
		// using Pace Calc or not

		String continueMsg = "Continue to work with Pace Calculator? Please type yes or no";
		System.out.println(continueMsg);
	}

	public void showWelcomeMsg() {

		// this string is shown for user at the start of applicaton

		String welcomeMsg = "************* Welcome to Pace Calculator! *************";
		System.out.println(welcomeMsg);
	}

	public void showErrorMsg() {

		// this string is shown while user entered a wrong value in user input

		String errorMsg = "You entered a wrong value!";
		System.out.println(errorMsg);
	}

	public void showCalculatePaceMsg() {

		// this string is shown if user selected to calculate pace

		String calculatePaceMsg = "You selected to calculate pace.";
		System.out.println(calculatePaceMsg);
	}

	public void showCalculateSpeed() {

		// this string is shown if user selected to calculate pace

		String calculateSpeedMsg = "You selected to calculate speed.";
		System.out.println(calculateSpeedMsg);
	}

	public void showCalculateDistanceMsg() {

		// this string is shown if user selected to calculate distance

		String calculateDistanceMsg = "You selected to calculate distance.";
		System.out.println(calculateDistanceMsg);
	}

	public void showCalculateTimeMsg() {

		// this string is shown if user selected to calculate time

		String calculateTimeMsg = "You selected to calculate time.";
		System.out.println(calculateTimeMsg);
	}

	public void showCalculateSpeedMsg() {

		// this string is shown if user selected to calculate speed

		String calculateSpeedMsg = "You selected to calculate speed.";
		System.out.println(calculateSpeedMsg);
	}

	public void showEnterTimeMsg() {

		// this string is shown to ask user enter time

		String enterTimeMsg = "Please enter time you are going to run in following format hh:mm:ss:";
		System.out.println(enterTimeMsg);
	}

	public void showEnterDistanceMsg() {

		// this string is shown to ask user enter distance

		String enterDistanceMsg = "Please enter distance you are going to run in integer meters:";
		System.out.println(enterDistanceMsg);
	}

	public void showEnterPaceMsg() {

		// this string is shown to ask user enter pace

		String calculatePaceEnterTimeMsg = "Please enter pace you are going to run in following format mm:ss";
		System.out.println(calculatePaceEnterTimeMsg);
	}

	public void showExitQuestionMsg() {

		// this message is shown on exit to make sure that use would like to
		// exit

		String exitQuestionMsg = "You selected exit the application. Are you sure? Please type yes or no";
		System.out.println(exitQuestionMsg);
	}

	public void showExitMsg() {

		// this message is shown on exit, just for fun

		String exitMsg = "Thank you for using Pace Calculator. Bye bye!";
		System.out.println(exitMsg);
	}

	public void showCalculatedPace(String pace) {

		// method shows calculated pace

		System.out.println("Calculated! Based on your input pace should be " + pace);
	}

	public void showCalculatedSpeed(String speed) {

		// method shows calculated pace

		System.out.println("Calculated! Based on your input speed should be " + speed);
	}

	public void showCalculatedTime(String time) {

		// method shows calculated time

		System.out.println("Calculated! Based on your input time should be " + time);
	}

	public void showCalculatedPaceWrong() {

		// method shows calculated time

		System.out.println(
				"Pace calculated! But it appears to be too big (bigger than 59:59) or too small (less than 00:00)."
						+ lineseparator + "Please, check your input, re-enter and calculate again");
	}

	public void showCalculatedTimeWrong() {

		// method shows calculated time

		System.out.println(
				"Time calculated! But it appears to be too big (bigger than 59:59:59) or too small (less than 00:00:00)."
						+ lineseparator + "Please, check your input, re-enter and calculate again");
	}

	public void showCalculatedDistance(String distance) {

		// method shows calculated distance

		System.out.println("Calculated! Based on your input distance should be " + distance + " km");
	}

	public void showCalculatedDistanceWrong() {
		System.out.println("Distance calculated! But it appears to be  too small (less than 0.0 km)." + lineseparator
				+ "Please, check your input, re-enter and calculate again");

	}

}
