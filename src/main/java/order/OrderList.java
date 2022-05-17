package order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OrderList {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class getOrderList {
        private int courierId = 1;
        private String nearestStation = "";
        private int limit = 0;
        private int page = 0;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class getOrderListIncorrectId {
        private int courierId = 000001;
        private String nearestStation = "";
        private int limit = 0;
        private int page = 0;
        public static OrderList getOrderListIncorrectId() {
            return new OrderList();
        }
    }
}
