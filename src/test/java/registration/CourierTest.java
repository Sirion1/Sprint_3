package registration;

import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CourierTest {
    private CourierClient courierClient = new CourierClient();
    private int courierId;

    @Before
    public void setup(){
    }
    Courier courier = Courier.getRandom();

    @After
    public void teardown() {
        if (99999<=courierId) {
            courierClient.delete(courierId);
        }
    }
    @Test
    @DisplayName("Registration Courier")
    @Description ("Регистрация нового курьера")
    public void courierRegistrationTest() {
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
        boolean created = courierClient.create(courier);

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);

        assertTrue(created);
        assertNotEquals(0, courierId);

        String createdDouble = courierClient.createDouble(courier);
        assertEquals( "Ответ метода отличается", "Этот логин уже используется. Попробуйте другой.", createdDouble);
    }

}

