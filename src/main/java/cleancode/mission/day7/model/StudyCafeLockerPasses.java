package cleancode.mission.day7.model;

import java.util.List;

public class StudyCafeLockerPasses {

    private final List<StudyCafeLockerPass> lockerPasses;

    public StudyCafeLockerPasses(List<StudyCafeLockerPass> lockerPasses) {
        this.lockerPasses = lockerPasses;
    }

    public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> lockerPasses) {
        return new StudyCafeLockerPasses(lockerPasses);
    }

    public StudyCafeLockerPass findLockerPassFrom(StudyCafePass selectedPass) {
        return lockerPasses.stream()
                .filter(selectedPass::findByOption)
                .findFirst()
                .orElse(null);
    }

}
