package cleancode.mission.day7.model;

public enum StudyCafePassType {

    HOURLY("시간 단위 이용권", "1"),
    WEEKLY("주 단위 이용권", "2"),
    FIXED("1인 고정석", "3");

    private final String description;
    private final String number;

    StudyCafePassType(String description, String number) {
        this.description = description;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
