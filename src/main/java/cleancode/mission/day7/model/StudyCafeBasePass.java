package cleancode.mission.day7.model;

public abstract class StudyCafeBasePass {

    protected final StudyCafePassType passType;
    protected final int duration;
    protected final int price;

    protected StudyCafeBasePass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public String display() {
        return passType.format(duration, price);
    }
}
