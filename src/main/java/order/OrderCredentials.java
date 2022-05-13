package order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCredentials {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private List<String> color;


    public OrderCredentials(Order order) {
        this.firstName = order.getFirstName();
        this.lastName = order.getLastName();
        this.address = order.getAddress();
        this.metroStation = order.getMetroStation();
        this.phone = order.getPhone();
        this.rentTime = order.getRentTime();
        this.deliveryDate = order.getDeliveryDate();
        this.comment = order.getComment();
        this.color = getColor();
    }


    public static OrderCredentials from (Order order) {
        return new OrderCredentials(order);
    }


}
