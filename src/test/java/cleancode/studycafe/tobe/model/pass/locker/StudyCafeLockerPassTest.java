package cleancode.studycafe.tobe.model.pass.locker;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeLockerPassTest {

    @DisplayName("객체 생성 후 getter가 올바른 값을 반환한다.")
    @Test
    void testCreationAndGetters() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        int duration = 3;
        int price = 15000;

        // when
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(passType, duration, price);

        // then
        assertThat(lockerPass.getPassType()).isEqualTo(passType);
        assertThat(lockerPass.getDuration()).isEqualTo(duration);
        assertThat(lockerPass.getPrice()).isEqualTo(price);
    }

    @DisplayName("이용권 타입이 같으면 true, 다르면 false를 반환한다.")
    @Test
    void testIsSamePassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 2, 10000);

        // when & then
        assertThat(lockerPass.isSamePassType(StudyCafePassType.FIXED)).isTrue();
        assertThat(lockerPass.isSamePassType(StudyCafePassType.HOURLY)).isFalse();
    }

    @DisplayName("기간이 같으면 true, 다르면 false를 반환한다.")
    @Test
    void testIsSameDuration() {
        // given
        int duration = 4;
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, duration, 20000);

        // when & then
        assertThat(lockerPass.isSameDuration(duration)).isTrue();
        assertThat(lockerPass.isSameDuration(5)).isFalse();
    }
}