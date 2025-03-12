package cleancode.mission.day7.model;

public class StudyCafePass extends StudyCafeBasePass{

    private final double discountRate;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        super(passType,duration,price);
        this.discountRate = discountRate;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
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
}
