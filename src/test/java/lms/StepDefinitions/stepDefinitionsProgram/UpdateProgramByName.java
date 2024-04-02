package lms.StepDefinitions.stepDefinitionsProgram;
import static lms.Endpoints.ConstantFilePaths.*;
import static lms.StepDefinitions.stepDefinitionsProgram.PostReqProgram.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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

public class UpdateProgramByName {
	private RequestSpecification requestSpec;
	private Response response;
	
	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields for UpdateProgramByName for program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fields_for_update_program_by_name_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with valid endpoint and with  Valid program Name and request body for UpdateProgramByName for program")
	public void admin_sends_https_request_with_valid_endpoint_and_with_valid_program_name_and_request_body_for_update_program_by_name_for_program() {
		
		
		System.out.println("Before " + programForName.toString());
		programForName.setProgramDescription("SDET Program Desc");
	    System.out.println("After " + programForName.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", programForName.getProgramName())
			    .body(programForName)
			    .put(UPDATE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives TwoHundred OK Status with updated value in response body for UpdateProgramByName for program")
	public void admin_receives_two_hundred_ok_status_with_updated_value_in_response_body_for_update_program_by_name_for_program() {
		Assert.assertEquals(200, response.statusCode()); 
		Assert.assertNotEquals(response.getBody(), null);
		System.out.println(response.getBody().asPrettyString());
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields with  invalid program Name and request body for UpdateProgramByName for program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fields_with_invalid_program_name_and_request_body_for_update_program_by_name_for_program() throws IOException {
		
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with invalid endpoint with  invalid program Name and request body for UpdateProgramByName for program")
	public void admin_sends_https_request_with_invalid_endpoint_with_invalid_program_name_and_request_body_for_update_program_by_name_for_program() {
	    
		
		System.out.println("Before " + programForName.toString());
		
		programForName.setProgramDescription("SDET Program Desc");
	    
	    System.out.println("After " + programForName.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", ProgramCRUDObject.getRandomProgramName(programForName.getProgramName()))
			    .body(programForName)
			    .put(UPDATE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details for UpdateProgramByName for program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_for_update_program_by_name_for_program() {
	    
		Assert.assertEquals(404, response.statusCode()); 
	}

	@Given("Admin creates PUT Request for the LMS API  with missing mandatory fields for UpdateProgramByName for program")
	public void admin_creates_put_request_for_the_lms_api_with_missing_mandatory_fields_for_update_program_by_name_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with valid endpoint with missing mandatory fields for UpdateProgramByName for program")
	public void admin_sends_https_request_with_valid_endpoint_with_missing_mandatory_fields_for_update_program_by_name_for_program() {
	    
		
		System.out.println("Before " + programForName.toString());
		
		programForName.setProgramDescription("SDET Program Desc");
		programForName.setProgramStatus("");
	    
	    System.out.println("After " + programForName.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", programForName.getProgramName())
			    .body(programForName)
			    .put(UPDATE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourHundred Bad Request Status with message and boolean success details with missing mandatory fields for UpdateProgramByName for program")
	public void admin_receives_four_hundred_bad_request_status_with_message_and_boolean_success_details_with_missing_mandatory_fields_for_update_program_by_name_for_program() {
	    
		Assert.assertEquals(400, response.statusCode()); 
	}

	@Given("Admin creates PUT Request for the LMS API endpoint  and  invalid program Name with  invalid values in request body for UpdateProgramByName for program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_invalid_program_name_with_invalid_values_in_request_body_for_update_program_by_name_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request  and  request Body with mandatory fields. program Description , program Name, program status for UpdateProgramByName for program")
	public void admin_sends_https_request_and_request_body_with_mandatory_fields_program_description_program_name_program_status_for_update_program_by_name_for_program() {
	    
		
		System.out.println("Before " + programForName.toString());
		
		programForName.setProgramDescription("SDET Program Desc");
		programForName.setProgramStatus(null);
	    System.out.println("After " + programForName.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", programForName.getProgramName())
			    .body(programForName)
			    .put(UPDATE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourHundred Bad Request Status with message and boolean success details for UpdateProgramByName for program")
	public void admin_receives_four_hundred_bad_request_status_with_message_and_boolean_success_details_for_update_program_by_name_for_program() {
	    
		Assert.assertEquals(400, response.statusCode()); 
	}

	@Given("Admin creates PUT Request for the LMS API endpoint  and  invalid program Description for UpdateProgramByName for program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_invalid_program_description_for_update_program_by_name_for_program() throws IOException {
	    
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request  and  request Body with mandatory fields.invalid program Description , program Name, program status for UpdateProgramByName for program")
	public void admin_sends_https_request_and_request_body_with_mandatory_fields_invalid_program_description_program_name_program_status_for_update_program_by_name_for_program() {
	    
		
		System.out.println("Before " + programForName.toString());
		
		programForName.setProgramDescription(null);
	    
	    System.out.println("After " + programForName.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", programForName.getProgramName())
			    .body(programForName)
			    .put(UPDATE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourHundred Bad Request Status with message and boolean success details with  invalid program Description for UpdateProgramByName for program")
	public void admin_receives_four_hundred_bad_request_status_with_message_and_boolean_success_details_with_invalid_program_description_for_update_program_by_name_for_program() {
	    
		Assert.assertEquals(400, response.statusCode()); 
	}

	@Given("Admin creates PUT Request for the LMS API endpoint and Valid program Name and status for UpdateProgramByName for program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_valid_program_name_and_status_for_update_program_by_name_for_program() throws IOException {
	    
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with valid endpoint with  Valid program Name and status for UpdateProgramByName for program")
	public void admin_sends_https_request_with_valid_endpoint_with_valid_program_name_and_status_for_update_program_by_name_for_program() {
	    
		
		System.out.println("Before " + programForName.toString());
		
		programForName.setProgramDescription("SDET Program Desc");
		programForName.setProgramStatus("Active");
	    System.out.println("After " + programForName.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", programForName.getProgramName())
			    .body(programForName)
			    .put(UPDATE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives TwoHundred OK Status with updated value in response body  and Valid program Name and status for UpdateProgramByName for program")
	public void admin_receives_two_hundred_ok_status_with_updated_value_in_response_body_and_valid_program_name_and_status_for_update_program_by_name_for_program() {
	    
		Assert.assertEquals(200, response.statusCode()); 
		Assert.assertNotEquals(response.getBody(), null);
		System.out.println(response.getBody().asPrettyString());
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields without Authorization for UpdateProgramByName for program")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields_without_authorization_for_update_program_by_name_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification();					
	    
	}

	@When("Admin sends HTTPS Request with valid endpoint	without Authorization for UpdateProgramByName for program")
	public void admin_sends_https_request_with_valid_endpoint_without_authorization_for_update_program_by_name_for_program() {
	    
		
		System.out.println("Before " + programForName.toString());
		programForName.setProgramDescription("SDET Program Desc");
	    System.out.println("After " + programForName.toString());
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", programForName.getProgramName())
			    .body(programForName)
			    .put(UPDATE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives FourHundredOne Unauthorized msg for UpdateProgramByName for program")
	public void admin_receives_four_hundred_one_unauthorized_msg_for_update_program_by_name_for_program() {
	    
		Assert.assertEquals(401, response.statusCode()); 
	}


}
