package cleancode.studycafe.tobe.model.pass;

import static org.assertj.core.api.Assertions.assertThat;


import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassTest {

    @DisplayName("객체 생성 후 getter가 올바른 값을 반환한다.")
    @Test
    void testCreationAndGetters() {
        // given
        StudyCafePassType passType = StudyCafePassType.HOURLY;
        int duration = 2;
        int price = 10000;
        double discountRate = 0.9;

        // when
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(passType, duration, price, discountRate);

        // then
        assertThat(seatPass.getPassType()).isEqualTo(passType);
        assertThat(seatPass.getDuration()).isEqualTo(duration);
        assertThat(seatPass.getPrice()).isEqualTo(price);
    }


    @DisplayName("비락커 이용권일 경우 true를 반환한다.")
    @Test
    void testCannotUserLockerNonLocker() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 10000, 0.9);

        // when
        boolean result = seatPass.cannotUserLocker();

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("락커 이용권일 경우 false를 반환한다.")
    @Test
    void testCannotUserLockerLocker() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 2, 10000, 0.9);

        // when
        boolean result = seatPass.cannotUserLocker();

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("기간권 타입이 같으면 true, 다르면 false를 반환한다.")
    @Test
    void testIsSamePassType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 5, 50000, 0.8);

        // when & then
        assertThat(seatPass.isSamePassType(StudyCafePassType.WEEKLY)).isTrue();
        assertThat(seatPass.isSamePassType(StudyCafePassType.HOURLY)).isFalse();
    }

    @DisplayName("할인 가격 계산 검증")
    @Test
    void testGetDiscountPrice() {
        // given
        int price = 10000;
        double discountRate = 0.85;
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 3, price, discountRate);

        // when
        int discountPrice = seatPass.getDiscountPrice();

        // then
        assertThat((int)(price * discountRate)).isEqualTo(discountPrice);
    }

    @DisplayName("이용권 타입 및 기간이 동일하면 true, 아니면 false를 반환한다.")
    @Test
    void testIsSameDurationType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 12000, 0.9);
        StudyCafeLockerPass matchingLocker = StudyCafeLockerPass.of(StudyCafePassType.HOURLY, 4,10000);
        StudyCafeLockerPass nonMatchingLockerType = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 4,10000);
        StudyCafeLockerPass nonMatchingDuration = StudyCafeLockerPass.of(StudyCafePassType.HOURLY, 5,10000);

        // when & then
        assertThat(seatPass.isSameDurationType(matchingLocker)).isTrue();
        assertThat(seatPass.isSameDurationType(nonMatchingLockerType)).isFalse();
        assertThat(seatPass.isSameDurationType(nonMatchingDuration)).isFalse();
    }
}