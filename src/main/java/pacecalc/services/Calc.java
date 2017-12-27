package pacecalc.services;

public interface Calc {

    int calcPace(int time, int distance);

    int calcDistance(int time, int pace);

    double calcSpeed(int pace);

    int calcTime(int pace, int distance);

}
