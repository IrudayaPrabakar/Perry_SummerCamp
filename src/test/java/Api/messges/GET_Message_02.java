package Api.messges;

	import org.junit.jupiter.api.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import static io.restassured.RestAssured.given;
	import static org.hamcrest.Matchers.*;

	public class GET_Message_02 {

	    @Test
	    public void getMessageByIdTest() {
	        // Set base URI for the API
	        RestAssured.baseURI = "http://your-api-base-url.com";

	        // Define message ID
	        String messageId = "uuid-of-message";

	        // Send GET request to retrieve a message by ID
	        given()
	            .pathParam("id", messageId)
	            .contentType(ContentType.JSON)
	        .when()
	            .get("/message/{id}")
	        .then()
	            .statusCode(200) // Assuming 200 OK is the expected status code
	            .contentType(ContentType.JSON)
	            .body("id", equalTo(messageId)) // Check if the returned message ID matches the requested ID
	            .body("from.id", notNullValue()) // Ensure 'from' id is not null
	            .body("to.id", notNullValue()) // Ensure 'to' id is not null
	            .body("message", equalTo("text content of the message")); // Check message content
	    }
	}


