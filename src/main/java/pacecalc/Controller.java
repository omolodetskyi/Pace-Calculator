package pacecalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.Parser;

public class Controller {
	private PaceCalc pacecalc;
	private CLUI cli;
	private GUI gui;

	public Controller() {

		// just to test push to version2
		// again
		// and again

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
					cli.showEnterTimeMsg(); // request to enter pace
					paceStr = userInput.next(); // take pace from user input
					paceInt = parser.paceStringToInt(paceStr); // parse pace to
																// int
				}
				pacecalc.setPace(paceInt); // set pace in pacecalc object
				timeInt = pacecalc.calcTime(); // calculate time
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
		} // TODO what if both exception occurs? Could it be that application is
			// started twice?
		catch (NumberFormatException e) { // in case of numberformat exception
			cli.showErrorMsg(); // show error message
			CalcFlow(pacecalc, cli); // restart application
		} catch (InputMismatchException e) { // in case of
												// InputMismatchException
			cli.showErrorMsg(); // show error message
			CalcFlow(pacecalc, cli); // restart application
		}
		userInput.close();

	}

	public void CalcFlow(PaceCalc pacecalc, GUI gui) { // same method as
														// CalcFlow, but uses
														// another parameters
		this.gui = gui;
		this.pacecalc = pacecalc;

		this.gui.addCalcListener(new Calculate()); // add listener to Calc
													// button
		this.gui.addExitListener(new Exit()); // add listener to Exit button
	}

	// ActionListener for Calculate button, placed it here to support MVC
	// pattern
	class Calculate implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int timeInt;
			int distanceInt;
			int paceInt;
			String timeStr;
			String distanceStr;
			String paceStr;
			Parser parser = new Parser();
			try { // catch exceptions
				switch (gui.getCalcSelection()) { // take a user selection for
													// calculation
				case 1: // pace calculation
					timeStr = gui.getTime(); // take time from corresponded
												// field
					distanceStr = gui.getDistance(); // take distance from
														// corresponded field
					timeInt = parser.timeStringToInt(timeStr); // parse time
					distanceInt = parser.distanceStringToInt(distanceStr); // parse
																			// distance
					if (timeInt < 0 || distanceInt < 0) { // if there is wrong
															// value after
															// parsing
						gui.showErrorMessage(); // show error message
						// TODO maybe make wrong values in fields red?
					} else {// if values are OK
						pacecalc.setDistance(distanceInt); // set distance in
															// pacecalc object
						pacecalc.setTime(timeInt); // set time in pacecalc
													// object
						paceInt = pacecalc.calcPace(); // calculate pace
						paceStr = parser.parseFromPace(paceInt); // parse
																	// calculated
																	// pace to
																	// Str
						gui.setPace(paceStr); // show corresponded value in UI
					}
					break;
				case 2: // time calculation
					paceStr = gui.getPace(); // take pace from corresponded
												// field
					distanceStr = gui.getDistance(); // take distance from
														// corresponded field
					paceInt = parser.paceStringToInt(paceStr); // parse pace
					distanceInt = parser.distanceStringToInt(distanceStr); // parse
																			// distance
					if (paceInt < 0 || distanceInt < 0) { // if there is wrong
															// value after
															// parsing
						gui.showErrorMessage();// show error message
						// TODO maybe make wrong values in fields red?
					} else {// if values are OK
						pacecalc.setDistance(distanceInt); // set distance in
															// pacecalc object
						pacecalc.setPace(paceInt); // set pace i pacecalc object
						timeInt = pacecalc.calcTime(); // calculate time
						timeStr = parser.parseFromTime(timeInt); // parse time
																	// from int
																	// to string
						gui.setTime(timeStr); // show corresponded value in UI
					}
					break;
				case 3: // distance calculation
					paceStr = gui.getPace(); // take pace from corresponded
												// field
					timeStr = gui.getTime(); // take time from corresponded
												// field
					paceInt = parser.paceStringToInt(paceStr); // parse pace
																// from string
																// to int
					timeInt = parser.timeStringToInt(timeStr); // parse time
																// from string
																// to int
					if (paceInt < 0 || timeInt < 0) {// if there is wrong value
														// after parsing
						gui.showErrorMessage(); // show error message
						// TODO maybe make wrong values in fields red?
					} else { // if ok
						pacecalc.setTime(timeInt); // set time to pacecalc
													// object
						pacecalc.setPace(paceInt); // set pace to pacecalc
													// object
						distanceInt = pacecalc.calcDistance(); // calculate
																// distance
						distanceStr = parser.parseFromDistance(distanceInt); // parse
																				// distance
																				// from
																				// int
																				// to
																				// string
						gui.setDistance(distanceStr); // show corresponded value
														// in UI

					}
					break;
				}
			} catch (Exception error) { // in case of exception
				gui.showErrorMessage(); // show error
			}

		}

	}

	// it's action listener for Exit button. Placed it in Controller and not in
	// UI in order to support MVC pattern
	class Exit implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int userExit = gui.showExitMessage(); // invoke showExitMessage gui
													// method, it returns 0 if
													// user pressed Yes and 1 if
													// he pressed No in Exit
													// dialog
			if (userExit == 0) { // if user pressed Yes (0)
				System.exit(0); // exit application
			}

		}

	}

}