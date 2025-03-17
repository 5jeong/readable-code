package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeLockerPassesTest {
    private StudyCafeSeatPass seatPass;

    @BeforeEach
    void setUp() {
        seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 12000, 0.9);
    }

    @DisplayName("매칭되는 락커이용권이 있으면 반환한다.")
    @Test
    void testFindLockerPassByWhenExists() {
        // given
        StudyCafeLockerPass matchingLocker = StudyCafeLockerPass.of(StudyCafePassType.HOURLY, 4, 10000);
        StudyCafeLockerPass nonMatchingLocker = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 4, 10000);
        List<StudyCafeLockerPass> lockerPassList = List.of(matchingLocker, nonMatchingLocker);
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(lockerPassList);

        // when
        Optional<StudyCafeLockerPass> found = lockerPasses.findLockerPassBy(seatPass);

        // then
        assertThat(found).isPresent().contains(matchingLocker);
    }

    @DisplayName("매칭되는 락커이용권이이 없으면 빈 Optional을 반환한다.")
    @Test
    void testFindLockerPassByWhenNotExists() {
        // given
        StudyCafeLockerPass locker1 = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 4, 10000);
        StudyCafeLockerPass locker2 = StudyCafeLockerPass.of(StudyCafePassType.HOURLY, 5, 10000);
        List<StudyCafeLockerPass> lockerPassList = List.of(locker1, locker2);
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(lockerPassList);

        // when
        Optional<StudyCafeLockerPass> found = lockerPasses.findLockerPassBy(seatPass);

        // then
        assertThat(found).isNotPresent();
    }
}