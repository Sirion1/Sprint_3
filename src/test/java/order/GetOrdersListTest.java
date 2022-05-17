package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static order.OrderMake.getOrderIncorrectId;

public class GetOrdersListTest {

    @Test
    @DisplayName("Get Orders List")
    @Description("Получения списка всех заказов")
    public void getOrdersTest() {
        OrderList getOrderList = new OrderList();
        String OrderMakeEquals = OrderMake.getOrder(getOrderList);

        Assert.assertEquals(null, OrderMakeEquals);

    }
    @Test
    @DisplayName("Get Orders List With Incorrect Id")
    @Description("Получения списка всех заказов с неверным Id курьера")
    public void getOrdersIncorrectIdTest() {
        OrderList getOrderListIncorrectId = new OrderList();
        String OrderMakeEquals = getOrderIncorrectId(getOrderListIncorrectId);

        Assert.assertEquals("Курьер с идентификатором 000000001 не найден", OrderMakeEquals);

    }
}
