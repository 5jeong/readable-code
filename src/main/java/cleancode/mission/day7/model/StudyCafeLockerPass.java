package cleancode.mission.day7.model;

public class StudyCafeLockerPass implements StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    public StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    @Override
    public StudyCafePassType getPassType() {
        return this.passType;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String display() {
        return passType.format(duration,price);
    }
}
