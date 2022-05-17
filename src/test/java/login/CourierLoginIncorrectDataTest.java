package login;

import courier.Courier;
import courier.CourierClient;
import courier.CourierCredentials;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CourierLoginIncorrectDataTest {
    private CourierClient courierClient = new CourierClient() ;

    @Before
    public void setup(){
    }
    Courier courier = Courier.getRandom();

    @Test
    @NotNull
    @DisplayName("Login Courier With Incorrect Data")
    @Description("Авторизация курьера с неверными данными")
    public void courierLoginWithIncorrectData() {
        String loginWithIncorrectData = courierClient.loginWithIncorrectData(CourierCredentials.from(courier));

        assertEquals( "Ответ метода отличается", "Учетная запись не найдена", loginWithIncorrectData);

    }
}






