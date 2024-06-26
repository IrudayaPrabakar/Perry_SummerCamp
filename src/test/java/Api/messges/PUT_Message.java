package Api.messges;


	import org.junit.jupiter.api.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import static io.restassured.RestAssured.given;
	import static org.hamcrest.Matchers.*;

	public class PUT_Message {
	    @Test
	    public void updateMessageByIdTest() {
	        // Set base URI for the API
	        RestAssured.baseURI = "http://your-api-base-url.com";

	        // Define the message JSON payload for PUT request
	        String updatedMessage = "updated text content of the message";
	        String updatedTime = "2024-06-26T10:15:00.000Z"; // Updated time

	        // Define message ID to update
	        String messageId = "uuid-of-message";

	        // Define the updated message JSON payload
	        String requestBody = "{\n" +
	                "    \"from\": {\n" +
	                "        \"id\": \"fromUserId\"\n" +
	                "    },\n" +
	                "    \"to\": {\n" +
	                "        \"id\": \"toUserId\"\n" +
	                "    },\n" +
	                "    \"message\": \"" + updatedMessage + "\",\n" +
	                "    \"id\": \"" + messageId + "\",\n" +
	                "    \"time\": \"" + updatedTime + "\"\n" +
	                "}";

	        // Send PUT request to update the message by ID
	        given()
	            .pathParam("id", messageId)
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	        .when()
	            .put("/message/{id}")
	        .then()
	            .statusCode(200); // Assuming 200 OK is the expected status code
	    }


}
