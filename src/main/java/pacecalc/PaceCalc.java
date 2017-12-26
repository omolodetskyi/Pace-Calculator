package pacecalc;

import util.Constants;

public class PaceCalc {

	private int time; // time in seconds
	private double speed; // speed in km/h
	private int pace; // pace in seconds per km
	private int distance; // distance in meters

	// getters return PaceCalc fields

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getSpeed() {
		return speed;
	}

	// setters set PaceCalc fields

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getPace() {
		return pace;
	}

	public void setPace(int pace) {
		this.pace = pace;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	// Default empty constructor
	public PaceCalc() {
	}

	// method for Pace calculation based on distance and time

	protected int calcPace() {
		int distance = this.getDistance();
		int time = this.getTime();
		int resultPace;
		resultPace = (int) (Constants.ONEKM_INMETERS * time / distance);
		return resultPace;
	}

	// method for Distance calculation based on pace and time

	protected int calcDistance() {
		int pace = this.getPace();
		int time = this.getTime();
		int resultDistance;
		resultDistance = (int) (Constants.ONEKM_INMETERS * time / pace);
		return resultDistance;
	}

	// method for speed calculation based on pace

	protected double calcSpeed() {
		double resultSpeed;
		pace = this.getPace();
		resultSpeed = (double) (Constants.ONEHOUR_INSEC) / (double) (pace);
		return resultSpeed;
	}

	// method for Time calculation based on pace and distance

	protected int calcTime() {
		int resultTime;
		int pace = this.getPace();
		int distance = this.getDistance();
		resultTime = (int) (pace * distance / Constants.ONEKM_INMETERS);
		return resultTime;
	}

	// second constructor which sets all fields on create Object

	public PaceCalc(int pace, int distance, int time, double speed) {
		this.setDistance(distance);
		this.setPace(pace);
		this.setTime(time);
		this.setSpeed(speed);
	}

}
