package order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Order {
    private String firstName = "Василий";
    private String lastName = "Теркин";
    private String address = "Улица Льва Толстого";
    private String metroStation = "Лубянка";
    private String phone = "+77778882123";
    private int rentTime = 4;
    private String deliveryDate = "2023-02-03";
    private String comment = "Всё путем, брат";
    private List<String> color;

    public static Order getOrder() {
        return new Order();
    }
}


