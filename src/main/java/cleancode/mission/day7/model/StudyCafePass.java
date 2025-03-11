package cleancode.mission.day7.model;

public class StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
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

    public String display() {
        return passType.format(duration, price);
    }
}
