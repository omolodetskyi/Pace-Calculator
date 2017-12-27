package pacecalc;

import pacecalc.controllers.Controller;
import pacecalc.services.impl.ClientUI;
import pacecalc.services.impl.PaceCalc;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		Controller controller = new Controller(new PaceCalc(), new ClientUI());
		controller.calcFlow();
	}
}
