package lms.StepDefinitions.stepDefinitionsProgram;

import static lms.Endpoints.ConstantFilePaths.GET_ALLPROGRAMID;
import static lms.Endpoints.ConstantFilePaths.DELETE_BY_PNAME;

import java.io.IOException;
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

public class ProgramDeleteByName {
	private RequestSpecification requestSpec;
	private Response response;
	@Given("Admin creates DELETE Request for the LMS API endpoint  and with valid programName for DeleteProgramByName for Program")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_with_valid_program_name_for_delete_program_by_name_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with endpoint  with valid programName for DeleteProgramByName for Program")
	public void admin_sends_https_request_with_endpoint_with_valid_program_name_for_delete_program_by_name_for_program() {
	    
		response = requestSpec
			    .when()
			    .pathParam("programName", PostReqProgram.createdProgramName)
			    .delete(DELETE_BY_PNAME)
			    .then()
			    .extract().response();
	}

	@Then("Admin receives TwoHundred Ok status with message for DeleteProgramByName for Program")
	public void admin_receives_two_hundred_ok_status_with_message_for_delete_program_by_name_for_program() {
		Assert.assertEquals(200, response.statusCode()); 
	    
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  invalid programName for DeleteProgramByName for Program")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_invalid_program_name_for_delete_program_by_name_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with endpoint  valid LMS API,invalid programName for DeleteProgramByName for Program")
	public void admin_sends_https_request_with_endpoint_valid_lms_api_invalid_program_name_for_delete_program_by_name_for_program() {
		response = requestSpec
			    .when()
			    .pathParam("programName", ProgramCRUDObject.getRandomProgramName(PostReqProgram.createdProgramName))
			    .delete(DELETE_BY_PNAME)
			    .then()
			    .extract().response();
		
	}

	@Then("Admin receives FourNotFour Not Found Status with message and boolean success details for DeleteProgramByName for Program")
	public void admin_receives_four_not_four_not_found_status_with_message_and_boolean_success_details_for_delete_program_by_name_for_program() {
		Assert.assertEquals(404, response.statusCode());
	    
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programName without Authorization for DeleteProgramByName for Program")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name_without_authorization_for_delete_program_by_name_for_program() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification();						
	}

	@When("Admin sends HTTPS Request with endpoint without Authorization for DeleteProgramByName for Program")
	public void admin_sends_https_request_with_endpoint_without_authorization_for_delete_program_by_name_for_program() {
		response = requestSpec
			    .when()
			    .pathParam("programName", PostReqProgram.createdProgramName)
			    .delete(DELETE_BY_PNAME)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourHundredOne Unauthorized for DeleteProgramByName for Program")
	public void admin_receives_four_hundred_one_unauthorized_for_delete_program_by_name_for_program() {
		Assert.assertEquals(401, response.statusCode());
	}


}
