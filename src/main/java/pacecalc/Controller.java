package pacecalc;

import java.util.InputMismatchException;
import java.util.Scanner;

import util.Parser;

public class Controller {

	public Controller() {
	}

	public void CalcFlow(PaceCalc pacecalc, CLUI cli) {

		int userSelection, timeInt, paceInt, distanceInt;
		String timeStr, distanceStr, paceStr, speedStr, answer;
		double speedDouble;
		Scanner userInput = new Scanner(System.in);

		Parser parser = new Parser();

		// show Welcome and selection message

		cli.showWelcomeMsg();
		cli.showSelectionMsg();

		// take user input (could be 1 - pace calc, 2 - time calc, 3 - distance,
		// 4- speed
		// calc, 0 - exit
		try { // exception handling for non-integer values or too big values
			userSelection = userInput.nextInt();
			switch (userSelection) {
			case 1: // if user selected pace calc
				cli.showCalculatePaceMsg(); // show message for pace calc
				cli.showEnterTimeMsg(); // request to enter time
				timeStr = userInput.next(); // take time from user input
				timeInt = parser.timeStringToInt(timeStr); // parse time to int
				// in case of wrong user input parser returns -1
				while (timeInt <= 0) { // in cycle until parser returns negative
										// value or 0
					cli.showErrorMsg(); // show error message
					cli.showEnterTimeMsg(); // request to enter time
					timeStr = userInput.next(); // take time from user input
					timeInt = parser.timeStringToInt(timeStr); // parse time to
																// int
				}
				// if user input was valid continue
				pacecalc.setTime(timeInt); // set time in pacecalc object
				cli.showEnterDistanceMsg(); // request to enter distance
				distanceStr = userInput.next(); // take distance from user input
				distanceInt = parser.distanceStringToInt(distanceStr); // parse
																		// distance
																		// to
																		// int
				// in case of wrong user input parser returns -1
				while (distanceInt < 0) { // in cycle until parser returns
											// negative
											// value or 0
					cli.showErrorMsg(); // show error message
					cli.showEnterDistanceMsg(); // request to enter distance
					distanceStr = userInput.next(); // take distance from user
													// input
					distanceInt = parser.distanceStringToInt(distanceStr); // parse
																			// distance
																			// to
																			// int
				}
				// if user input valid continue
				pacecalc.setDistance(distanceInt); // set distance to pacecalc
													// object
				paceInt = pacecalc.calcPace(); // calculate pace
				if (paceInt > 3599 || paceInt == 0) {
					cli.showCalculatedPaceWrong();
					CalcFlow(pacecalc, cli);
				}
				paceStr = parser.parseFromPace(paceInt); // parse pace from int
															// to
															// string

				cli.showCalculatedPace(paceStr); // show result of pace calc
				cli.showContinueMsg(); // show continue message with yes no no
				answer = userInput.next(); // take answer from user input
				while (!answer.equals("yes") && !answer.equals("no")) { // in
																		// cycle
																		// until
																		// answer
																		// is
																		// yes
																		// or no
					cli.showErrorMsg(); // show error message
					cli.showContinueMsg(); // show continue message again
					answer = userInput.next(); // take user input
				}

				// if answer is yes or no we go here to if-else

				if (answer.equals("yes")) { // if answer is yes
					CalcFlow(pacecalc, cli); // start application again
				} else if (answer.equals("no")) { // if answer is no
					cli.showExitMsg(); // show exit message
					System.exit(0); // close application
				}
				break;

			case 2: // if user selected time calculation
				cli.showCalculateTimeMsg(); // show message for time calc
				cli.showEnterDistanceMsg(); // request to enter distance
				distanceStr = userInput.next(); // take distance from user input
				distanceInt = parser.distanceStringToInt(distanceStr); // parse
																		// distance
																		// to
																		// int
				// in case of wrong user input parser returns -1
				while (distanceInt < 0) { // in cycle until parser returns
											// negative
											// value or 0
					cli.showErrorMsg(); // show error message
					cli.showEnterDistanceMsg(); // request to enter distance
					distanceStr = userInput.next(); // take distance from user
													// input
					distanceInt = parser.distanceStringToInt(distanceStr); // parse
																			// distance
																			// to
																			// int
				}
				pacecalc.setDistance(distanceInt); // set distance in pacecalc
													// object
				cli.showEnterPaceMsg(); // request to enter pace
				paceStr = userInput.next(); // take pace from user input
				paceInt = parser.paceStringToInt(paceStr); // parse pace to int
				// in case of wrong user input parser returns -1
				while (paceInt <= 0) { // in cycle until parser returns negative
										// value or 0
					cli.showErrorMsg(); // show error message
					cli.showEnterPaceMsg(); // request to enter pace
					paceStr = userInput.next(); // take pace from user input
					paceInt = parser.paceStringToInt(paceStr); // parse pace to
																// int
				}
				pacecalc.setPace(paceInt); // set pace in pacecalc object
				timeInt = pacecalc.calcTime(); // calculate time
				if (timeInt > 215999 || timeInt == 0) {
					cli.showCalculatedTimeWrong();
					CalcFlow(pacecalc, cli);
				}
				timeStr = parser.parseFromTime(timeInt); // parse time to string
				cli.showCalculatedTime(timeStr); // show result of time
													// calculation
				cli.showContinueMsg(); // show continue message with yes no no
				answer = userInput.next(); // take answer from user input
				while (!answer.equals("yes") && !answer.equals("no")) { // in
																		// cycle
																		// until
																		// answer
																		// is
																		// yes
																		// or no
					cli.showErrorMsg(); // show error message
					cli.showContinueMsg(); // show continue message again
					answer = userInput.next(); // take user input
				}

				// if answer is yes or no we go here to if-else

				if (answer.equals("yes")) { // if answer is yes
					CalcFlow(pacecalc, cli); // start application again
				} else if (answer.equals("no")) { // if answer is no
					cli.showExitMsg(); // show exit message
					System.exit(0); // close application
				}
				break;
			case 3: // if user selected distance calculation
				cli.showCalculateDistanceMsg(); // show message for distance
												// calculation
				cli.showEnterPaceMsg(); // request to enter pace
				paceStr = userInput.next(); // take pace from user input
				paceInt = parser.paceStringToInt(paceStr); // parse pace to int

				// in case of wrong user input parser returns -1
				while (paceInt <= 0) { // in cycle until parser returns negative
										// value or 0
					cli.showErrorMsg(); // show error message
					cli.showEnterTimeMsg(); // request to enter pace
					paceStr = userInput.next(); // take pace from user input
					paceInt = parser.paceStringToInt(paceStr); // parse pace to
																// int
				}
				pacecalc.setPace(paceInt); // set pace to pacecalc object
				cli.showEnterTimeMsg(); // request to enter time
				timeStr = userInput.next(); // take time from user input
				timeInt = parser.timeStringToInt(timeStr); // parse time to int
				while (timeInt <= 0) { // in cycle until parser returns negative
					// value or 0
					cli.showErrorMsg(); // show error message
					cli.showEnterTimeMsg(); // request to enter time
					timeStr = userInput.next(); // take time from user input
					timeInt = parser.timeStringToInt(timeStr); // parse time to
																// int
				}
				// if user input was valid continue
				pacecalc.setTime(timeInt); // set time to pacecalc object
				distanceInt = pacecalc.calcDistance(); // calculate distance
				distanceStr = parser.parseFromDistance(distanceInt); // parse
																		// distance
																		// to
																		// string
				cli.showCalculatedDistance(distanceStr); // show result of
															// distance
															// calculation
				cli.showContinueMsg(); // show continue message with yes no no
				answer = userInput.next(); // take answer from user input
				while (!answer.equals("yes") && !answer.equals("no")) { // in
																		// cycle
																		// until
																		// answer
																		// is
																		// yes
																		// or no
					cli.showErrorMsg(); // show error message
					cli.showContinueMsg(); // show continue message again
					answer = userInput.next(); // take user input
				}

				// if answer is yes or no we go here to if-else

				if (answer.equals("yes")) { // if answer is yes
					CalcFlow(pacecalc, cli); // start application again
				} else if (answer.equals("no")) { // if answer is no
					cli.showExitMsg(); // show exit message
					System.exit(0); // close application
				}

				break;
			case 4:
				// if user selected speed calculation
				cli.showCalculateSpeedMsg(); // show message for speed
												// calculation
				cli.showEnterPaceMsg(); // request to enter pace
				paceStr = userInput.next(); // take pace from user input
				paceInt = parser.paceStringToInt(paceStr); // parse pace to int

				// in case of wrong user input parser returns -1
				while (paceInt <= 0) { // in cycle until parser returns negative
										// value or 0
					cli.showErrorMsg(); // show error message
					cli.showEnterTimeMsg(); // request to enter pace
					paceStr = userInput.next(); // take pace from user input
					paceInt = parser.paceStringToInt(paceStr); // parse pace to
																// int
				}
				// if user input was valid continue
				pacecalc.setPace(paceInt); // set pace to pacecalc object
				speedDouble = pacecalc.calcSpeed(); // calculate speed
				speedStr = parser.parseFromSpeed(speedDouble); // parse speed
																// from double
																// to string
				cli.showCalculatedSpeed(speedStr); // show result of calculation
				cli.showContinueMsg(); // show continue message with yes no no
				answer = userInput.next(); // take answer from user input
				while (!answer.equals("yes") && !answer.equals("no")) { // in
																		// cycle
																		// until
																		// answer
																		// is
																		// yes
																		// or no
					cli.showErrorMsg(); // show error message
					cli.showContinueMsg(); // show continue message again
					answer = userInput.next(); // take user input
				}

				// if answer is yes or no we go here to if-else

				if (answer.equals("yes")) { // if answer is yes
					CalcFlow(pacecalc, cli); // start application again
				} else if (answer.equals("no")) { // if answer is no
					cli.showExitMsg(); // show exit message
					System.exit(0); // close application
				}

				break;
			case 0:
				cli.showExitQuestionMsg(); // show exit message with yes/no
											// question
				answer = userInput.next(); // take answer from user input
				while (!answer.equals("yes") && !answer.equals("no")) { // in
																		// cycle
																		// until
																		// answer
																		// is
																		// yes
																		// or no
					cli.showErrorMsg(); // show error message
					cli.showContinueMsg(); // show continue message again
					answer = userInput.next(); // take user input
				}

				// if answer is yes or no we go here to if-else

				if (answer.equals("yes")) { // if answer is yes
					CalcFlow(pacecalc, cli); // start application again
				} else if (answer.equals("no")) { // if answer is no
					cli.showExitMsg(); // show exit message
					System.exit(0); // close application
				}
				break;
			default: // if answer userinput is different than 1,2,3,0
				cli.showErrorMsg(); // show error message
				cli.showSelectionMsg(); // ask user to select needed action
										// again
				break;
			}
		} catch (NumberFormatException e) {
			cli.showErrorMsg();
			CalcFlow(pacecalc, cli);
		} catch (InputMismatchException e) {
			cli.showErrorMsg();
			CalcFlow(pacecalc, cli);
		}
		userInput.close();

	}
}