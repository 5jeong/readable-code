package cleancode.mission.day7.io;

import cleancode.mission.day7.exception.AppException;
import cleancode.mission.day7.model.StudyCafeSeatPass;
import cleancode.mission.day7.model.StudyCafePassType;
import cleancode.mission.day7.model.StudyCafeSeatPasses;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();

        if (StudyCafePassType.HOURLY.getNumber().equals(userInput)) {
            return StudyCafePassType.HOURLY;
        }
        if (StudyCafePassType.WEEKLY.getNumber().equals(userInput)) {
            return StudyCafePassType.WEEKLY;
        }
        if (StudyCafePassType.FIXED.getNumber().equals(userInput)) {
            return StudyCafePassType.FIXED;
        }
        throw new AppException("잘못된 입력입니다.");
    }

    public StudyCafeSeatPass getSelectPass(StudyCafeSeatPasses passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.get(selectedIndex);
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return "1".equals(userInput);
    }

}
