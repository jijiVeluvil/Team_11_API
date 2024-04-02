package lms.StepDefinitions.stepDefinitionsProgram;

import static lms.Endpoints.ConstantFilePaths.DELETE_BY_PID;

import java.io.IOException;
import java.util.Random;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.StepDefinitions.UserLogin;
import lms.Utils.RestassuredExtension;

public class ProgramDeleteByID {
	private RequestSpecification requestSpec;
	private Response response;
	@Given("Admin creates DELETE Request for the LMS API endpoint and with  valid programID for DeleteProgramById for Program .")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_with_valid_program_id_for_delete_program_by_id_for_program() throws IOException {
	    
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("Admin sends HTTPS Request with endpoint for Program with valid programID for DeleteProgramById for Program")
	public void admin_sends_https_request_with_endpoint_for_program_with_valid_program_id_for_delete_program_by_id_for_program() {
		//Syst.out.println("********************************************* " + PostReqProgram.createdProgramId);
		response = requestSpec
			    .when()
			    .pathParam("programId", PostReqProgram.createdProgramId)
			    .delete(DELETE_BY_PID)
			    .then()
			    .extract().response(); 
	    
	}

	@Then("Admin receives TwoHundred Ok status with message for DeleteProgramById for that Program")
	public void admin_receives_two_hundred_ok_status_with_message_for_delete_program_by_id_for_that_program() {
		Assert.assertEquals(200, response.statusCode()); 
	    
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  invalid programID for DeleteProgramById for Program .")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_id_for_delete_program_by_id_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with endpoint for Program with valid LMS API,invalid programID for DeleteProgramById for Program")
	public void admin_sends_https_request_with_endpoint_for_program_with_valid_lms_api_invalid_program_id_for_delete_program_by_id_for_program() {
		response = requestSpec
			    .when()
			    .pathParam("programId", new Random().nextInt())
			    .delete(DELETE_BY_PID)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details for DeleteProgramById for Program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_for_delete_program_by_id_for_program() {
		Assert.assertEquals(404, response.statusCode()); 
	    
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programID without Authorization for DeleteProgramById for Program")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id_without_authorization_for_delete_program_by_id_for_program() throws IOException {
	    
		requestSpec = RestassuredExtension.getRequestSpecification();						
	}

	@When("Admin sends HTTPS Request with endpoint for Program without Authorization for DeleteProgramBy Id for Program")
	public void admin_sends_https_request_with_endpoint_for_program_without_authorization_for_delete_program_by_id_for_program() {
	    
		//Syst.out.println("********************************************* " + PostReqProgram.createdProgramId);
		response = requestSpec
			    .when()
			    .pathParam("programId", PostReqProgram.createdProgramId)
			    .delete(DELETE_BY_PID)
			    .then()
			    .extract().response(); 
	}

	@Then("Admin receives FourHundredOne Unauthorized for DeleteProgramById for Program")
	public void admin_receives_four_hundred_one_unauthorized_for_delete_program_by_id_for_program() {
		Assert.assertEquals(401, response.statusCode()); 
	    
	}


}
