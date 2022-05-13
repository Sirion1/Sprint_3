package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


public class OrderTest {

    private static OrderMake orderMake;
    private int track;

    @Before
    public void setup(){
        orderMake = new OrderMake();
    }

    @After
    public void teardown() {
        OrderMake.cancel(track);
    }

    @Test
    @DisplayName("Make Order")
    @Description("Создание нового заказа без цветов")
    public void orderMakeTest() {
        Order order = Order.getOrder();
        track = OrderMake.make(order);

        assertNotNull(track);
        assertNotEquals(0, track);

    }

}
