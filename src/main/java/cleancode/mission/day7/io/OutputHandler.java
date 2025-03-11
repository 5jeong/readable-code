package cleancode.mission.day7.io;

import cleancode.mission.day7.model.StudyCafeLockerPass;
import cleancode.mission.day7.model.StudyCafePass;
import cleancode.mission.day7.model.StudyCafePasses;

public class OutputHandler {

    public void showWelcomeMessage() {
        System.out.println("*** 프리미엄 스터디카페 ***");
    }

    public void showAnnouncement() {
        System.out.println("* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)");
        System.out.println("* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)");
        System.out.println();
    }

    public void askPassTypeSelection() {
        System.out.println("사용하실 이용권을 선택해 주세요.");
        System.out.println("1. 시간 이용권(자유석) | 2. 주단위 이용권(자유석) | 3. 1인 고정석");
    }

    public void showPassListForSelection(StudyCafePasses passes) {
        System.out.println();
        System.out.println("이용권 목록");
        for (int index = 0; index < passes.size(); index++) {
            StudyCafePass pass = passes.get(index);
            System.out.println(String.format("%s. ", index + 1) + pass.display());
        }
    }

    public void askLockerPass(StudyCafeLockerPass lockerPass) {
        System.out.println();
        String askMessage = String.format(
                "사물함을 이용하시겠습니까? (%s)",
                lockerPass.display()
        );

        System.out.println(askMessage);
        System.out.println("1. 예 | 2. 아니오");
    }

    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        System.out.println();
        System.out.println("이용 내역");
        System.out.println("이용권: " + selectedPass.display());
        if (lockerPass != null) {
            System.out.println("사물함: " + lockerPass.display());
        }

        if (selectedPass.hasDiscount()) {
            System.out.println("이벤트 할인 금액: " + selectedPass.calculateDiscountPrice() + "원");
        }

        System.out.println("총 결제 금액: " + selectedPass.calculateTotalPrice(lockerPass) + "원");
        System.out.println();
    }

    public void showSimpleMessage(String message) {
        System.out.println(message);
    }

}
