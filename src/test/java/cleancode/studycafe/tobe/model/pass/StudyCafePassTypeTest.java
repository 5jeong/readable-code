package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassTypeTest {


    @DisplayName("FIXED는 락커 타입이고, HOURLY와 WEEKLY는 락커 타입이 아니다.")
    @Test
    void testIsLockerType() {
        assertThat(StudyCafePassType.FIXED.isLockerType()).isTrue();
        assertThat(StudyCafePassType.HOURLY.isLockerType()).isFalse();
        assertThat(StudyCafePassType.WEEKLY.isLockerType()).isFalse();
    }

    @DisplayName("락커 패스가 아닌 경우 isNotLockerPass가 true를 반환한다.")
    @Test
    void testIsNotLockerPass() {
        assertThat(StudyCafePassType.FIXED.isNotLockerPass()).isFalse();
        assertThat(StudyCafePassType.HOURLY.isNotLockerPass()).isTrue();
        assertThat(StudyCafePassType.WEEKLY.isNotLockerPass()).isTrue();
    }

}