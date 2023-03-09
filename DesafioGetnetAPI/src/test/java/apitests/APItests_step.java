package apitests;


import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class APItests_step {

    private String url = "https://reqres.in/api/users";

    @Test
    public void testPostUser() {
		final String json = "{\"name\": \"Diego Holanda\", \"job\": \"QA Engineer\"}";

		given()
				.contentType("application/json")
				.body(json)
				.when()
				.post(url)
				.then()
				.statusCode(201)
				.contentType("application/json")
				.body("name", equalTo("Diego Holanda"))
				.body("job", equalTo("QA Engineer"));
    }
}