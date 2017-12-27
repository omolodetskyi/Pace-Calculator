package pacecalc.controllers;

import pacecalc.services.Calc;
import pacecalc.services.UI;
import pacecalc.util.Parser;

import java.util.Scanner;

public class Controller {

	private Calc calc;
	private UI ui;
	private boolean whileControl;

	public Controller() {
	}

	public Controller(Calc calc, UI ui) {
		this.calc = calc;
		this.ui = ui;
		this.whileControl = true;
	}

	public void calcFlow() {
		try (Scanner userInput = new Scanner(System.in))
		{
			ui.showWelcomeMsg();
			while (whileControl) {
				ui.showSelectionMsg();
				if (userInput.hasNextInt()) {
					switch (userInput.nextInt()) {
						case 1:
							calculatePaceBasedOnTimeAndDistance(userInput);
							continue;
						case 2:
							calculateTimeBasedOnPaceAndDistance(userInput);
							continue;
						case 3:
							calculateDistanceBasedOnTimeAndPace(userInput);
							continue;
						case 4:
							calculateSpeedBasedOnPace(userInput);
							continue;
						case 0:
							onExitResult(userInput);
							continue;
						default:
							ui.showErrorMsg();
					}
				} else {
					ui.showErrorMsg();
					userInput.next();
				}
			}
		}
	}

	private void calculateSpeedBasedOnPace(Scanner userInput) {
		ui.showCalculateSpeedMsg();
		ui.showEnterPaceMsg();

		ui.showCalculatedSpeed(Parser.parseFromSpeed(calc.calcSpeed(getPaceInt(Parser.paceStringToInt(userInput.next()), userInput))));
		ui.showContinueMsg();

		commonResult(userInput);
	}

	private void calculateDistanceBasedOnTimeAndPace(Scanner userInput) {
		ui.showCalculateDistanceMsg();
		ui.showEnterPaceMsg();

		int paceInt = getPaceInt(Parser.paceStringToInt(userInput.next()), userInput);

		ui.showEnterTimeMsg();

		int timeInt = getTimeInt(Parser.timeStringToInt(userInput.next()), userInput);

		String distanceStr = Parser.parseFromDistance(calc.calcDistance(timeInt, paceInt));

		if (distanceStr.equals("0.0")) {
            ui.showCalculatedDistanceWrong();
			return;
        }

		ui.showCalculatedDistance(distanceStr);
		ui.showContinueMsg();

		commonResult(userInput);
	}

	private void calculateTimeBasedOnPaceAndDistance(Scanner userInput) {
		ui.showCalculateTimeMsg();
		ui.showEnterDistanceMsg();

		int distance = getDistanceInt(Parser.distanceStringToInt(userInput.next()), userInput);

		ui.showEnterPaceMsg();

		int paceInt = Parser.paceStringToInt(userInput.next());

		while (paceInt <= 0) {
            ui.showErrorMsg();
            ui.showEnterPaceMsg();
            String paceStr = userInput.next();
            paceInt = Parser.paceStringToInt(paceStr);
        }

		int timeInt = calc.calcTime(paceInt, distance);

		if (timeInt > 215999 || timeInt == 0) {
            ui.showCalculatedTimeWrong();
            return;
        }

		ui.showCalculatedTime(Parser.parseFromTime(timeInt));
		ui.showContinueMsg();

		commonResult(userInput);
	}

	private void calculatePaceBasedOnTimeAndDistance(Scanner userInput) {
		ui.showCalculatePaceMsg();
		ui.showEnterTimeMsg();

		int timeInt = getTimeInt(Parser.timeStringToInt(userInput.next()), userInput);

		ui.showEnterDistanceMsg();

		int distance = getDistanceInt(Parser.distanceStringToInt(userInput.next()), userInput);

		int paceInt = calc.calcPace(timeInt, distance);

		if (paceInt > 3599 || paceInt == 0) {
            ui.showCalculatedPaceWrong();
			return;
        }

		ui.showCalculatedPace(Parser.parseFromPace(paceInt));
		ui.showContinueMsg();

		commonResult(userInput);
	}

	private int getPaceInt(int paceInt, Scanner userInput) {
		String paceStr;
		while (paceInt <= 0) {
            ui.showErrorMsg();
            ui.showEnterTimeMsg();
            paceStr = userInput.next();
            paceInt = Parser.paceStringToInt(paceStr);
        }
		return paceInt;
	}

	private int getDistanceInt(int distanceInt, Scanner userInput) {
		String distanceStr;
		while (distanceInt < 0) {
            ui.showErrorMsg();
            ui.showEnterDistanceMsg();
            distanceStr = userInput.next();
            distanceInt = Parser.distanceStringToInt(distanceStr);
        }
		return distanceInt;
	}

	private int getTimeInt(int timeInt, Scanner userInput) {
		String timeStr;
		while (timeInt <= 0) {
            ui.showErrorMsg();
            ui.showEnterTimeMsg();
            timeStr = userInput.next();
            timeInt = Parser.timeStringToInt(timeStr);
        }
		return timeInt;
	}

	private void commonResult(Scanner userInput) {
		if (userInput.next().equalsIgnoreCase("no")) {
			ui.showExitMsg();
			this.whileControl = false;
		}
	}

	private void onExitResult(Scanner userInput) {
		ui.showExitQuestionMsg();
		if (userInput.next().equalsIgnoreCase("yes")){
			ui.showExitMsg();
			this.whileControl = false;
		}
	}
}