package courier;

public class CourierClient extends RestAssureClient {


    private final String ROOT = "/courier";
    private final String LOGIN = ROOT +"/login";
    private final String DELETE = ROOT + "/{courierId}";

    public boolean create(Courier courier) {
        return reqSpec
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("ok");
    }

    public String createDouble(Courier courier) {
        return reqSpec
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(409)
                .extract()
                .path("message");
    }
    public String createWithoutData(Courier courier) {
        return reqSpec
                .body(courier)
                .when()
                .post(ROOT)
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");
    }

    public int login(CourierCredentials creds) {
        return reqSpec
                .body(creds)
                .when()
                .post(LOGIN)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");
    }

    public String loginWithoutData (CourierCredentials creds) {
        return reqSpec
                .body(creds)
                .when()
                .post(LOGIN)
                .then().log().all()
                .assertThat()
                .statusCode(400)
                .extract()
                .path("message");
    }

    public String loginWithIncorrectData(CourierCredentials creds) {
        return reqSpec
                .body(creds)
                .when()
                .post(LOGIN)
                .then().log().all()
                .assertThat()
                .statusCode(404)
                .extract()
                .path("message");
    }
    public void delete(int courierId) {
        reqSpec
                .pathParam("courierId", courierId)
                .when()
                .delete(DELETE)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");
    }
}
