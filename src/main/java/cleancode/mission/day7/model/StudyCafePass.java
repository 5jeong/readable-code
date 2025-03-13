package cleancode.mission.day7.model;

public interface StudyCafePass {

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

    String display();
}
