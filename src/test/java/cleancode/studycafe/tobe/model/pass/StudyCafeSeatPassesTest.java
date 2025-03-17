package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassesTest {

    private StudyCafeSeatPass passHourly1;
    private StudyCafeSeatPass passHourly2;
    private StudyCafeSeatPass passWeekly;

    @BeforeEach
    void setUp() {
        passHourly1 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 10000, 0.9);
        passHourly2 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 3, 15000, 0.8);
        passWeekly   = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 4, 12000, 0.85);
    }

    @DisplayName("특정 타입에 해당하는 좌석 이용권이 목록을 반환한다.")
    @Test
    void testFindPassByWhenExists() {
        // given
        List<StudyCafeSeatPass> seatPassList = List.of(passHourly1, passWeekly, passHourly2);
        StudyCafeSeatPasses seatPasses = StudyCafeSeatPasses.of(seatPassList);

        // when
        List<StudyCafeSeatPass> found = seatPasses.findPassBy(StudyCafePassType.HOURLY);

        // then
        assertThat(found).containsExactlyInAnyOrder(passHourly1, passHourly2);
    }

    @DisplayName("해당 타입에 맞는 좌석 이용권이 없으면 빈 목록을 반환한다.")
    @Test
    void testFindPassByWhenNotExists() {
        // given
        List<StudyCafeSeatPass> seatPassList = List.of(passHourly1, passHourly2);
        StudyCafeSeatPasses seatPasses = StudyCafeSeatPasses.of(seatPassList);

        // when
        List<StudyCafeSeatPass> found = seatPasses.findPassBy(StudyCafePassType.WEEKLY);

        // then
        assertThat(found).isEmpty();
    }
}