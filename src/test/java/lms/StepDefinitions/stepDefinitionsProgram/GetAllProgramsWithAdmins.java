package lms.StepDefinitions.stepDefinitionsProgram;

import static lms.Endpoints.ConstantFilePaths.GET_ALLPROGRAM;
import static lms.Endpoints.ConstantFilePaths.GET_ALLPROGRAM_INVALID_ENDDPOINT;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.api.utilities.Program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.StepDefinitions.UserLogin;
import lms.Utils.RestassuredExtension;

public class GetAllProgramsWithAdmins {
	private RequestSpecification requestSpec;
	private Response response;
	public static Integer existingProgramID;
	public static List<Program> programList;

	@Given("Admin creates GET Request for the LMS API for Program with valid endpoint for Get All Programs With Admins")
	public void admin_creates_get_request_for_the_lms_api_for_program_with_valid_endpoint_for_get_all_programs_with_admins() throws IOException {
	    
				    requestSpec = RestassuredExtension.getRequestSpecification()						
				    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
		   System.out.println("Token:    " +UserLogin.Admin_token);
	}

	@When("Admin sends HTTPS Request with valid endpoint	 for Program for Get All Programs With Admins")
	public void admin_sends_https_request_with_valid_endpoint_for_program_for_get_all_programs_with_admins() {
		response = requestSpec
			    .when()
			    .get(GET_ALLPROGRAM)
			    .then()
			    .extract().response();
		
		//System.out.println(response.getBody().asPrettyString());
	    
	}

	@Then("Admin receives TwoHundred OK Status with response body for Program for Get All Programs With Admins.")
	public void admin_receives_two_hundred_ok_status_with_response_body_for_program_for_get_all_programs_with_admins() {
		JsonPath jsonPath = new JsonPath(response.getBody().asInputStream());
		List<Integer> list = jsonPath.getObject("programId", List.class);
		existingProgramID = list.get(0);
		//programList = Arrays.asList(response.getBody().as(Program[].class));
		Assert.assertEquals(200, response.statusCode()); 
		//Assert.assertNotEquals(response.getBody(), null);
		
	    
	}

	@Given("Admin creates GET Request for the LMS API with invalid Endpoint for Program for Get All Program With Admins")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_endpoint_for_program_for_get_all_program_with_admins() throws IOException {
	    
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	}

	@When("sends HTTPS Request  with invalid Endpoint  for Get All Programs With Admins")
	public void sends_https_request_with_invalid_endpoint_for_get_all_programs_with_admins() {
		response = requestSpec
			    .when()
			    .get(GET_ALLPROGRAM_INVALID_ENDDPOINT)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourNotFour Not Found Status with error message for Program for Get All Programs With Admins")
	public void admin_receives_four_not_four_not_found_status_with_error_message_for_program_for_get_all_programs_with_admins() {
		Assert.assertEquals(404,response.statusCode());
	    
	}

	@Given("Admin creates GET Request for the LMS API	with invalid Method for Program for GetAllProgramsWithAdmins")
	public void admin_creates_get_request_for_the_lms_api_with_invalid_method_for_program_for_get_all_programs_with_admins() throws IOException {
		requestSpec = RestassuredExtension.getRequestSpecification()						
			    .header(RestassuredExtension.getTokenHeader(UserLogin.Admin_token));
	    
	}

	@When("Admin sends HTTPS Request with endpoint  with invalid Method for Get All Programs With Admins")
	public void admin_sends_https_request_with_endpoint_with_invalid_method_for_get_all_programs_with_admins() {
		response = requestSpec
			    .when()
			    .put(GET_ALLPROGRAM)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourNotFive Method Not Allowed for Program for Get All Programs With Admins")
	public void admin_receives_four_not_five_method_not_allowed_for_program_for_get_all_programs_with_admins() {
		Assert.assertEquals(405 , response.statusCode()); 
	    
	}

	@Given("Admin creates GET Request for the LMS API without Authorization for Program for Get All Programs With Admins")
	public void admin_creates_get_request_for_the_lms_api_without_authorization_for_program_for_get_all_programs_with_admins() throws IOException {
		File file = new File("src/test/resources/program.json");
		requestSpec = RestassuredExtension.getRequestSpecification()
				//.body(ProgramCRUDObject.getCreateProgramJson("Program-", "New Program", "Active"));
				.body(file);
	    
	}

	@When("Admin sends HTTPS Request with endpoint for  program without Authorization for Get All Programs With Admins")
	public void admin_sends_https_request_with_endpoint_for_program_without_authorization_for_get_all_programs_with_admins() {
		response = requestSpec
			    .when()
			    .get(GET_ALLPROGRAM)
			    .then()
			    .extract().response();
	    
	}

	@Then("Admin receives FourHundredOne Status with response body as Unauthorized for Program for Get AllPrograms With Admins")
	public void admin_receives_four_hundred_one_status_with_response_body_as_unauthorized_for_program_for_get_all_programs_with_admins() {
	    
		Assert.assertEquals(401, response.statusCode()); 
	}
	
	
}
