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
				// not implemented yet
			}

		} catch (ArrayIndexOutOfBoundsException e) {
			// not implemented yet
		}

	}
}
