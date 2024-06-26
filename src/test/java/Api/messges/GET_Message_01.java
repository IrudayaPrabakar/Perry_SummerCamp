package Api.messges;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GET_Message_01 {
	@Test
    public void getAllMessagesBetweenUsersTest() {
        // Set base URI for the API
        RestAssured.baseURI = "http://your-api-base-url.com";

        // Define query parameters
        String fromUserId = "fromUserId";
        String toUserId = "toUserId";

        // Send GET request to retrieve messages between two users
        given()
            .queryParam("from", fromUserId)
            .queryParam("to", toUserId)
            .contentType(ContentType.JSON)
        .when()
            .get("/message")
        .then()
            .statusCode(200) // Assuming 200 OK is the expected status code
            .contentType(ContentType.JSON)
            .body("$.size()", greaterThan(0)) // Ensure at least one message is returned
            .body("from.id", everyItem(equalTo(fromUserId))) // Check every 'from' id matches fromUserId
            .body("to.id", everyItem(equalTo(toUserId))); // Check every 'to' id matches toUserId
    }
}

