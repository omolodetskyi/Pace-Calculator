package pacecalc;

public class App {
	public static void main(String[] args) {
		try {
			if (args[0].equals("-cli")) {
				runCLI();
			}

			else {
				runGUI();
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			runGUI();
		}

	}

	// method to run CLI interface
	private static void runCLI() {
		Controller controller = new Controller();
		CLUI cli = new CLUI();
		PaceCalc pacecalc = new PaceCalc();
		controller.CalcFlow(pacecalc, cli);
	}

	// method to run GUI interface
	private static void runGUI() {
		Controller controller = new Controller();
		GUI gui = new GUI();
		PaceCalc pacecalc = new PaceCalc();
		controller.CalcFlow(pacecalc, gui);
	}
}
