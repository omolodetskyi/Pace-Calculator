package pacecalc.services;

public interface UI {

    void showSelectionMsg();

    void showContinueMsg();

    void showWelcomeMsg();

    void showErrorMsg();

    void showCalculatePaceMsg();

    void showCalculateSpeed();

    void showCalculateDistanceMsg();

    void showCalculateTimeMsg();

    void showCalculateSpeedMsg();

    void showEnterTimeMsg();

    void showEnterDistanceMsg();

    void showEnterPaceMsg();

    void showExitQuestionMsg();

    void showExitMsg();

    void showCalculatedPace(String pace);

    void showCalculatedSpeed(String speed);

    void showCalculatedTime(String time);

    void showCalculatedPaceWrong();

    void showCalculatedTimeWrong();

    void showCalculatedDistance(String distance);

    void showCalculatedDistanceWrong();

}
