package lms.StepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import lms.Endpoints.ConstantFilePaths;
import lms.Utils.RestassuredExtension;

public class UserLogOut {
	public static Response response;
	@Given("Admin creates request with authorization for LogOut")
	public void admin_creates_request_with_authorization_for_log_out() {
		 RestassuredExtension.requestWithAuth(UserLogin.Admin_token);
		    //System.out.println("token:  " + UserLogin.Admin_token);

	}

	@When("Admin calls Get Https method with valid endpoint")
	public void admin_calls_get_https_method_with_valid_endpoint() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.USER_LOGOUT_ENDPOINT);
	}

	@Then("Admin receives {int} ok  and response with {string}")
	public void admin_receives_ok_and_response_with(Integer int1, String string) {
		response.then().statusCode(int1);
        //System.out.println(response.getBody().asPrettyString());
	}

	

	@When("Admin calls Get Https method withinvalid endpoint")
	public void admin_calls_get_https_method_withinvalid_endpoint() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.USER_LOGOUT_INVALID_ENDPOINT);
	}

	@Then("Admin receives {int} Not found for logout")
	public void admin_receives_not_found_for_logout(Integer int1) {
		response.then().statusCode(int1);
        //System.out.println(response.getBody().asPrettyString());
	}

	@Given("Admin creates request without no authorization")
	public void admin_creates_request_without_no_authorization() {
		RestassuredExtension.requestWithNoAuth();
	}

	@Then("Admin receives {int}  unauthorized forlogut")
	public void admin_receives_unauthorized_forlogut(Integer int1) {
		response.then().statusCode(int1);
        //System.out.println(response.getBody().asPrettyString());
	}




}
