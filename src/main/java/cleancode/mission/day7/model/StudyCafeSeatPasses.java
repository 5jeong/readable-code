package cleancode.mission.day7.model;

import java.util.List;

public class StudyCafeSeatPasses {

    private final List<StudyCafeSeatPass> studyCafeSeatPasses;

    public StudyCafeSeatPasses(List<StudyCafeSeatPass> studyCafeSeatPasses) {
        this.studyCafeSeatPasses = studyCafeSeatPasses;
    }

    public static StudyCafeSeatPasses of(List<StudyCafeSeatPass> studyCafeSeatPasses) {
        return new StudyCafeSeatPasses(studyCafeSeatPasses);
    }

    public StudyCafeSeatPasses filterByType(StudyCafePassType type) {
        List<StudyCafeSeatPass> filteredPasses = studyCafeSeatPasses.stream()
                .filter(studyCafePass -> studyCafePass.getPassType() == type)
                .toList();
        return of(filteredPasses);
    }

    public boolean isEmpty() {
        return studyCafeSeatPasses.isEmpty();
    }

    public int size() {
        return studyCafeSeatPasses.size();
    }

    public StudyCafeSeatPass get(int index) {
        return studyCafeSeatPasses.get(index);
    }
}
