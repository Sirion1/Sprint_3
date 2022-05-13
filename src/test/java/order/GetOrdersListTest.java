package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class GetOrdersListTest {

    private static OrderMake orderMake;

    @Before
    public void setup(){
        orderMake = new OrderMake();
    }

    @Test
    @DisplayName("Get Orders List")
    @Description("Получения списка всех заказов")
    public void getOrdersTest() {
        OrderList getOrderList = new OrderList();
        OrderMake.getOrder(getOrderList);

        assertNotEquals(0, "orders");

    }
    @Test
    @DisplayName("Get Orders List With Incorrect Id")
    @Description("Получения списка всех заказов с неверным Id курьера")
    public void getOrdersIncorrectIdTest() {
        OrderList getOrderListIncorrectId = new OrderList();
        OrderMake.getOrderIncorrectId(getOrderListIncorrectId);

        assertNotEquals(0, "orders");

    }
}
