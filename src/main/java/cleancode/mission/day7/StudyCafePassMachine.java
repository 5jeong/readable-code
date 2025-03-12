package cleancode.mission.day7;

import cleancode.mission.day7.exception.AppException;
import cleancode.mission.day7.io.InputHandler;
import cleancode.mission.day7.io.OutputHandler;
import cleancode.mission.day7.io.StudyCafeFileHandler;
import cleancode.mission.day7.model.StudyCafeLockerPass;
import cleancode.mission.day7.model.StudyCafeLockerPasses;
import cleancode.mission.day7.model.StudyCafePass;
import cleancode.mission.day7.model.StudyCafePassType;
import cleancode.mission.day7.model.StudyCafePasses;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public void run() {
        try {
            showStartMessage();

            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            StudyCafePasses allStudyCafePasses = studyCafeFileHandler.readStudyCafePasses();
            StudyCafePasses selectedPasses = allStudyCafePasses.filterByType(studyCafePassType);

            showPassListForSelection(selectedPasses);
            StudyCafePass selectedPass = inputHandler.getSelectPass(selectedPasses);

            StudyCafeLockerPasses allLockerPasses = studyCafeFileHandler.readLockerPasses();
            StudyCafeLockerPass lockerPass = allLockerPasses.findLockerPassFrom(selectedPass);

            boolean lockerSelection = lockerPass != null && userWantsLocker(lockerPass);

            outputHandler.showPassOrderSummary(selectedPass, lockerSelection ? lockerPass : null);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
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
