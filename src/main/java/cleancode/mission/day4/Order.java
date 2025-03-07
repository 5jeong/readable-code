//package cleancode.mission.day4;
//
//import java.util.List;
//
//public class Order {
//    private final List<Item> items;
//
//    public Order(List<Item> items) {
//        this.items = items;
//    }
//
//    private boolean validateOrder(Order order) {
//        if (isOrderEmpty(order)) {
//            log.info("주문 항목이 없습니다.");
//            return false;
//        }
//        if (hasNoCustomerInfo(order)) {
//            log.info("사용자 정보가 없습니다.");
//            return false;
//        }
//        if (isTotalPriceInvalid(order)) {
//            log.info("올바르지 않은 총 가격입니다.");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean hasNoCustomerInfo(Order order) {
//        return !order.hasCustomerInfo();
//    }
//
//    private boolean isOrderEmpty(Order order) {
//        return order.getItems() == null || order.getItems().isEmpty();
//    }
//
//    private boolean isTotalPriceInvalid(Order order) {
//        return order.getTotalPrice() <= 0;
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public int getTotalPrice() {
//        return 0;
//    }
//
//    public boolean hasCustomerInfo() {
//        return false;
//    }
//}
