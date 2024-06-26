Here I am telling how to run you test script and a brief description of what I have tested.


First: POST /message
Create a message
Explanation:
Setup:

RestAssured.baseURI is set to your API base URL (http://your-api-base-url.com).
Query Parameters:

fromUserId and toUserId are used as query parameters to specify which messages to retrieve.
Sending GET Request:

given() starts building the request specification.
.queryParam("from", fromUserId) and .queryParam("to", toUserId) add query parameters to the request.
.contentType(ContentType.JSON) sets the content type of the request (although typically not necessary for GET requests, it's good practice to ensure consistency).
Performing Assertions:

.when().get("/message") sends a GET request to the /message endpoint with the specified query parameters.
.then().statusCode(200) asserts that the response status code should be 200 OK, assuming this is the expected status code when retrieving messages successfully.



Second: GET /message?from=fromUserId&to=toUserId
Get all the messages sent between two users.

Explanation:
Setup:

RestAssured.baseURI is set to your API base URL (http://your-api-base-url.com).
Query Parameters:

fromUserId and toUserId are used as query parameters (from and to) to specify which messages to retrieve.
Sending GET Request:

given() starts building the request specification.
.queryParam("from", fromUserId) and .queryParam("to", toUserId) add query parameters to the request.
.contentType(ContentType.JSON) sets the content type of the request (although typically not necessary for GET requests, it's good practice to ensure consistency).
Performing Assertions:

.when().get("/message") sends a GET request to the /message endpoint with the specified query parameters.
.then().statusCode(200) asserts that the response status code should be 200 OK, assuming this is the expected status code when retrieving messages successfully.
.contentType(ContentType.JSON) ensures that the response content type is JSON.
.body("$.size()", greaterThan(0)) checks that the response contains at least one message.
.body("from.id", everyItem(equalTo(fromUserId))) and .body("to.id", everyItem(equalTo(toUserId))) verify that every message's from id matches fromUserId and every message's to id matches toUserId.


Three: Explanation:
GET /message/:id
Get a message by id

Setup:

RestAssured.baseURI is set to your API base URL (http://your-api-base-url.com).
Path Parameter:

messageId is used as a path parameter (id) to specify which message to retrieve.
Sending GET Request:

given() starts building the request specification.
.pathParam("id", messageId) adds the path parameter to the request URL.
.contentType(ContentType.JSON) sets the content type of the request (although typically not necessary for GET requests, it's good practice to ensure consistency).
Performing Assertions:

.when().get("/message/{id}") sends a GET request to the /message/{id} endpoint with the specified message ID.
.then().statusCode(200) asserts that the response status code should be 200 OK, assuming this is the expected status code when retrieving a specific message successfully.
.contentType(ContentType.JSON) ensures that the response content type is JSON.
.body("id", equalTo(messageId)) checks if the returned message ID matches the requested ID.
.body("from.id", notNullValue()) and .body("to.id", notNullValue()) ensure that from.id and to.id fields are not null in the returned message.
.body("message", equalTo("text content of the message")) verifies the message content.


Four: PUT /message/:id
Update a message by id


Explanation:
Setup:

RestAssured.baseURI is set to your API base URL (http://your-api-base-url.com).
Request Body:

requestBody is a JSON string representing the message payload for the POST request, including from, to, message, id, and time fields.
Sending POST Request:

given() starts building the request specification.
.contentType(ContentType.JSON) sets the content type of the request body to JSON.
.body(requestBody) attaches the JSON request body to the request.
.when().post("/message") sends a POST request to the /message endpoint to create the message.
.then().statusCode(201) asserts that the response status code should be 201 Created, assuming this is the expected status code when a message is successfully created.
.extract().path("id") extracts the id field from the response and stores it in messageId.
Sending GET Request:

given() starts building the request specification for the GET request to retrieve the message by its ID.
.pathParam("id", messageId) adds the messageId as a path parameter (id) to the request URL.
.contentType(ContentType.JSON) sets the content type of the request (although typically not necessary for GET requests, it's good practice to ensure consistency).
.when().get("/message/{id}") sends a GET request to the /message/{id} endpoint with the specified message ID.
.then().statusCode(200) asserts that the response status code should be 200 OK, assuming this is the expected status code when retrieving a specific message successfully.
.body("id", equalTo(messageId)) checks if the returned message ID matches the messageId obtained from the POST request.
.body("from.id", equalTo("fromUserId")), .body("to.id", equalTo("toUserId")), and .body("message", equalTo("text content of the message")) verify the returned message content matches the expected values.


Five: DELETE /message/:id
Delete a message by id

Explanation:
Setup:

RestAssured.baseURI is set to your API base URL (http://your-api-base-url.com).
Request Body:

requestBody is a JSON string representing the updated message payload for the PUT request, including from, to, message, id, and time fields.
Sending PUT Request:

given() starts building the request specification.
.pathParam("id", messageId) adds the messageId as a path parameter (id) to the request URL.
.contentType(ContentType.JSON) sets the content type of the request body to JSON.
.body(requestBody) attaches the JSON request body to the request.
.when().put("/message/{id}") sends a PUT request to the /message/{id} endpoint to update the message.
.then().statusCode(200) asserts that the response status code should be 200 OK, assuming this is the expected status code when updating a message successfully.
