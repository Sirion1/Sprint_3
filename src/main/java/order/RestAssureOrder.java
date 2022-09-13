package order;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RestAssureOrder {
    protected static final String URL = "https://qa-scooter.praktikum-services.ru/api/v1";
    protected static final RequestSpecification reqSpec = given()
            .header("Content-Type", "application/json")
            .baseUri (URL);
}
