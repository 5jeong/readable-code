package cleancode.mission.day7.model;

public class StudyCafeSeatPass implements StudyCafePass{

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    public StudyCafeSeatPass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafeSeatPass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafeSeatPass(passType, duration, price, discountRate);
    }

    public int calculateDiscountPrice() {
        return (int) (price * discountRate);
    }

    public int calculateTotalPrice(StudyCafeLockerPass lockerPass) {
        return price - calculateDiscountPrice() + (lockerPass != null ? lockerPass.getPrice() : 0);
    }

    public boolean hasDiscount() {
        return calculateDiscountPrice() > 0;
    }


    public boolean findByOption(StudyCafeLockerPass lockerPass) {
        return passType == lockerPass.getPassType() && duration == lockerPass.getDuration();
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
        return passType.format(duration, price);
    }
}
