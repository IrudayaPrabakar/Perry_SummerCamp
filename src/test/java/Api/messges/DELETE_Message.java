package Api.messges;

	import org.junit.jupiter.api.Test;
	import io.restassured.RestAssured;
	import static io.restassured.RestAssured.given;
	import static org.hamcrest.Matchers.*;

	public class DELETE_Message {

	    @Test
	    public void deleteMessageByIdTest() {
	        // Set base URI for the API
	        RestAssured.baseURI = "http://your-api-base-url.com";

	        // Define message ID to delete
	        String messageId = "uuid-of-message";

	        // Send DELETE request to delete the message by ID
	        given()
	            .pathParam("id", messageId)
	        .when()
	            .delete("/message/{id}")
	        .then()
	            .statusCode(204); // Assuming 204 No Content is the expected status code
	    }
	}


