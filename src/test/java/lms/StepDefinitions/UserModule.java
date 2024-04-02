package lms.StepDefinitions;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import lms.Endpoints.ConstantFilePaths;
import lms.Payload.UpdateRoleIdPayload;
import lms.Payload.UpdateRoleStatusPayload;
import lms.Payload.UpdateUserLoginStatusPayload;
import lms.Payload.UpdateUserPayLoad;
import lms.Payload.UpdateUserProgramBatchPayload;
import lms.Payload.UserPayload;
import lms.Requestbody.UpdateRoleStatusRequestBody;
import lms.Requestbody.UpdateUserBody;
import lms.Requestbody.UpdateUserLoginStatusRequestbody;
import lms.Requestbody.UpdateUserProgramBatchRequestbody;
import lms.Requestbody.UpdateUserRoleIDRequestBody;
import lms.Requestbody.UserModuleBody;
import lms.StepDefinitions.stepDefinitionsProgram.PostReqProgram;
import lms.Utils.RestassuredExtension;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserModule {
	
	public static Response response;
	public static String UserId;
	public static Logger log = LogManager.getLogger();
	public static String batchIdString=String.valueOf(BatchModule.batchId);
	public static String progIdString=String.valueOf(PostReqProgram.createdProgramId);
	public static String tokenUser=UserLogin.Admin_token;
	
	
	@Given("Admin sets authorization to bearer token")
	public void admin_sets_authorization_to_bearer_token() {
	    RestassuredExtension.requestWithAuth(tokenUser);
	    

	}
//post_01	
	@When("Admin sends HTTPS Post request with only mandatory fields and valid end point")
	public void admin_sends_https_post_request_with_only_mandatory_fields_and_valid_end_point() {
		UserModuleBody userbody = new UserModuleBody();
		List<UserPayload> allrows = userbody.requestBody(ConstantFilePaths.UERMODULE_EXCELDATA,
				ConstantFilePaths.EXCEL_DATA_QUERRY_1);
		ObjectMapper mapper = new ObjectMapper();
		
		for (UserPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.CREATE_USERS_WITH_ROLES,
						requestBody);
		
				response.getBody().jsonPath().get("userId");
				UserId = response.body().path("userId");
				System.out.println("User Id for the req with only mandatory fields :" + UserId);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}

	@Then("Admin receives {int} Created status with response body")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		response.then().statusCode(int1);
		response.then().log().body();
//Schema Validation		
		response.then().assertThat()
		.body(JsonSchemaValidator
		.matchesJsonSchema(new File(ConstantFilePaths.POST_USER_JSON)));
	}

//post_02
	
	@When("Admin sends HTTPS Post request with all fields and valid end point")
	public void admin_sends_https_post_request_with_all_fields_and_valid_end_point() {
		UserModuleBody userbody = new UserModuleBody();
		List<UserPayload> allrows = userbody.requestBody(ConstantFilePaths.UERMODULE_EXCELDATA,
				ConstantFilePaths.EXCEL_DATA_QUERRY_2);
		ObjectMapper mapper = new ObjectMapper();

		for (UserPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.CREATE_USERS_WITH_ROLES,
						requestBody);
				UserId = response.body().path("userId");
				System.out.println("User Id for the req with all fields :" + UserId);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}		

	}
//post_03
	@When("Admin sends HTTPS Post request with invalid values and valid end point")
	public void admin_sends_https_post_request_with_invalid_values_and_valid_end_point() {
		UserModuleBody userbody = new UserModuleBody();
		List<UserPayload> allrows = userbody.requestBody(ConstantFilePaths.UERMODULE_EXCELDATA,
				ConstantFilePaths.EXCEL_DATA_QUERRY_3);
		ObjectMapper mapper = new ObjectMapper();
		
		for (UserPayload eachRow : allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.CREATE_USERS_WITH_ROLES,
						requestBody);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}
//post_04
	@When("Admin sends HTTPS Post request with missing mandatory fields and valid end point")
	public void admin_sends_https_post_request_with_missing_mandatory_fields_and_valid_end_point() {
		UserModuleBody userbody = new UserModuleBody();
		List<UserPayload> allrows = userbody.requestBody(ConstantFilePaths.UERMODULE_EXCELDATA,
				ConstantFilePaths.EXCEL_DATA_QUERRY_4);
		ObjectMapper mapper = new ObjectMapper();
		
		for (UserPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.CREATE_USERS_WITH_ROLES,
						requestBody);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}
//post_05
	@When("Admin sends HTTPS Post request with all fields and without authorization")
	public void admin_sends_https_post_request_with_all_fields_and_without_authorization() {
		UserModuleBody userbody = new UserModuleBody();
		List<UserPayload> allrows = userbody.requestBody(ConstantFilePaths.UERMODULE_EXCELDATA,
				ConstantFilePaths.EXCEL_DATA_QUERRY_5);
		ObjectMapper mapper = new ObjectMapper();
	
		for (UserPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.CREATE_USERS_WITH_ROLES,
						requestBody);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}

	
	//put request

	
	@When("Admin sends PUT Request with valid request body")
	public void admin_sends_put_request_with_valid_request_body() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserBody userbody = new UpdateUserBody();
		List<UpdateUserPayLoad> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		for(UpdateUserPayLoad eachRow: allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_BY_ID_ENDPOINT, requestBody, pathparam);
			/*	response.then().assertThat()
				.body(JsonSchemaValidator
				.matchesJsonSchema(new File(ConstantFilePaths.UPDATE_USER_SCHEMA_VALID)));*/
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	    
	}
	
	@When("Admin creates PUT Request with valid data in request body \\(values only in mandatory fields)")
	public void admin_creates_put_request_with_valid_data_in_request_body_values_only_in_mandatory_fields() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserBody userbody = new UpdateUserBody(); 
	  
		List<UpdateUserPayLoad> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA, ConstantFilePaths.UPDATE_USER_WITH_MANDATEFIELDS);
		ObjectMapper mapper = new ObjectMapper();
		for(UpdateUserPayLoad eachRow: allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println(requestBody);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_BY_ID_ENDPOINT, requestBody, pathparam);	    
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	    
	}
	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
		response.then().statusCode(int1);
        System.out.println("from missing cooments data " +response.getBody().asPrettyString());
	}

	@When("Admin creates PUT Request with invalid data in request body")
	public void admin_creates_put_request_with_invalid_data_in_request_body() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserBody userbody = new UpdateUserBody(); 
	    //userbody.Requestbodygetting(ConstantFilePaths.USER_MODULE_DATA, ConstantFilePaths.UPDATE_USER_WITH_MANDATEFIELDS);
		List<UpdateUserPayLoad> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA, ConstantFilePaths.UPDATE_USER_WITH_INVALID_FIELDS_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
	
		for(UpdateUserPayLoad eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println(requestBody);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_BY_ID_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	
	@When("Admin creates PUT Request with valid data and invalid AdminId in request body")
	public void admin_creates_put_request_with_valid_data_and_invalid_admin_id_in_request_body() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "248#");
		UpdateUserBody userbody = new UpdateUserBody();
		List<UpdateUserPayLoad> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateUserPayLoad eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_BY_ID_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

//Update ROleId Scenarios
	
	@When("Admin creates PUT Request with valid request body")
	public void admin_creates_put_request_with_valid_request_body() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserRoleIDRequestBody userbody = new UpdateUserRoleIDRequestBody();
		List<UpdateRoleIdPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateRoleIdPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println("first Scenario request body     ----  "+requestBody);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	

	@When("Admin creates PUT Request with invalid request body to Update RoleID")
	public void admin_creates_put_request_with_invalid_request_body_to_update_role_id() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserRoleIDRequestBody userbody = new UpdateUserRoleIDRequestBody();
		List<UpdateRoleIdPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_WITH_INVALID_VALUES_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
				for(UpdateRoleIdPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	

	@When("Admin creates PUT Request with request body with Invalid Admin Id")
	public void admin_creates_put_request_with_request_body_with_invalid_admin_id() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "u248");
		UpdateUserRoleIDRequestBody userbody = new UpdateUserRoleIDRequestBody();
		List<UpdateRoleIdPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateRoleIdPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	
	@When("Admin creates PUT Request with request body with invalid Endpoint")
	public void admin_creates_put_request_with_request_body_with_invalid_endpoint() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserRoleIDRequestBody userbody = new UpdateUserRoleIDRequestBody();
		List<UpdateRoleIdPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateRoleIdPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_INVALID_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	
// Roles Status Update
	@When("Admin creates PUT Request with valid data in request body")
	public void admin_creates_put_request_with_valid_data_in_request_body() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateRoleStatusRequestBody userbody = new UpdateRoleStatusRequestBody();
		List<UpdateRoleStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateRoleStatusPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@When("Admin creates PUT Request with invalid data in request body to update roleId Status")
	public void admin_creates_put_request_with_invalid_data_in_request_body_to_update_role_id_status() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateRoleStatusRequestBody userbody = new UpdateRoleStatusRequestBody();
		List<UpdateRoleStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_WITH_INVALID_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateRoleStatusPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	

	@When("Admin creates PUT Request with valid data in request body With Invalid AdminID")
	public void admin_creates_put_request_with_valid_data_in_request_body_with_invalid_admin_id() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "u248");
		UpdateRoleStatusRequestBody userbody = new UpdateRoleStatusRequestBody();
		List<UpdateRoleStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("***********************");
		for(UpdateRoleStatusPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}



	

	@When("Admin creates PUT Request with nonexisting\\/unassigned RoleID")
	public void admin_creates_put_request_with_nonexisting_unassigned_role_id() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateRoleStatusRequestBody userbody = new UpdateRoleStatusRequestBody();
		List<UpdateRoleStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_WITh_UNASSIGNED_ROLEID_QUERRYY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateRoleStatusPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@When("Admin creates PUT Request with valid data in request body with invalid Endpoint")
	public void admin_creates_put_request_with_valid_data_in_request_body_with_invalid_endpoint() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateRoleStatusRequestBody userbody = new UpdateRoleStatusRequestBody();
		List<UpdateRoleStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateRoleStatusPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_ROLEID_STATUS_INVALIDENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

//Login Status Update requests

	@When("Admin creates PUT Request with valid data in request body to update loginStatus")
	public void admin_creates_put_request_with_valid_data_in_request_body_to_update_login_status() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserLoginStatusRequestbody userbody = new UpdateUserLoginStatusRequestbody();
		List<UpdateUserLoginStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_LOGIN_STATUS_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		for(UpdateUserLoginStatusPayload eachRow: allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println("update login status -------     " +requestBody);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_LOGIN_STATUS_ENDPOINT, requestBody, pathparam);
			    log.info("update login status of response    "+response.asString());
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	@When("Admin creates PUT Request with invalid data in request body to update loginstatus")
	public void admin_creates_put_request_with_invalid_data_in_request_body_to_update_loginstatus() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserLoginStatusRequestbody userbody = new UpdateUserLoginStatusRequestbody();
		List<UpdateUserLoginStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_LOGIN_STATUS_WITH_INVALID_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateUserLoginStatusPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_LOGIN_STATUS_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}


	@When("Admin creates PUT Request to update login Status with valid data in request body and invalid AdmiId")
	public void admin_creates_put_request_to_update_login_status_with_valid_data_in_request_body_and_invalid_admi_id() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "u248");
		UpdateUserLoginStatusRequestbody userbody = new UpdateUserLoginStatusRequestbody();
		List<UpdateUserLoginStatusPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_LOGIN_STATUS_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateUserLoginStatusPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_LOGIN_STATUS_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}



	
	
	
	//Update User Program Batch

	
	@When("Admin creates PUT Request with valid data in request body to update program batch")
	public void admin_creates_put_request_with_valid_data_in_request_body_to_update_program_batch() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserProgramBatchRequestbody userbody = new UpdateUserProgramBatchRequestbody();
		List<UpdateUserProgramBatchPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		
		for(UpdateUserProgramBatchPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println("update program batch status -------     " +requestBody);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_ENDPOINT, requestBody, pathparam);
			    System.out.println("update user program batch id    "+response.asString());
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
	}

	

	@When("Admin creates PUT Request with invalid data in request body to update program and batch")
	public void admin_creates_put_request_with_invalid_data_in_request_body_to_update_program_and_batch() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserProgramBatchRequestbody userbody = new UpdateUserProgramBatchRequestbody();
		List<UpdateUserProgramBatchPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_INVALID_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("***********************");
		for(UpdateUserProgramBatchPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
			
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@When("Admin creates PUT Request with valid data and invalid Admin Id in request body to assign program and batch")
	public void admin_creates_put_request_with_valid_data_and_invalid_admin_id_in_request_body_to_assign_program_and_batch() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "u248");
		UpdateUserProgramBatchRequestbody userbody = new UpdateUserProgramBatchRequestbody();
		List<UpdateUserProgramBatchPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("***********************");
		for(UpdateUserProgramBatchPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
	}





	

	@When("Admin sends HTTPS Request with invalid endpoint to update program and Batch")
	public void admin_sends_https_request_with_invalid_endpoint_to_update_program_and_batch() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		UpdateUserProgramBatchRequestbody userbody = new UpdateUserProgramBatchRequestbody();
		List<UpdateUserProgramBatchPayload> allrows = userbody.Requestbody(ConstantFilePaths.USER_MODULE_DATA,
				ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("***********************");
		for(UpdateUserProgramBatchPayload eachRow: allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
			
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.UPDATE_USER_PROGRAM_BATCH_INVALID_ENDPOINT, requestBody, pathparam);
			    
				
			   } catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
	}
//get users with filters
	
	@When("Admin sends HTTPS Request with endpoint to get all admins with filter")
	public void admin_sends_https_request_with_endpoint_to_get_all_admins_with_filter() {
	    RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_USERS_WITH_FILTERS_ENDPOINT);
	    System.out.println("get all users with filters     " +ConstantFilePaths.GET_ALL_USERS_WITH_FILTERS_ENDPOINT);
	}
	
	
	@When("Admin sends HTTPS Request with Invalid endpoint to get all admins with filter")
	public void admin_sends_https_request_with_invalid_endpoint_to_get_all_admins_with_filter() {
	    RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_USERS_WITH_FILTERS_INVALID_ENDPOINT);
	}
	
	
	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() {
	    response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.All_USERS_WITH_ROLES_ENDPOINT);
	}

	@Then("Admin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		response.then().statusCode(int1);
     
	}
	
	@Given("Admin sets authorization to No  Auth.")
	public void admin_sets_authorization_to_no_auth() {
	    RestassuredExtension.requestWithNoAuth();
	}

	@Then("Admin receives status {int} with Unauthorized message.")
	public void admin_receives_status_with_unauthorized_message(Integer int1) {
		response.then().statusCode(int1);
       // System.out.println(response.getBody().asPrettyString());
	}
	@When("Admin sends HTTPS Request with invalid endpoint")
	public void admin_sends_https_request_with_invalid_endpoint() {
	    response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.ALL_USERS_WITH_ROLES_INVALID_ENDPOINT);
	}

	@Then("Admin receives status {int} with Not Found error message")
	public void admin_receives_status_with_not_found_error_message(Integer int1) {
		response.then().statusCode(int1);
       // System.out.println(response.getBody().asPrettyString());
	}
	
	
//Get_all_Roles
	@When("Admin sends HTTPS request with Get all roles endpoint")
	public void admin_sends_https_request_with_get_all_roles_endpoint() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ROLES);
	}
	@When("Admin sends HTTPS request with Get all roles invalid end point")
	public void admin_sends_https_request_with_Get_all_roles_invalid_end_point() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ROLES_INVALID_ENDPOINT);
	}
	
	//Get all Admin
	@When("Admin sends HTTPS request with Get all admins valid end point")
	public void admin_sends_https_request_with_Get_all_admins_valid_end_point() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ADMINS);
	}

	@When("Admin sends HTTPS request with Get all admins invalid end point")
	public void admin_sends_https_request_with_Get_all_admins_invalid_end_point() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ADMINS_INVALID_ENDPOINT);
	}
	
	//GetByUserId
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@When("Admin sends HTTPS request with valid Get by admin Id end point")
	public void admin_sends_https_request_with_valid_get_by_admin_id_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_USER_BY_ADMINID, pathparam);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. by valid admin Id : " + body.asString());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@When("Admin sends HTTPS request with invalid Get by admin Id end point")
	public void admin_sends_https_request_with_invalid_get_by_admin_id_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_USER_BY_ADMINID_INVALID_ENDPOINT,
				pathparam);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. by admin Id invalid endpoint  : " + body.asString());
	}
	@When("Admin sends HTTPS request with invalid admin Id and valid end point")
	public void admin_sends_https_request_with_invalid_admin_id_and_valid_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "V56");
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_USER_BY_ADMINID, pathparam);
		ResponseBody body = response.getBody();
	System.out.println("Response body of get req. by invalid admin Id : " + body.asString());
	}
	
	//GetAllActiveAdmins
	
	@When("Admin sends HTTPS request with Get all active admins end point")
	public void admin_sends_https_request_with_get_all_active_admins_end_point() {
		response=RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ACTIVE_ADMINS);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get all active admins : " + body.asString());
	}

	@When("Admin sends HTTPS request with invalid Get all active admins end point")
	public void admin_sends_https_request_with_invalid_get_all_active_admins_end_point() {
		response=RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ACTIVE_ADMINS_INVALID_ENDPOINT);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get all active admins with invalid end point : " + body.asString());
	}
	
	//Get Active and Inactive 
	
	@When("Admin sends HTTPS request with Get inactive and active end point")
	public void admin_sends_https_request_with_get_inactive_and_active_end_point() {
		response=RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ACT_INACT_ADMINS);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get all inactive and active  : " + body.asString());
	}

	@SuppressWarnings("rawtypes")
	@When("Admin sends HTTPS request with Get inactive and active invalid endpoint")
	public void admin_sends_https_request_with_get_inactive_and_active_invalid_endpoint() {
		RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_ALL_ACT_AND_INACT_ADMINS_INVALID_ENDPOINT);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get all act and inact admins with invalid end point : " + body.asString());
	}
//Get Active and Inactive by RoleId
	@When("Admin sends HTTPS request with valid role Id and Get inact and act admins by role id endpoint")
	public void admin_sends_https_request_with_valid_role_id_and_get_inact_and_act_admins_by_role_id_endpoint() {
		response=RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_INACT_AND_ACT_ADMINS_BY_ROLEID);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get inactive and active by role id  : " + body.asString());
	}

	@When("Admin sends HTTPS request with invalid role Id and Get inact and act admins by role id endpoint")
	public void admin_sends_https_request_with_invalid_role_id_and_get_inact_and_act_admins_by_role_id_endpoint() {
		response=RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.GET_INACT_AND_ACT_ADMINS_BY_INVALID_ROLEID);
	}
	
	//GET Admin by program batches with BatchID
	
	@When("Admin sends HTTPS request with valid batch Id and Get admin by program batches end point")
	public void admin_sends_https_request_with_valid_batch_id_and_get_admin_by_program_batches_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", batchIdString);
		System.out.println("From User MODULE__BATCH ID:"+pathparam.get("Id"));
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_PROG_BATCH, pathparam);
		ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get admin by batch id USER MODULE : " + body.asString());
	}

	@When("Admin sends HTTPS request with invalid batch Id and Get admin by program batches end point")
	public void admin_sends_https_request_with_invalid_batch_id_and_get_admin_by_program_batches_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "911");
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_PROG_BATCH, pathparam);
		
	}

	@When("Admin sends HTTPS request with Get admin by program batches invalid end point")
	public void admin_sends_https_request_with_get_admin_by_program_batches_invalid_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "9165");
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_PROG_BATCH_INVALID_ENDPOINT, pathparam);
	}

	
	//Get Admin By ProgramId
	
	@When("Admin sends HTTPS request with valid program Id and Get admin by program Id valid end point")
	public void admin_sends_https_request_with_valid_program_id_and_get_admin_by_program_id_valid_end_point() {
		
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", progIdString);
	    response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_PROG_ID, pathparam);
	    ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get admin by program id  : " + body.asString());
	}

	@When("Admin sends HTTPS request with invalid program Id and Get admin by program Id valid end point")
	public void admin_sends_https_request_with_invalid_program_id_and_get_admin_by_program_id_valid_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "1718");
	    response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_PROG_ID, pathparam);
	    ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get admin by invalid program id  : " + body.asString());
	}

	@When("Admin sends HTTPS request with valid program Id and Get admin by program Id invalid end point")
	public void admin_sends_https_request_with_valid_program_id_and_get_admin_by_program_id_invalid_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", progIdString);
	    response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_PROG_ID_INVALID_ENDPOINT, pathparam);
	    ResponseBody body = response.getBody();
		
	}
	
	//Get Admin by RoleID
	
	@When("Admin sends HTTPS request with valid role id and Get admin by role Id end point")
	public void admin_sends_https_request_with_valid_role_id_and_get_admin_by_role_id_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "R03");
	    response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_ROLE_ID, pathparam);
	    ResponseBody body = response.getBody();
		
	}

	@When("Admin sends HTTPS request with invalid role id and Get admin by role Id end point")
	public void admin_sends_https_request_with_invalid_role_id_and_get_admin_by_role_id_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "R05");
	    response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_ROLE_ID, pathparam);
	    ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get admin by invalid role id : " + body.asString());
	}

	@When("Admin sends HTTPS request with valid role id and Get admin by role Id invalid end point")
	public void admin_sends_https_request_with_valid_role_id_and_get_admin_by_role_id_invalid_end_point() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "R03");
	    response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_ADMIN_BY_ROLE_ID_INVALID_ENDPOINT, pathparam);
	    ResponseBody body = response.getBody();
		System.out.println("Response body of get req. to get admin by valid role id and invalid endpoint  : " + body.asString());
	}


	
	
	
	
	
	
	
	//delete user
	
	@When("Admin sends HTTPS request with endpoint to delete user")
	public void admin_sends_https_request_with_endpoint_to_delete_user() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", UserId);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.DELETE_USER_WITH_USERID_ENDPOINT, pathparam);
		System.out.println("delete the user with userID   " + response.asString());
	}

	@When("Admin sends HTTPS request with endpoiint to delete user with invalid UserId")
	public void admin_sends_https_request_with_endpoiint_to_delete_user_with_invalid_user_id() {
		Map<String, String> pathparam = new HashMap();
		pathparam.put("Id", "R678");
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.DELETE_USER_WITH_USERID_ENDPOINT, pathparam);
		System.out.println("delete the user with userID   " + response.asString());
	}
	
	
	
	
	









	












	












	
	
	


}
