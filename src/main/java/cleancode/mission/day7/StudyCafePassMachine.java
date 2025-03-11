package cleancode.mission.day7;

import cleancode.mission.day7.exception.AppException;
import cleancode.mission.day7.io.InputHandler;
import cleancode.mission.day7.io.OutputHandler;
import cleancode.mission.day7.io.StudyCafeFileHandler;
import cleancode.mission.day7.model.StudyCafeLockerPass;
import cleancode.mission.day7.model.StudyCafePass;
import cleancode.mission.day7.model.StudyCafePassType;
import cleancode.mission.day7.model.StudyCafePasses;
import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public void run() {
        try {
            showStartMessage();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            StudyCafePasses studyCafePasses = StudyCafePasses.of(studyCafeFileHandler.readStudyCafePasses());
            StudyCafePasses selectedPasses = studyCafePasses.filterByType(studyCafePassType);

            if (selectedPasses.isEmpty()) {
                throw new AppException("해당 유형의 이용권이 없습니다.");
            }

            showPassListForSelection(selectedPasses);
            StudyCafePass selectedPass = inputHandler.getSelectPass(selectedPasses);

            StudyCafeLockerPass lockerPass = getLockerPassIfAvalilable(selectedPass);
            boolean lockerSelection = lockerPass != null && userWantsLocker(lockerPass);

            outputHandler.showPassOrderSummary(selectedPass, lockerSelection ? lockerPass : null);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafeLockerPass getLockerPassIfAvalilable(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();
        return lockerPasses.stream()
                .filter(option ->
                        option.getPassType() == selectedPass.getPassType()
                                && option.getDuration() == selectedPass.getDuration()
                )
                .findFirst()
                .orElse(null);
    }


    private void showStartMessage() {
        outputHandler.showWelcomeMessage();
        outputHandler.showAnnouncement();

        outputHandler.askPassTypeSelection();
    }

    private void showPassListForSelection(StudyCafePasses hourlyPasses) {
        outputHandler.showPassListForSelection(hourlyPasses);
    }


    private boolean userWantsLocker(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
        return inputHandler.getLockerSelection();
    }
}
