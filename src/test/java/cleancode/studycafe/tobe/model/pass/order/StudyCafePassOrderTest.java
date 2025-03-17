package cleancode.studycafe.tobe.model.pass.order;

import static org.assertj.core.api.Assertions.assertThat;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassOrderTest {

    private StudyCafeSeatPass seatPassWithLocker;
    private StudyCafeSeatPass seatPassWithoutLocker;
    private StudyCafeLockerPass lockerPass;

    @BeforeEach
    void setUp() {
        seatPassWithLocker = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 3, 10000, 0.1); // 할인 가격 1000
        lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 2, 5000);
        seatPassWithoutLocker = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 15000, 0.1); // 할인 가격 1500
    }

    @DisplayName("SeatPass와 LockerPass로 StudyCafePassOrder를 생성한다.")
    @Test
    void testCreateOrder() {
        // when
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPassWithLocker, lockerPass);

        // then
        assertThat(order.getSeatPass()).isEqualTo(seatPassWithLocker);
        assertThat(order.getLockerPass()).isPresent().contains(lockerPass);
    }


    @DisplayName("Order 생성 시, lockerPass가 있는 경우 올바른 값들을 반환한다.")
    @Test
    void testOrderWithLocker() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPassWithLocker, lockerPass);

        // then
        assertThat(order.getSeatPass()).isEqualTo(seatPassWithLocker);
        assertThat(order.getLockerPass()).isPresent().contains(lockerPass);
        assertThat(order.getDiscountPrice()).isEqualTo(seatPassWithLocker.getDiscountPrice());
        assertThat(order.getTotalPrice()).isEqualTo(seatPassWithLocker.getPrice());
    }


    @DisplayName("Order 생성 시, lockerPass가 없으면 올바른 값들을 반환한다.")
    @Test
    void testOrderWithoutLocker() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPassWithoutLocker, null);

        // then
        assertThat(order.getSeatPass()).isEqualTo(seatPassWithoutLocker);
        assertThat(order.getLockerPass()).isNotPresent();
        assertThat(order.getDiscountPrice()).isEqualTo(seatPassWithoutLocker.getDiscountPrice());
        assertThat(order.getTotalPrice()).isEqualTo(seatPassWithoutLocker.getPrice());
    }

    @DisplayName("Order 생성 시, LockerPass가 없는 경우 Optional.empty()를 반환한다.")
    @Test
    void testGetLockerPassWhenNotPresent() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPassWithoutLocker, null);

        // when
        Optional<StudyCafeLockerPass> locker = order.getLockerPass();

        // then
        assertThat(locker).isEmpty();
    }

    @DisplayName("총 가격을 계산할 때, LockerPass가 없는 경우 SeatPass 가격만 반환한다.")
    @Test
    void testGetTotalPriceWithoutLockerPass() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPassWithoutLocker, null);

        // when
        int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(seatPassWithoutLocker.getPrice());
    }

    @DisplayName("총 가격을 계산할 때, LockerPass가 있는 경우 SeatPass 가격을 반환한다.")
    @Test
    void testGetTotalPriceWithLockerPass() {
        // given
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPassWithLocker, lockerPass);

        // when
        int totalPrice = order.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(seatPassWithLocker.getPrice());
    }

}