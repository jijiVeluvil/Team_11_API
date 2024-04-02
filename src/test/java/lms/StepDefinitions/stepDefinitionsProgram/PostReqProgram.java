package lms.StepDefinitions.stepDefinitionsProgram;

import static lms.Endpoints.ConstantFilePaths.SAVE_PROGRAM;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.junit.Assert;

import com.api.utilities.Program;
import com.api.utilities.ProgramCRUDObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.StepDefinitions.UserLogin;
import lms.Utils.RestassuredExtension;

public class PostReqProgram {
	private RequestSpecification requestSpec;
	private Response response;
	private RequestSpecification requestSpecForId;
	private Response responseForId;
	public static String createdProgramName;
	public static int createdProgramId;
	public static Program programForName;
	public static Program programForId;
	
	@Given("Admin creates POST Request for the LMS with request body with Authorization for PostReqProgram .")
	public void admin_creates_post_request_for_the_lms_with_request_body_with_authorization_for_post_req_program() throws IOException {
		String str = new String(
                Files.readAllBytes(Paths.get("src/test/resources/program.json")));
		JSONObject jsonObj =  new JSONObject(str);
		jsonObj.put("programName", ProgramCRUDObject.getRandomProgramName("Program-"));
		
		requestSpec = RestassuredExtension.getRequestSpecification()
				.body(jsonObj.toString())
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with Authorization  for PostReqProgram.")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_authorization_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		response = requestSpec
			    .when()
			    .post(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives twohundredOne Created Status with response body for PostReqProgram.")
	public void admin_receives_twohundred_one_created_status_with_response_body_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		createdProgramName = response.path("programName");
		programForName = response.getBody().as(Program.class);
		Assert.assertEquals(response.statusCode(), 201); 
		Assert.assertNotEquals(response.getBody(), null);
	}

	@Given("Admin creates POST Request for the LMS with request body with Authorization for PostReqProgram ID .")
	public void admin_creates_post_request_for_the_lms_with_request_body_with_authorization_for_post_req_program_id() throws IOException {
		String str = new String(
                Files.readAllBytes(Paths.get("src/test/resources/program.json")));
		JSONObject jsonObj =  new JSONObject(str);
		jsonObj.put("programName", ProgramCRUDObject.getRandomProgramName("Program-"));
		requestSpecForId = RestassuredExtension.getRequestSpecification()
				.body(jsonObj.toString())
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with Authorization  for PostReqProgram ID.")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_authorization_for_post_req_program_id() {
		responseForId = requestSpecForId
			    .when()
			    .post(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives twohundredOne Created Status with response body for PostReqProgram ID.")
	public void admin_receives_twohundred_one_created_status_with_response_body_for_post_req_program_id() {
		Assert.assertEquals(201, responseForId.statusCode()); 
		createdProgramId = responseForId.path("programId");
		programForId = responseForId.getBody().as(Program.class);
	}

	@Given("Check if Admin able to create a program with valid endpoint and request body without Authorization for PostReqProgram")
	public void check_if_admin_able_to_create_a_program_with_valid_endpoint_and_request_body_without_authorization_for_post_req_program() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		File file = new File("src/test/resources/program.json");
		requestSpec = RestassuredExtension.getRequestSpecification()
				.body(file);
	}

	@When("Admin creates POST Request for the LMS with request body for PostReqProgram with no Auth")
	public void admin_creates_post_request_for_the_lms_with_request_body_for_post_req_program_with_no_auth() {
	    // Write code here that turns the phrase above into concrete actions
		response = requestSpec
			    .when()
			    .post(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin sends HTTPS Request and  request Body with endpoint	Admin receives fourNotOne Unauthorized for PostReqProgram")
	public void admin_sends_https_request_and_request_body_with_endpoint_admin_receives_four_not_one_unauthorized_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(), 401); 
	}

	@Given("Admin creates POST Request for the LMS with request body invalid endpoint for PostReqProgram")
	public void admin_creates_post_request_for_the_lms_with_request_body_invalid_endpoint_for_post_req_program() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		File file = new File("src/test/resources/program.json");
		requestSpec = RestassuredExtension.getRequestSpecification()
				.body(file)
				.header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with invalid endpoint for PostReqProgram")
	public void admin_sends_https_request_and_request_body_with_invalid_endpoint_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		response = requestSpec
			    .when()
			    .post(SAVE_PROGRAM + "/wrongpath")
			    .then()
			    .extract().response();
	}

	@Then("Admin receives fourNotFour not found  Status with message and boolean success details for PostReqProgram")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(), 404);
	}

	@Given("Admin creates POST Request for the LMS with request body with already existing program name for PostReqProgram")
	public void admin_creates_post_request_for_the_lms_with_request_body_with_already_existing_program_name_for_post_req_program() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		requestSpec = RestassuredExtension.getRequestSpecification()
				.body(ProgramCRUDObject.getCreateProgramJsonForExisting(createdProgramName, "New Program", "Active"))
				.header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with already existing program name for PostReqProgram")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_already_existing_program_name_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		response = requestSpec
			    .when()
			    .post(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives fourhundred Bad Request Status with message and boolean success details for PostReqProgram")
	public void admin_receives_fourhundred_bad_request_status_with_message_and_boolean_success_details_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(), 400);
	}

	@Given("Admin creates POST Request for the LMS with request body with invalid method for PostReqProgram")
	public void admin_creates_post_request_for_the_lms_with_request_body_with_invalid_method_for_post_req_program() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		File file = new File("src/test/resources/program.json");
		requestSpec = RestassuredExtension.getRequestSpecification()
				.body(file)
				.header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint for PostReqProgram with invalid method")
	public void admin_sends_https_request_and_request_body_with_endpoint_for_post_req_program_with_invalid_method() {
	    // Write code here that turns the phrase above into concrete actions
		response = requestSpec
			    .when()
			    .get(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives  fourNotFive Method Not Allowed with invalid method for PostReqProgram")
	public void admin_receives_four_not_five_method_not_allowed_with_invalid_method_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(), 405);
	}


	@Given("Admin creates POST Request for the LMS with invalid request body ith invalid request body  for Program")
	public void admin_creates_post_request_for_the_lms_with_invalid_request_body_ith_invalid_request_body_for_program() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		requestSpec = RestassuredExtension.getRequestSpecification()
				.body("")
				.header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint for PostReqProgram with invalid request body")
	public void admin_sends_https_request_and_request_body_with_endpoint_for_post_req_program_with_invalid_request_body() {
	    // Write code here that turns the phrase above into concrete actions
		response = requestSpec
			    .when()
			    .post(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives fourhundred Bad Request Status with invalid request body for PostReqProgram for PostReqProgram")
	public void admin_receives_fourhundred_bad_request_status_with_invalid_request_body_for_post_req_program_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(), 400);
	}

	@Given("Admin creates POST Request for the LMS with request body with missing values in the request body for PostReqProgram")
	public void admin_creates_post_request_for_the_lms_with_request_body_with_missing_values_in_the_request_body_for_post_req_program() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		File file = new File("src/test/resources/program_missingvalue.json");
		requestSpec = RestassuredExtension.getRequestSpecification()
				.body(file)
				.header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with missing values in the request body for PostReqProgram")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_missing_values_in_the_request_body_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		response = requestSpec
			    .when()
			    .post(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives fourhundred Bad Request Status  with missing values in the request body for PostReqProgram")
	public void admin_receives_fourhundred_bad_request_status_with_missing_values_in_the_request_body_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(), 400);
	}

	@Given("Admin creates POST Request for the LMS with request body for PostReqProgram")
	public void admin_creates_post_request_for_the_lms_with_request_body_for_post_req_program() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		File file = new File("src/test/resources/program_missing_addField.json");
		requestSpec = RestassuredExtension.getRequestSpecification()
//				.body("{\r\n"
//						+ "  \"programDescription\": \"\",\r\n"
//						+ "  \"programName\": \"programName12345\",\r\n"
//						+ "  \"programStatus\": \"Active\"\r\n"
//						+ "}\r\n"
//						+ "")
				.body(file)
				.header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint with missing additional field for PostReqProgram")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_missing_additional_field_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		response = requestSpec
			    .when()
			    .post(SAVE_PROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives twohundredOne ok for Program for PostReqProgram")
	public void admin_receives_twohundred_one_ok_for_program_for_post_req_program() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(201, response.statusCode()); 
		Assert.assertNotEquals(response.getBody(), null);
	}
}
