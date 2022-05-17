package Login;

import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class CourierLoginIncorrectDataTest {
    private CourierClient courierClient;

    @Before
    public void setup(){
        courierClient = new CourierClient();
    }

    @Test
    @NotNull
    @DisplayName("Login Courier With Incorrect Data")
    @Description("Авторизация курьера с неверными данными")
    public void courierLoginWithIncorrectData() {
        Courier courier = Courier.getRandom();
        String loginWithIncorrectData = courierClient.loginWithIncorrectData(CourierCredentials.from(courier));

        assertNotNull(loginWithIncorrectData);
    }
}






