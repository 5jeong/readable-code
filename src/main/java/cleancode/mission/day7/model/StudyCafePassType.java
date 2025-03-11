package cleancode.mission.day7.model;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권", "1", "%d시간권 - %d원"),
    WEEKLY("주 단위 이용권", "2", "%d주권 - %d원"),
    FIXED("1인 고정석", "3", "%d주권 - %d원");

    private final String description;
    private final String number;
    private final String format;

    StudyCafePassType(String description, String number, String format) {
        this.description = description;
        this.number = number;
        this.format = format;
    }

    public String getNumber() {
        return number;
    }

    public String format(int duration,int price){
        return format.formatted(duration,price);
    }

}
