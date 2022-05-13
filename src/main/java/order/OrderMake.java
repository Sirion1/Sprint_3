package order;


public class OrderMake extends RestAssureOrder {

    public static final String MAKE_ORDER = "/orders";
    public static final String LIST_OF_ORDER = "/orders";
    public static final String CANCEL_ORDER = MAKE_ORDER + "/cancel";
    public static final String INCORRECT_ID_GET_ORDERS = "/orders?courierId=000000001";

    public static int make(Order order) {
        return reqSpec
                .body(order)
                .when()
                .post(MAKE_ORDER)
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("track");
    }
    public static boolean cancel(int track) {
        return reqSpec
                .queryParam("track", String.valueOf(track))
                .when()
                .put(CANCEL_ORDER)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("ok");
    }
    public static String getOrder(OrderList getOrderList) {
        return reqSpec
                .body(getOrderList)
                .when()
                .get(LIST_OF_ORDER)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("order");
    }

    public static String getOrderIncorrectId(OrderList getOrderListIncorrectId) {
        return reqSpec
                .body(getOrderListIncorrectId)
                .when()
                .get(INCORRECT_ID_GET_ORDERS)
                .then().log().all()
                .assertThat()
                .statusCode(404)
                .extract()
                .path("message");
    }

}
