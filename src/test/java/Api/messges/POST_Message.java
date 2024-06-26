package Api.messges;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class POST_Message {

		@Test
	    public void createMessageTest() {
	        // Set base URI for the API
	        RestAssured.baseURI = "http://your-api-base-url.com";

	        // Define the request body for creating a message
	        String requestBody = "{\n" +
	                "    \"from\": {\n" +
	                "        \"id\": \"fromUserId\"\n" +
	                "    },\n" +
	                "    \"to\": {\n" +
	                "        \"id\": \"toUserId\"\n" +
	                "    },\n" +
	                "    \"message\": \"text content of the message\",\n" +
	                "    \"id\": \"uuid-of-message\",\n" +
	                "    \"time\": \"2021-03-04T00:54:30.288Z\"\n" +
	                "}";

	        // Send POST request to create a message
	        given()
	           .contentType(ContentType.JSON)
	            .body(requestBody)
	        .when()
	            .post("/message")
	        .then()
	            .statusCode(201); // Assuming 201 Created is the expected status code
	    }
	}	


