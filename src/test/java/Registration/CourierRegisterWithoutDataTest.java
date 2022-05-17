package Registration;

import courier.Courier;
import courier.CourierClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourierRegisterWithoutDataTest {
    private CourierClient courierClient;

    @Before
    public void setup(){
        courierClient = new CourierClient();
    }

    @Test
    @DisplayName("Registration data")
    @Description("Проверка регистрации курьера только с полем Login")
    public void courierDoubleRegistrationOnlyLoginTest() {
        Courier courier = Courier.getRandomLogin();
        String createWithoutData = courierClient.createWithoutData(courier);

        assertNotNull(createWithoutData);

    }
}
