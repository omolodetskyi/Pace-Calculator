package pacecalc;

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
		resultPace = (int) (1000 * time / distance);
		return resultPace;
	}

	// second constructor which sets all fields on create Object

	public PaceCalc(int pace, int distance, int time, double speed) {
		this.setDistance(distance);
		this.setPace(pace);
		this.setTime(time);
		this.setSpeed(speed);
	}
}
