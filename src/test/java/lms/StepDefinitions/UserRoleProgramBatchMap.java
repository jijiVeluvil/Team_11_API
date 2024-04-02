package lms.StepDefinitions;

import java.util.HashMap;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import lms.Endpoints.ConstantFilePaths;
import lms.Utils.RestassuredExtension;

public class UserRoleProgramBatchMap {
	public static String userIdString=UserModule.UserId;
	public static Response response;
	@Given("Admin sets authorization to bearer token in UserRole_Program_BatchMap")
	public void admin_sets_authorization_to_bearer_token_in_user_role_program_batch_map() {
		RestassuredExtension.requestWithAuth(UserLogin.Admin_token);
	    System.out.println("token:  " + UserLogin.Admin_token);
	}

	@When("Admin sends HTTPS Request to retrieve all Admins assigned to program\\/batch in UserRoleBatchMap")
	public void admin_sends_https_request_to_retrieve_all_admins_assigned_to_program_batch_in_user_role_batch_map() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.USER_ROLE_PROGRAM_BATCH_MAP_ENDPOINT);
	}

	@Then("Admin receives {int} OK UserRoleMap")
	public void admin_receives_ok_user_role_map(Integer int1) {
		response.then().statusCode(int1);
        //System.out.println(response.getBody().asPrettyString());
	}

	@Given("Admin sets No authorization to bearer token in UserRole_Program_BatchMap")
	public void admin_sets_no_authorization_to_bearer_token_in_user_role_program_batch_map() {
		RestassuredExtension.requestWithNoAuth();
	}

	@Then("Admin receives status {int} with Unauthorized message UserRoleMap")
	public void admin_receives_status_with_unauthorized_message_user_role_map(Integer int1) {
		response.then().statusCode(int1);
        //System.out.println(response.getBody().asPrettyString());	
		}
	


	@When("Admin sends HTTPS Request to retrieve Admin assigned to Program\\/Batch by AdminId")
	public void admin_sends_https_request_to_retrieve_admin_assigned_to_program_batch_by_admin_id() {
		
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id",userIdString);
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_ID_ENDPOINT,batch_id);
		System.out.println("Getting User Id And User Role MAp Controller"+batch_id.get("Id"));
		
	}

	@When("Admin sends HTTPS Request  to retrieve Admin assigned to Program\\/Batch by invalid AdminID")
	public void admin_sends_https_request_to_retrieve_admin_assigned_to_program_batch_by_invalid_admin_id() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id","114567");
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_ID_ENDPOINT,batch_id); 
	}

	@Then("Admin receives {int} with Unauthorized message UserRoleMap")
	public void admin_receives_with_unauthorized_message_user_role_map(Integer int1) {
		response.then().statusCode(int1);
        //System.out.println(response.getBody().asPrettyString());	
	}

	@Then("Admin receives status {int} with Unauthorized message")
	public void admin_receives_status_with_unauthorized_message(Integer int1) {
		response.then().statusCode(int1);
        System.out.println(response.getBody().asPrettyString());	
	}

	@When("Admin sends HTTPS Request to delete Admin assigned to program/batch by valid AdminId")
	public void admin_sends_https_request_to_delete_admin_assigned_to_program_batch_by_admin_id() {
		HashMap<String, String> pathParam = new HashMap<>();
		pathParam.put("Id",userIdString);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.USER_ROLE_PROGRAM_BATCH_MAP_BY_ADMIN_ID_DELETE_ENDPOINT,pathParam); 
	}

	@When("Admin sends HTTPS Reques to delete Admin assigned to program\\/batch by invalid AdminId")
	public void admin_sends_https_reques_to_delete_admin_assigned_to_program_batch_by_invalid_admin_id() {
		HashMap<String, String> pathParam = new HashMap<>();
		pathParam.put("Id","671197");
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.USER_ROLE_PROGRAM_BATCH_MAP_BY_ADMIN_ID_DELETE_ENDPOINT,pathParam); 
	}

	@When("Admin sends HTTPS Request to delete Admin assigned to program\\/batch by valid AdminId")
	public void admin_sends_https_request_to_delete_admin_assigned_to_program_batch_by_valid_admin_id() {
		HashMap<String, String> pathParam = new HashMap<>();
		pathParam.put("Id",userIdString);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.USER_ROLE_PROGRAM_BATCH_MAP_BY_ADMIN_ID_DELETE_ENDPOINT,pathParam); 
	}


	}


