package pacecalc;

public class App {
	public static void main(String[] args) {
		try {
			if (args[0].equals("-cli")) {
				Controller controller = new Controller();
				CLUI cli = new CLUI();
				PaceCalc pacecalc = new PaceCalc();
				controller.CalcFlow(pacecalc, cli);
			}

			else {
				Controller controller = new Controller();
				GUI gui = new GUI();
				PaceCalc pacecalc = new PaceCalc();
				controller.CalcFlow(pacecalc, gui);
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			// not implemented yet
		}

	}
}
