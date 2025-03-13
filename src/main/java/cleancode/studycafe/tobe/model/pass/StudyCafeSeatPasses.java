package cleancode.studycafe.tobe.model.pass;

import java.util.List;

public class StudyCafeSeatPasses {

    private final List<StudyCafeSeatPass> studyCafeSeatPasses;

    public StudyCafeSeatPasses(List<StudyCafeSeatPass> studyCafeSeatPasses) {
        this.studyCafeSeatPasses = studyCafeSeatPasses;
    }

    public static StudyCafeSeatPasses of(List<StudyCafeSeatPass> studyCafeSeatPasses) {
        return new StudyCafeSeatPasses(studyCafeSeatPasses);
    }

    public List<StudyCafeSeatPass> findPassBy(StudyCafePassType studyCafePassType) {
        return studyCafeSeatPasses.stream()
                .filter(studyCafePass -> studyCafePass.isSamePassType(studyCafePassType))
                .toList();
    }
}
