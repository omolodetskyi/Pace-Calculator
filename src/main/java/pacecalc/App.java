package pacecalc;

public class App {
	public static void main(String[] args) {
		Controller controller = new Controller();
		CLUI cli = new CLUI();
		PaceCalc pacecalc = new PaceCalc();
		controller.CalcFlow(pacecalc, cli);
	}
}
