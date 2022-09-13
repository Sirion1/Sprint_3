package registration;

import courier.Courier;
import courier.CourierClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourierRegisterWithoutDataTest {
    private CourierClient courierClient = new CourierClient();

    @Test
    @DisplayName("Registration without Login")
    @Description("Проверка регистрации курьера только с полем Login")
    public void courierDoubleRegistrationOnlyLoginTest() {
        Courier courier = Courier.getRandomLogin();
        String createWithoutData = courierClient.createWithoutData(courier);

        assertEquals( "Ответ метода отличается", "Недостаточно данных для создания учетной записи", createWithoutData);

    }

    @Test
    @DisplayName("Registration without Password")
    @Description("Проверка регистрации курьера без поля Password")
    public void courierDoubleRegistrationWithoutEmailTest() {
        Courier courier = Courier.getRandomLoginAndFirstName();
        String createWithoutData = courierClient.createWithoutData(courier);

        assertEquals( "Ответ метода отличается", "Недостаточно данных для создания учетной записи", createWithoutData);

    }

    @Test
    @DisplayName("Registration without FirstName")
    @Description("Проверка регистрации курьера без поля FirstName")
    public void courierDoubleRegistrationWithoutFirstNameTest() {
        Courier courier = Courier.getRandomLoginAndPassword();
        boolean createWithoutFirstName = courierClient.create(courier);

        assertTrue(createWithoutFirstName);
    }
}
