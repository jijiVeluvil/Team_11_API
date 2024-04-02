package lms.StepDefinitions.stepDefinitionsProgram;

import static lms.Endpoints.ConstantFilePaths.GET_ALLPROGRAMID;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.Assert;

import com.api.utilities.Program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.Endpoints.ConstantFilePaths;
import lms.StepDefinitions.UserLogin;
import lms.Utils.RestassuredExtension; 

public class GetReqProgramID {
	private RequestSpecification requestSpec;
	private Response response;
	
	@Given("Admin creates GET Request for the LMS API with valid program for GetReqProgramID for program")
	public void admin_creates_get_request_for_the_lms_api_with_valid_program_for_get_req_program_id_for_program() throws IOException {
		 requestSpec = RestassuredExtension.getRequestSpecification()						
				    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with endpoint with valid program ID for post req Program for GetReqProgramID for program")
	public void admin_sends_https_request_with_endpoint_with_valid_program_id_for_post_req_program_for_get_req_program_id_for_program() {
		//System.out.println("********************************************* " + PostReqProgram.createdProgramId);
		response = requestSpec
			    .when()
			    .pathParam("programId", PostReqProgram.createdProgramId)
			    .get(GET_ALLPROGRAMID)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives TwoHundred OK Status with response body for post req Program for GetReqProgramID for program")
	public void admin_receives_two_hundred_ok_status_with_response_body_for_post_req_program_for_get_req_program_id_for_program() {
		Assert.assertEquals(200, response.statusCode()); 
		Assert.assertNotEquals(response.getBody(), null);
		System.out.println(response.getBody().asPrettyString());
	    
	}

	@Given("Admin creates GET Request for the LMS API with invalid program ID for post req Program for GetReqProgramID for program")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_program_id_for_post_req_program_for_get_req_program_id_for_program() throws IOException {
		 requestSpec = RestassuredExtension.getRequestSpecification()						
				    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with endpoint with invalid program ID for post req Program for GetReqProgramID for program")
	public void admin_sends_https_request_with_endpoint_with_invalid_program_id_for_post_req_program_for_get_req_program_id_for_program() throws IOException {
		//System.out.println("********************************************* " + PostReqProgram.createdProgramId);
		response = requestSpec
			    .when()
			    .pathParam("programId", PostReqProgram.createdProgramId + new Random().nextInt())
			    .get(GET_ALLPROGRAMID)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details for post req Program for GetReqProgramID for program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_for_post_req_program_for_get_req_program_id_for_program() {
		Assert.assertEquals(404, response.statusCode()); 
	    
	}

	@Given("Admin creates GET Request for the LMS API with invalid baseURI for GetReqProgramID for program")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_base_uri_for_get_req_program_id_for_program() throws IOException {
		 requestSpec = RestassuredExtension.getRequestSpecification()						
				    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with endpoint for post req Program with invalid baseURI for GetReqProgramID for program")
	public void admin_sends_https_request_with_endpoint_for_post_req_program_with_invalid_base_uri_for_get_req_program_id_for_program() {
		//System.out.println("********************************************* " + PostReqProgram.createdProgramId);
		response = requestSpec
			    .when()
			    .pathParam("programId", PostReqProgram.createdProgramId)
			    .get(ConstantFilePaths.GET_ALLPROGRAMID_INVALID)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details  due to  invalid baseURI for post req Program for GetReqProgramID for program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_due_to_invalid_base_uri_for_post_req_program_for_get_req_program_id_for_program() {
		Assert.assertEquals(404, response.statusCode()); 
	    
	}

	@Given("Admin creates GET Request for the LMS API without Authorization for GetReqProgramID for program")
	public void admin_creates_get_request_for_the_lms_api_without_authorization_for_get_req_program_id_for_program() throws IOException {
	    
		 requestSpec = RestassuredExtension.getRequestSpecification();						
	}

	@When("Admin sends HTTPS Request with endpoint for Program without Authorization for post req Program for GetReqProgramID for program")
	public void admin_sends_https_request_with_endpoint_for_program_without_authorization_for_post_req_program_for_get_req_program_id_for_program() {
		//System.out.println("********************************************* " + PostReqProgram.createdProgramId);
		response = requestSpec
			    .when()
			    .pathParam("programId", PostReqProgram.createdProgramId)
			    .get(GET_ALLPROGRAMID)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourHundredOne Unauthorized for Program for post req Program for GetReqProgramID for program")
	public void admin_receives_four_hundred_one_unauthorized_for_program_for_post_req_program_for_get_req_program_id_for_program() {
		Assert.assertEquals(401, response.statusCode()); 
	    
	}

	@Given("Admin creates GET Request for the LMS API with invalid Endpoint	 for Program for GetReqProgramID for program")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_endpoint_for_program_for_get_req_program_id_for_program() throws IOException {
		 requestSpec = RestassuredExtension.getRequestSpecification()						
				    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with endpoint with invalid Endpoint for post req Program for GetReqProgramID for program")
	public void admin_sends_https_request_with_endpoint_with_invalid_endpoint_for_post_req_program_for_get_req_program_id_for_program() {
		//System.out.println("********************************************* " + PostReqProgram.createdProgramId);
		response = requestSpec
			    .when()
			    .pathParam("programId", PostReqProgram.createdProgramId)
			    .get(ConstantFilePaths.GET_ALLPROGRAMID_INVALID)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details for GetReqProgramID for program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_for_get_req_program_id_for_program() {
	    
		Assert.assertEquals(404, response.statusCode()); 
		Assert.assertNotEquals(response.getBody(), null);
		System.out.println(response.getBody().asPrettyString());
	}


}
