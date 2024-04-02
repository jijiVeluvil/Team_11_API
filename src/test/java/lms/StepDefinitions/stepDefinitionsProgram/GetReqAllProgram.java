package lms.StepDefinitions.stepDefinitionsProgram;

import static lms.Endpoints.ConstantFilePaths.GET_ALLPROGRAM;
import static lms.Endpoints.ConstantFilePaths.GET_ALLPROGRAM_INVALID_ENDDPOINT;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;

import com.api.utilities.Program;

//import com.api.utilities.ProgramCRUDObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.StepDefinitions.UserLogin;
import lms.Utils.RestassuredExtension;


public class GetReqAllProgram {
	private RequestSpecification requestSpec;
	private Response response;
	public static Integer existingProgramID;
	public static List<Program> programList;
	
	@Given("Admin creates GET Request for the LMS API with valid Endpoint for GetReqAllProgram for Program .")
	public void admin_creates_get_request_for_the_lms_api_with_valid_endpoint_for_get_req_all_program_for_program() throws IOException {
	    requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    System.out.println("Token:    " +UserLogin.Admin_token);
	}

	@When("Admin sends HTTPS Request with valid endpoint for GetReqAllProgram for Program")
	public void admin_sends_https_request_with_valid_endpoint_for_get_req_all_program_for_program() {
	    
		response = requestSpec
			    .when()
			    .get(GET_ALLPROGRAM)
			    .then()
			    .extract().response();
		
		System.out.println(response.getBody().asPrettyString());
	}

	@Then("Admin receives TwoHundred OK Status with response body for Program for GetReqAllProgram for Program")
	public void admin_receives_two_hundred_ok_status_with_response_body_for_program_for_get_req_all_program_for_program() {
		JsonPath jsonPath = new JsonPath(response.getBody().asInputStream());
		List<Integer> list = jsonPath.getObject("programId", List.class);
		existingProgramID = list.get(0);
		programList = Arrays.asList(response.getBody().as(Program[].class));
		Assert.assertEquals(200, response.statusCode()); 
		Assert.assertNotEquals(response.getBody(), null);
		System.out.println(response.getBody().asPrettyString());
	    
	}

	@Given("Admin creates GET Request for the LMS API with invalid Endpoint for GetReqAllProgram for Program")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_endpoint_for_get_req_all_program_for_program() throws IOException {
	    
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with endpoint for Program with invalid Endpoint for GetReqAllProgram for Program")
	public void admin_sends_https_request_with_endpoint_for_program_with_invalid_endpoint_for_get_req_all_program_for_program() {
	    
		response = requestSpec
			    .when()
			    .get(GET_ALLPROGRAM_INVALID_ENDDPOINT)
			    .then()
			    .extract().response();
		
	}

	@Then("Admin receives FourNotFour not found  Status with error message for Program for GetReqAllProgram for Program")
	public void admin_receives_four_not_four_not_found_status_with_error_message_for_program_for_get_req_all_program_for_program() {
		Assert.assertEquals(404,response.statusCode()); 
		System.out.println(response.getBody().asPrettyString());
	    
	}

	@Given("Admin creates GET Request for the LMS API with invalid Method for GetReqAllProgram for Program")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_method_for_get_req_all_program_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
		
	}

	@When("Admin sends HTTPS Request with endpoint for programs with invalid Method for GetReqAllProgram for Program")
	public void admin_sends_https_request_with_endpoint_for_programs_with_invalid_method_for_get_req_all_program_for_program() {
		response = requestSpec
			    .when()
			    .put(GET_ALLPROGRAM)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourNotFive Method Not Allowed for Program with invalid Method for GetReqAllProgram for Program")
	public void admin_receives_four_not_five_method_not_allowed_for_program_with_invalid_method_for_get_req_all_program_for_program() {
	    
		Assert.assertEquals(405 , response.statusCode()); 
		System.out.println(response.getBody().asPrettyString());
	}

	@Given("Admin creates GET Request for the LMS API without Authorization for GetReqAllProgram for Program")
	public void admin_creates_get_request_for_the_lms_api_without_authorization_for_get_req_all_program_for_program() throws IOException {
		// Write code here that turns the phrase above into concrete actions
				File file = new File("src/test/resources/program.json");
				requestSpec = RestassuredExtension.getRequestSpecification()
						//.body(ProgramCRUDObject.getCreateProgramJson("Program-", "New Program", "Active"));
						.body(file);
	    
	}

	@When("Admin sends HTTPS Request with endpoint for Program without Authorization for GetReqAllProgram for Program")
	public void admin_sends_https_request_with_endpoint_for_program_without_authorization_for_get_req_all_program_for_program() {
	    
		response = requestSpec
			    .when()
			    .get(GET_ALLPROGRAM)
			    .then()
			    .extract().response();
		
		
	}

	@Then("Admin receives TwoHundredOne Status with response body as Unauthorized for GetReqAllProgram for Program")
	public void admin_receives_two_hundred_one_status_with_response_body_as_unauthorized_for_get_req_all_program_for_program() {
	    
		Assert.assertEquals(401, response.statusCode()); 
	}

}
