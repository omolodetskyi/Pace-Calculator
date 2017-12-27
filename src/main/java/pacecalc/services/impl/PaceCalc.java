package pacecalc.services.impl;

import pacecalc.services.Calc;

public class PaceCalc implements Calc {

	public int calcPace(int time, int distance) {
		return (1000 * time) / distance;
	}

	public int calcDistance(int time, int pace) {
		return (1000 * time) / pace;
	}

	public double calcSpeed(int pace) {
		return 3600 / pace;
	}

	public int calcTime(int pace, int distance) {
		return (pace * distance) / 1000;
	}
}
