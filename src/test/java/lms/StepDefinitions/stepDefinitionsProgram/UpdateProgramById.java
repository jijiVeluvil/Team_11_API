package lms.StepDefinitions.stepDefinitionsProgram;

import static lms.Endpoints.ConstantFilePaths.GET_ALLPROGRAMID_INVALID;
import static lms.Endpoints.ConstantFilePaths.UPDATE_BY_PID;
import static lms.StepDefinitions.stepDefinitionsProgram.PostReqProgram.*;

import java.io.IOException;
import java.util.Random;

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

public class UpdateProgramById {
	private RequestSpecification requestSpec;
	private Response response;

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields for UpdateProgramById for Program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields_for_update_program_by_id_for_program() throws IOException {
		 requestSpec = RestassuredExtension.getRequestSpecification()						
				    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with valid endpoint and valid request body  valid programID endpoint  and valid request body for UpdateProgramById for Program")
	public void admin_sends_https_request_with_valid_endpoint_and_valid_request_body_valid_program_id_endpoint_and_valid_request_body_for_update_program_by_id_for_program() {
	    
	    programForId.setProgramName(ProgramCRUDObject.getRandomProgramName(programForId.getProgramName()));
	    programForId.setProgramDescription("SDET Program Desc");
	    
	    System.out.println(programForId.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programId", programForId.getProgramId())
			    .body(programForId)
			    .put(UPDATE_BY_PID)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives TwoHundred OK Status with updated value in response body  valid programID endpoint  and valid request body for UpdateProgramById for Program")
	public void admin_receives_two_hundred_ok_status_with_updated_value_in_response_body_valid_program_id_endpoint_and_valid_request_body_for_update_program_by_id_for_program() {
		Assert.assertEquals(200, response.statusCode()); 
		Assert.assertNotEquals(response.getBody(), null);
		System.out.println(response.getBody().asPrettyString());
	}

	@Given("Admin creates PUT Request for the LMS API invalid programID endpoint with valid request Body with mandatory , additional  fields for UpdateProgramById for Program")
	public void admin_creates_put_request_for_the_lms_api_invalid_program_id_endpoint_with_valid_request_body_with_mandatory_additional_fields_for_update_program_by_id_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}
	
	@When("Admin sends HTTPS Request with invalid programID endpoint with valid request Body with mandatory , additional  fields for UpdateProgramById for Program")
	public void admin_sends_https_request_with_invalid_program_id_endpoint_with_valid_request_body_with_mandatory_additional_fields_for_update_program_by_id_for_program() {   
		
		programForId.setProgramName(ProgramCRUDObject.getRandomProgramName(programForId.getProgramName()));
	    programForId.setProgramDescription("SDET Program Desc");
	    
	    System.out.println(programForId.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programId", new Random().nextInt())
			    .body(programForId)
			    .put(UPDATE_BY_PID)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details for Program for invalid programID endpoint  and valid request body for UpdateProgramById for Program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_for_program_for_invalid_program_id_endpoint_and_valid_request_body_for_update_program_by_id_for_program() {
		Assert.assertEquals(404, response.statusCode()); 	    
	}

	@Given("Admin creates PUT Request for the LMS API  with invalid request body for UpdateProgramById for Program")
	public void admin_creates_put_request_for_the_lms_api_with_invalid_request_body_for_update_program_by_id_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));	    
	}

	@When("Admin sends HTTPS Request with invalid endpoint with invalid request body  wid invalid request body for UpdateProgramById for Program")
	public void admin_sends_https_request_with_invalid_endpoint_with_invalid_request_body_wid_invalid_request_body_for_update_program_by_id_for_program() {
		
		programForId.setProgramName(ProgramCRUDObject.getRandomProgramName(programForId.getProgramName()));
	    programForId.setProgramDescription("SDET Program Desc");
	    programForId.setProgramStatus("ProgramStatus");
	    
	    System.out.println(programForId.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programId", programForId.getProgramId())
			    .body(programForId)
			    .put(UPDATE_BY_PID)
			    .then()
			    .extract().response();	    
	}

	@Then("Admin receives FourHundredOne Bad Request Status with message and boolean success details with invalid request body for UpdateProgramById for Program")
	public void admin_receives_four_hundred_one_bad_request_status_with_message_and_boolean_success_details_with_invalid_request_body_for_update_program_by_id_for_program() {
		Assert.assertEquals(400, response.statusCode()); 
	}

	@Given("Admin creates PUT Request for the LMS API  with missing mandatory fields for UpdateProgramById for Program")
	public void admin_creates_put_request_for_the_lms_api_with_missing_mandatory_fields_for_update_program_by_id_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));	    
	}

	@When("Admin sends HTTPS Request with valid endpoint and with missing mandatory fields for UpdateProgramById for Program")
	public void admin_sends_https_request_with_valid_endpoint_and_with_missing_mandatory_fields_for_update_program_by_id_for_program() {
		
	    programForId.setProgramName(ProgramCRUDObject.getRandomProgramName(programForId.getProgramName()));
	    programForId.setProgramStatus("");
	    programForId.setProgramDescription("SDET Program Desc");
	    
	    
		response = requestSpec
			    .when()
			    .pathParam("programId", programForId.getProgramId())
			    .body(programForId)
			    .put(UPDATE_BY_PID)
			    .then()
			    .extract().response();	    
	}

	@Then("Admin receives FourHundredOne Bad Request Status with message and boolean success details without request body for UpdateProgramById for Program")
	public void admin_receives_four_hundred_one_bad_request_status_with_message_and_boolean_success_details_without_request_body_for_update_program_by_id_for_program() {
		Assert.assertEquals(400, response.statusCode()); 	    
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields with invalid baseURI  for UpdateProgramById for Program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields_with_invalid_base_uri_for_update_program_by_id_for_program() throws IOException {

		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with valid endpoint and with invalid baseURI for Program")
	public void admin_sends_https_request_with_valid_endpoint_and_with_invalid_base_uri_for_program() {
		
	    programForId.setProgramName(ProgramCRUDObject.getRandomProgramName(programForId.getProgramName()));
	    programForId.setProgramDescription("SDET Program Desc");
	    //Sys.out.println(programForId.toString());
		response = requestSpec
			    .when()
			    .pathParam("programId", programForId.getProgramId())
			    .body(programForId)
			    .put(GET_ALLPROGRAMID_INVALID)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details with invalid baseURI for UpdateProgramById for Program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_with_invalid_base_uri_for_update_program_by_id_for_program() {
		Assert.assertEquals(404, response.statusCode()); 	    
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body for UpdateProgramById for Program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_for_update_program_by_id_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with valid endpoint and invalid method for UpdateProgramById for Program")
	public void admin_sends_https_request_with_valid_endpoint_and_invalid_method_for_update_program_by_id_for_program() {
	    programForId.setProgramName(ProgramCRUDObject.getRandomProgramName(programForId.getProgramName()));
	    programForId.setProgramDescription("SDET Program Desc");
	    
	    System.out.println(programForId.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programId", programForId.getProgramId())
			    .body(programForId)
			    .get(UPDATE_BY_PID)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourNotFive Method Not Allowed for UpdateProgramById for Program")
	public void admin_receives_four_not_five_method_not_allowed_for_update_program_by_id_for_program() {
		Assert.assertEquals(405, response.statusCode()); 	    
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields and without Authorizationfor UpdateProgramById for Program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields_and_without_authorizationfor_update_program_by_id_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification();						
			    //.header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));	    
	}

	@When("Admin sends HTTPS Request with valid endpoint and without Authorization for UpdateProgramById for Program")
	public void admin_sends_https_request_with_valid_endpoint_and_without_authorization_for_update_program_by_id_for_program() {
	    programForId.setProgramName(ProgramCRUDObject.getRandomProgramName(programForId.getProgramName()));
	    programForId.setProgramDescription("SDET Program Desc");
	    
	    System.out.println(programForId.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programId", programForId.getProgramId())
			    .body(programForId)
			    .put(UPDATE_BY_PID)
			    .then()
			    .extract().response();	    
	}

	@Then("Admin receives FourHundredOne Unauthorized for UpdateProgramById for Program")
	public void admin_receives_four_hundred_one_unauthorized_for_update_program_by_id_for_program() {
		Assert.assertEquals(401, response.statusCode()); 	    
	}
	

}
