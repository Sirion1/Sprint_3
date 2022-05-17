package Registration;

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


public class CourierTest {

    private CourierClient courierClient;
    private int courierId;

    @Before
    public void setup(){
       courierClient = new CourierClient();
    }

    @After
    public void teardown() {
        courierClient.delete(courierId);
    }

    @Test
    @DisplayName("Registration Courier")
    @Description ("Регистрация нового курьера")
    public void courierRegistrationTest() {
        Courier courier = Courier.getRandom();
        boolean created = courierClient.create(courier);

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);


        assertTrue(created);
        assertNotEquals(0, courierId);

    }
    @Test
    @DisplayName("Double Courier Registration")
    @Description ("Регистрация уже созданного курьера")
    public void courierDoubleRegistrationLoginTest() {
        Courier courier = Courier.getRandom();
        boolean created = courierClient.create(courier);

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);

        assertTrue(created);
        assertNotEquals(0, courierId);

        courierClient.createDouble(courier);
    }
}

