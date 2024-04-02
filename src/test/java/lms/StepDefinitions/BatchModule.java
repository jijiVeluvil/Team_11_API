package lms.StepDefinitions;

import java.util.HashMap;
import java.io.File;
import java.nio.file.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import lms.Endpoints.ConstantFilePaths;
import lms.Payload.BatchPayload;
import lms.Requestbody.BatchNegativeBodyRequest;
import lms.Requestbody.BatchRequestBody;
import lms.StepDefinitions.stepDefinitionsProgram.PostReqProgram;
import lms.Utils.RestassuredExtension;

public class BatchModule {
	public static Response response;
	public static int batchId;
	public static String BatchId = String.valueOf(batchId);
	public static String batchName;
	public static String progIdString=String.valueOf(PostReqProgram.createdProgramId);
	
	

	@Given("Admin sets authorization to bearer token in batchmodule")
	public void admin_sets_authorization_to_bearer_token_in_batchmodule() {
		RestassuredExtension.requestWithAuth(UserLogin.Admin_token);
	}

	@When("Admin sends HTTPS Request with endpoint to get all Batches")
	public void admin_sends_https_request_with_endpoint_to_get_all_batches() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.ALL_BATCHES_WITH_ENDPOINTS);
	}

	@Then("Admin receives {int} OK Status with response body for all batches.")
	public void admin_receives_ok_status_with_response_body_for_all_batches(Integer int1) {
		response.then().statusCode(int1);
	}

	@When("Admin sends HTTPS Request with invalid endpoint for all batch")
	public void admin_sends_https_request_with_invalid_endpoint_for_all_batch() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.ALL_BATCHES_WITH_INVALIDENDPOINTS);
	}

	@Then("Admin receives {int} status with error message Not Found .")
	public void admin_receives_status_with_error_message_not_found(Integer int1) {
		response.then().statusCode(int1);
	
	}
	
	  @When("Admin creates GET Request with search string") 
	  
	  public void admin_creates_get_request_with_search_string() { 
		  HashMap<String, String> queryParam = new HashMap<>();
		  queryParam.put("Id", "abgfddf");
			response = RestassuredExtension.getWithPathParram(ConstantFilePaths.BATCH_SEARCH_STRING, queryParam);

	   }
	  
	  
	  @Then("Admin receives {int} Ok status with response body") 
	  public void admin_receives_ok_status_with_response_body(Integer int1) {
	 response.then().statusCode(int1);
	 }


	@Given("Admin creates get request with out AuthoriZation")
	public void admin_creates_get_request_with_out_authori_zation() {
		RestassuredExtension.requestWithNoAuth();
	}

	@Then("Admin receives {int} status with error message Unauthorized.")
	public void admin_receives_status_with_error_message_unauthorized(Integer int1) {
		response.then().statusCode(int1);
		System.out.println("UnAuthoriZed Body" + response.getBody().asPrettyString());
	}

	@Given("Admin creates GET Request with valid Batch ID")
	public void admin_creates_get_request_with_valid_batch_id() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", BatchId);
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_ID_ENDPOINT, batch_id);
	}

	@Then("Admin receives {int} OK Status with  batchStatus field {string} in the response body.")
	public void admin_receives_ok_status_with_batch_status_field_in_the_response_body(Integer int1, String string) {
		response.then().statusCode(int1);
		System.out.println("OK Status" + response.getBody().asPrettyString());
	}

	@Given("Admin creates GET Request with invalid Batch ID")
	public void admin_creates_get_request_with_invalid_batch_id() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", "85164563d");
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_ID_ENDPOINT, batch_id);
	}

	@Then("Admin receives {int} Not Found Status with message and boolean success details")
	public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {

		response.thenReturn().statusCode();
		System.out.println("Not Found" + response.getBody().asPrettyString());
	}

	@Then("Admin receives {int} not found  Status")
	public void admin_receives_not_found_status(Integer int1) {
		response.then().statusCode(int1);
		System.out.println("Not Found Status" + response.getBody().asPrettyString());

	}

	@When("Admin sends HTTPS Request with invalid endpoint for batchId")
	public void admin_sends_https_request_with_invalid_endpoint_for_batch_id() {
		response = RestassuredExtension.getAllRequestWithEndpoint(ConstantFilePaths.ALL_BATCHES_WITH_INVALIDENDPOINTS);
	}

	@Given("Admin creates GET Request with batch Name")
	public void admin_creates_get_request_with_batch_name() {
		HashMap<String, String> batch_name = new HashMap<>();
		batch_name.put("Id", batchName);
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_ID_ENDPOINT,
				batch_name);
	}

	@Given("Admin creates GET Request with invalid Batch Name")
	public void admin_creates_get_request_with_invalid_batch_name() {
		HashMap<String, String> batch_name = new HashMap<>();
		batch_name.put("Id", "Kubernetes_Intelij_Eclips_Jsoup");
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_ID_ENDPOINT,
				batch_name);
	}

	@Given("Admin creates GET Request with program id")
	public void admin_creates_get_request_with_program_id() {
		HashMap<String, String> program_id = new HashMap<>();
		program_id.put("Id",progIdString);
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_PROGRA_ID_ENDPOINT,
				program_id);
	}

	@Given("Admin creates GET Request with invalid Program Id")
	public void admin_creates_get_request_with_invalid_program_id() {
		HashMap<String, String> program_id = new HashMap<>();
		program_id.put("Id", "678354674");
		response = RestassuredExtension.getWithPathParram(ConstantFilePaths.GET_BATCH_WITH_PROGRA_ID_ENDPOINT,
				program_id);

	}

	@Given("Admin creates GET Request with invalid endpoint")
	public void admin_creates_get_request_with_invalid_endpoint() {
		response = RestassuredExtension
				.getAllRequestWithEndpoint(ConstantFilePaths.GET_BATCH_WITH_INVALID_PROGRA_ID_ENDPOINT);
	}

//Put Request
	@When("Admin creates PUT Request with valid BatchId and Data")
	public void admin_creates_put_request_with_valid_batch_id_and_data() {
		Map<String, String> pathparam = new HashMap<>();
		pathparam.put("Id", BatchId);
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY);
		ObjectMapper mapper = new ObjectMapper();
		for (BatchPayload eachRow : allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.PUT_BATCH_WITH_BATCH_ID_ENDPOINT,
						requestBody, pathparam);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

		
	}

	@When("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		response.then().statusCode(int1);
	}

	@Given("Admin creates PUT Request with Invalid BatchId and Data")
	public void admin_creates_put_request_with_invalid_batch_id_and_valid_data() {
		Map<String, String> pathparam = new HashMap<>();
		pathparam.put("Id", "851634");
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY1);
		ObjectMapper mapper = new ObjectMapper();

		for (BatchPayload eachRow : allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.PUT_BATCH_WITH_BATCH_ID_ENDPOINT,
						requestBody, pathparam);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}

	@When("Admin creates PUT Request with valid batch Id and missing mandatory fields")
	public void admin_creates_put_request_with_valid_batch_id_and_missing_mandatory_fields() {
		Map<String, String> pathparam = new HashMap<>();
		pathparam.put("Id", BatchId);
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY2);
		ObjectMapper mapper = new ObjectMapper();

		for (BatchPayload eachRow : allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);

				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.PUT_BATCH_WITH_BATCH_ID_ENDPOINT,
						requestBody, pathparam);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}

	}

	@When("Admin creates PUT Request with invalida dataforBatch")
	public void admin_creates_put_request_with_invalida_data() {
		Map<String, String> pathparam = new HashMap<>();
		BatchNegativeBodyRequest batchNegativeBodyRequest = new BatchNegativeBodyRequest();
		List<BatchPayload> allrows = batchNegativeBodyRequest.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY3);

		ObjectMapper mapper = new ObjectMapper();

		for (BatchPayload eachRow : allrows) {
			try {
				pathparam.put("Id", "" + eachRow.getBatchId());
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.putRequestStringBody(ConstantFilePaths.PUT_BATCH_WITH_BATCH_ID_ENDPOINT,
						requestBody, pathparam);

			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	// PostRequest******
	@When("Admin creates POST Request  with valid data in request body")
	public void admin_creates_post_request_with_valid_data_in_request_body() {
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY4);
		ObjectMapper mapper = new ObjectMapper();
		for (BatchPayload eachRow : allrows) {
			try {

				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.ALL_BATCHES_WITH_ENDPOINTS,
						requestBody);
				response.getBody().jsonPath().get("batchId");
				batchId = response.body().path("batchId");
				System.out.println("Batch Id for the req with only mandatory fields BATCH MODULE :" + batchId);
				

				response.getBody().jsonPath().get("batchName");
				batchName = response.body().path("batchName");
				System.out.println("Batch Name for the req with only mandatory fields  BATCH MODULE:" + batchName);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@When("Admin creates POST Request  with valid data in request body existing Value")
	public void admin_creates_post_request_with_valid_data_in_request_body_existing_value() {
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY4);
		ObjectMapper mapper = new ObjectMapper();
		for (BatchPayload eachRow : allrows) {
			try {

				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.ALL_BATCHES_WITH_ENDPOINTS,
						requestBody);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Then("Admin receives {int} Created Status with response body for schemavalidation")
	public void admin_receives_created_status_with_response_body_for_schemavalidation(Integer int1) {
		response.then().statusCode(int1);
		response.then().log().body();
		// Schema Validation
		System.out.println("  -------   " + response.getBody().asPrettyString());

		response.then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(new File(ConstantFilePaths.POST_BATCH_SCHEMA_FILE_PATH)));
	}

	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		response.thenReturn().statusCode();
		System.out.println(response.getBody().asPrettyString());
	}
	@Then("Admin receives {int} Bad Request Status with message and boolean success details")
	public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
		response.then().statusCode(int1);
        System.out.println("With Invalid data " +response.getBody().asPrettyString());
	}

	@When("Admin creates POST Request  with missing mandatory fields in request body")
	public void admin_creates_post_request_with_missing_mandatory_fields_in_request_body() {
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY5);
		ObjectMapper mapper = new ObjectMapper();
		for (BatchPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println("requestBody with missing mandatory fields:" + requestBody);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.ALL_BATCHES_WITH_ENDPOINTS,
						requestBody);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@When("Admin creates POST request create a batch with invalid endpoint")
	public void admin_creates_post_request_create_a_batch_with_invalid_endpoint() {
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY4);
		ObjectMapper mapper = new ObjectMapper();
		
		for (BatchPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				response = RestassuredExtension
						.postRequestStringBody(ConstantFilePaths.POST_BATCH_WITH_INVALID_ENDPOINT, requestBody);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Given("Admin creates POST Request with missing additional fields")
	public void admin_creates_post_request_with_missing_additional_fields() {
		BatchRequestBody batchRequestBody = new BatchRequestBody();
		List<BatchPayload> allrows = batchRequestBody.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY6);
		ObjectMapper mapper = new ObjectMapper();
	
		for (BatchPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println("requestBody with missing additional fields:" + requestBody);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.ALL_BATCHES_WITH_ENDPOINTS,
						requestBody);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@When("Admin creates POST Request with invalid data in request body for batch")
	public void admin_creates_post_request_with_invalid_data_in_request_body_for_batch() {
		BatchNegativeBodyRequest batchNegativeBodyRequest = new BatchNegativeBodyRequest();
		List<BatchPayload> allrows = batchNegativeBodyRequest.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY3);
		ObjectMapper mapper = new ObjectMapper();
		for (BatchPayload eachRow : allrows) {
			try {
				
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println("requestBody with missing additional fields:" + requestBody);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.ALL_BATCHES_WITH_ENDPOINTS,
						requestBody);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@When("Admin creates POST Request with inactive program id")
	public void admin_creates_post_request_with_inactive_program_id() {
		BatchNegativeBodyRequest batchNegativeBodyRequest = new BatchNegativeBodyRequest();
		List<BatchPayload> allrows = batchNegativeBodyRequest.Requestbody(ConstantFilePaths.BATCH_TEST_DATA,
				ConstantFilePaths.BATCH_QUERRY7);
		ObjectMapper mapper = new ObjectMapper();
		
		for (BatchPayload eachRow : allrows) {
			try {
				String requestBody = mapper.writeValueAsString(eachRow);
				System.out.println("requestBody with missing additional fields:" + requestBody);
				response = RestassuredExtension.postRequestStringBody(ConstantFilePaths.ALL_BATCHES_WITH_ENDPOINTS,
						requestBody);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Given("Admin creates PUT Request with deleted batch Id")
	public void admin_creates_put_request_with_deleted_batch_id() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", BatchId);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.PUT_BATCH_WITH_DELETE_ENDPOINT,
				batch_id);
	}

	@When("Admin creates GET Request to Delete Batch with batch Name")
	public void admin_creates_get_request_to_delete_batch_with_batch_name() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", batchName);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_Name_ENDPOINT,
				batch_id);

	}

	@When("Admin creates GET Request for delete with valid BatchId and Data")
	public void admin_creates_get_request_for_delete_with_valid_batch_id_and_data() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", BatchId);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.GET_BATCH_WITH_BATCH_ID_ENDPOINT,
				batch_id);

	}

	@When("Admin creates PUT Request for Delete ProgramId with valid batchId")
	public void admin_creates_put_request_for_delete_program_id_with_valid_batch_id() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", BatchId);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.DELETE_BATCH_ID_ENDPOINT, batch_id);
	}

	// Delete Operations
	@When("Admin creates DELETE Request with valid BatchId")
	public void admin_creates_delete_request_with_valid_batch_id() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", BatchId);
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.DELETE_BATCH_ID_ENDPOINT, batch_id);

	}

	@When("Admin creates DELETE Request with invalid endpoint")
	public void admin_creates_delete_request_with_invalid_endpoint() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", "8516455");
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.ALL_BATCHES_WITH_INVALIDENDPOINTS,
				batch_id);

	}

	@When("Admin creates DELETE Request with invalid BatchId")
	public void admin_creates_delete_request_with_invalid_batch_id() {
		HashMap<String, String> batch_id = new HashMap<>();
		batch_id.put("Id", "851656");
		response = RestassuredExtension.deleteWithPathParram(ConstantFilePaths.DELETE_BATCH_ID_ENDPOINT, batch_id);
	}

}
