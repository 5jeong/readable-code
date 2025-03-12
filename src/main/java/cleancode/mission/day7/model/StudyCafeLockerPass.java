package cleancode.mission.day7.model;

public class StudyCafeLockerPass extends StudyCafeBasePass {

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        super(passType, duration, price);
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

}
