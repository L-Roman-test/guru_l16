package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import settings.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemoWebShopTests extends TestBase {

    @Test
    void subscribeTest() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("email", "test@gg.com")
                .when()
                .post("/subscribenewsletter")
                .then()
                .statusCode(200)
                .body("Success", is(true));
    }

    @Test
    void addPhoneToWishList() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("addtocart_43.EnteredQuantity", "1")
                .when()
                .post("/addproducttocart/details/43/2")
                .then()
                .statusCode(200)
                .log().body()
                .body("success", is(true));
    }
}
