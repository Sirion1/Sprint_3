package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class OrderTestWithColorTest {

    private final List<String> color;
    private final int expectedCode;


    public OrderTestWithColorTest(List<String> color, int expectedCode) {
        this.color = color;
        this.expectedCode = expectedCode;
    }
    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {List.of("BLACK"), 201},
                {List.of("GREY"), 201},
                {List.of("BLACK", "GREY"), 201},
                {List.of(""), 201}
        };
    }

    @Test
    @DisplayName("Make Order With Color")
    @Description("Создание нового заказа с цветами")
    public void orderMakeTestWithColor() {
        Order order = Order.getOrder();
        int track = OrderMake.make(order);

        assertNotNull(track);
        assertNotEquals(0, track);

    }
}
