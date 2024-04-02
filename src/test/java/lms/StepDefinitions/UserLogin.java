package lms.StepDefinitions;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lms.Endpoints.ConstantFilePaths;
import lms.Utils.RestassuredExtension;

public class UserLogin {
	Map<String,String> data = new HashMap<String,String>();
	public static ResponseOptions<Response> response;
	
	RequestSpecification request;
	ValidatableResponse valid_resp;
	public static String Admin_token="";
	
	@Given("Admin creates POST Request  with valid credentials for login.")
	public <val> void admin_creates_post_request_with_valid_credentials_for_login(DataTable dataTable) {
		data.put("password", dataTable.cell(1, 1));
		data.put("userLoginEmailId", dataTable.cell(1, 0));
		
	}

	@When("Admin creates Post Https method  with valid endpoint for login.")
	public void admin_creates_post_https_method_with_valid_endpoint_for_login() {
		
		response = RestassuredExtension.PostOpsWithBody(ConstantFilePaths.USER_LOGIN_ENDPOINT, data);
   	 
	}

	@Then("Admin User receives the bearer token for login.")
	public void admin_user_receives_the_bearer_token_for_login() {
		response.getBody().jsonPath().get("token");
		
		Admin_token = response.body().path("token");
		System.out.println("Token:    "+Admin_token);
	
	}
	@When("Admin calls Post Https method with invalid endpoint for login")
	public void admin_calls_post_https_method_with_invalid_endpoint_for_login() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.USER_LOGIN_INVALID_ENDPOINT);
	}
	@Then("Admin receives {int} unauthorized for login")
	public void admin_receives_unauthorized_for_login_for_login(Integer int1) {
		response.thenReturn().statusCode();
        //System.out.println(response.getBody().asPrettyString());
	}
	@Given("Admin creates POST request with out Email")
	public void admin_creates_post_request_with_out_email(DataTable dataTable) {
		data.put("password", dataTable.cell(1, 1));
	    
	}
	@Given("Admin creates POST request with out Password")
	public void admin_creates_post_request_with_out_password(DataTable dataTable) {
		data.put("userLoginEmailId", dataTable.cell(1, 0));
	}

	@Given("Admin creates POST request with out fields for login")
	public void admin_creates_post_request_with_out_fields_for_login(DataTable dataTable) {
	    
	}
	
	@Then("Admin receives {int} Bad request for login")
	public void admin_receives_bad_request_for_login(Integer int1) {
		response.thenReturn().statusCode();
        //System.out.println(response.getBody().asPrettyString());
	}


}
