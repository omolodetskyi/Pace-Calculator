package pacecalc;

import java.util.Scanner;

import util.Parser;

public class Controller {

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	public void CalcFlow(PaceCalc pacecalc, CLUI cli) {

		cli.showWelcomeMsg();
		cli.showSelectionMsg();
		int userSelection, timeInt, paceInt, distanceInt;
		String timeStr, distanceStr, paceStr;
		Scanner userInput = new Scanner(System.in);

		Parser parser = new Parser();
		userSelection = userInput.nextInt();
		switch (userSelection) {
		case 1:
			cli.showCalculatePaceMsg();
			cli.showEnterTimeMsg();
			timeStr = userInput.next();
			timeInt = parser.timeStringToInt(timeStr);
			pacecalc.setTime(timeInt);
			cli.showEnterDistanceMsg();
			distanceStr = userInput.next();
			distanceInt = parser.distanceStringToInt(distanceStr);
			pacecalc.setTime(distanceInt);
			paceInt = pacecalc.calcPace();
			paceStr = parser.parseFromPace(paceInt);
			cli.showCalculatedPace(paceStr);
			cli.showContinueMsg();
			break;
		case 2:
			cli.showCalculateTimeMsg();
			cli.showEnterDistanceMsg();
			distanceStr = userInput.next();
			System.out.println("You entered " + distanceStr);
			cli.showEnterPaceMsg();
			paceStr = userInput.next();
			System.out.println("You entered " + paceStr);
			cli.showCalculatedTime("03:23:34");
			cli.showContinueMsg();
			break;
		case 3:
			cli.showCalculateDistanceMsg();
			cli.showEnterPaceMsg();
			paceStr = userInput.next();
			System.out.println("You entered " + paceStr);
			cli.showEnterTimeMsg();
			timeStr = userInput.next();
			System.out.println("You entered " + timeStr);
			cli.showCalculatedDistance("42195");
			cli.showContinueMsg();
			break;
		case 0:
			cli.showExitQuestionMsg();
			cli.showExitMsg();
			break;
		default:
			cli.showErrorMsg();
			cli.showSelectionMsg();
			break;
		}
		userInput.close();
	}
}