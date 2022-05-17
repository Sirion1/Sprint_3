package login;

import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


public class CourierLoginTest {

    private CourierClient courierClient = new CourierClient();
    private int courierId;

    @Before
    public void setup() {
    }
    Courier courier = Courier.getRandom();

    @After
    public void teardown() {
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Login Courier")
    @Description ("Авторизация курьера")
    public void courierRegistrationTest() {
        boolean created = courierClient.create(courier);

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);

        assertTrue(created);
        assertNotEquals(0, courierId);

    }
    @Test
    @DisplayName("Login Courier Without Data")
    @Description ("Авторизация курьера без пароля")
    public void courierLoginWithoutDataTest() {
        boolean created = courierClient.create(courier);

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);

        courier.setPassword("");
        courier.setFirstName("");
        courierClient.loginWithoutData(CourierCredentials.from(courier));

        assertTrue(created);
        assertNotEquals(0, courierId);

    }

}
