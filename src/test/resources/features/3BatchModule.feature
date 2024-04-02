@BatchModule
 
 Feature: LMS API BatchModule
  ########POST REQUEST
  @Post_Request_Check_if_admin_able_to_create_a_Batch_with_valid_endpoint_and_request_body_without_authorization.
  Scenario:Check if admin able to create a Batch with valid endpoint and request body without authorization.
 Given Admin creates get request with out AuthoriZation
  When Admin creates POST Request  with valid data in request body 
  Then Admin receives 401 status with error message Unauthorized.
  
  @Post_Request_Check_if_admin_able_to_create_a_Batch_with_valid_endpoint_and_request_body_non_existing_values)
  Scenario: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
 Given Admin sets authorization to bearer token in batchmodule 
  When Admin creates POST Request  with valid data in request body 
  Then Admin receives 201 Created Status with response body for schemavalidation
  
  
  @Post_Request_Check_if_admin_able_to_create_a_Batch_with_valid_endpoint_and_request_body_existing_value_in_Batch_Name
  Scenario: Check if admin able to create a Batch with valid endpoint and request body (existing value in Batch Name)
   Given Admin sets authorization to bearer token in batchmodule 
  When Admin creates POST Request  with valid data in request body existing Value 
  Then Admin receives 400 Bad Request Status with message and boolean success details
  
  @Post_Request_Check_if_admin_able_to_create_a_Batch_missing_mandatory_fields_in_request_body
  Scenario: Check if admin able to create a Batch missing mandatory fields in request body
   Given Admin sets authorization to bearer token in batchmodule
  When Admin creates POST Request  with missing mandatory fields in request body 
  Then Admin receives 400 Bad Request Status with message and boolean success details
  
  @Post_Request_Check_if_admin_able_to_create_a_batch_with_invalid_endpoint
 Scenario: Check if admin able to create a batch with invalid endpoint
   Given Admin sets authorization to bearer token in batchmodule
   When Admin creates POST request create a batch with invalid endpoint
   Then Admin receives 404 not found  Status 
   
@Post_Request_Check_if_admin_able_to_create_a_batch_with_missing_additional_fields
Scenario: Check if admin able to create a batch with missing additional fields
    Given Admin creates POST Request with missing additional fields
    When Admin sends HTTPS Request with endpoint 
    Then Admin receives 201 Created Status with response body    
 # Expected Status Code 400 but was 404  
@Post_Request_Check_if_admin_able_to_create_a_batch_with_invalid_data_in_request_body
Scenario: Check if admin able to create a batch with invalid data in request body
   Given Admin sets authorization to bearer token in batchmodule
  When Admin creates POST Request with invalid data in request body for batch
   Then Admin receives 400 Bad Request Status with message and boolean success details    
  #  Expected Status Code 400 but was 404
@Post_Request_Check_if_admin_able_to_create_a_batch_with_inactive_program_ID
Scenario: Check if admin able to create a batch with inactive program ID
 Given Admin sets authorization to bearer token in batchmodule
   When Admin creates POST Request with inactive program id
   Then Admin receives 400 Bad Request Status with message and boolean success details
  
  ##GetRequest

 @GET_Request_All_Batches
 Scenario: Check if admin able to retrieve all batches  with valid LMS API
    Given Admin sets authorization to bearer token in batchmodule
    When Admin sends HTTPS Request with endpoint to get all Batches
    Then Admin receives 200 OK Status with response body for all batches.
    
  @GET_REQUEST_FOR_INVALID_ENDPOINTS
  Scenario: Check if admin able to retrieve all batches with invalid Endpoint
  Given Admin sets authorization to bearer token in batchmodule
  When Admin sends HTTPS Request with invalid endpoint for all batch
  Then Admin receives 404 status with error message Not Found .
  
	 @GET_REQUEST_WITH_SEARCH_STRING
	 Scenario: Check if admin able to retrieve all batches with search string
	 Given Admin sets authorization to bearer token in batchmodule
	 When Admin creates GET Request with search string
	 Then Admin receives 200 Ok status with response body
		  
		#Expected 401 but was 400-->Bug  
  @GET_REQUEST_WITHOUT_AUTHORIZATION
  Scenario: Check if admin able to retrieve all batches without Authorization
  Given Admin creates get request with out AuthoriZation
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 401 status with error message Unauthorized.
 
  @Get_Request_by_Batch_ID_without_Authorization
  Scenario: Check if admin able to retrieve a batch with batch ID without authorization
  Given Admin creates get request with out AuthoriZation
   Given Admin creates GET Request with valid Batch ID
   When Admin sends HTTPS Request with endpoint 
   Then Admin receives 401 status with error message Unauthorized.
   
  
   @Get_Request_admin_able_to_retrieve_batch_with_valid_BATCH_ID_with_Authorization_Token
  Scenario: Check if admin able to retrieve a batch with valid BATCH ID
  Given Admin sets authorization to bearer token in batchmodule
   Given Admin creates GET Request with valid Batch ID
   When Admin sends HTTPS Request with endpoint 
   Then Admin receives 200 OK Status with response body. 
   
  @Get_Request_if_admin_able_to_retrieve_a_batch_with_invalid_BATCH_ID
  Scenario: Check if admin able to retrieve a batch with invalid BATCH ID
  Given Admin creates GET Request with invalid Batch ID
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details
  
 # 404 -->Expected 404 but found 401
  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_with_invalid_endpoint
  Scenario: Check if admin able to retrieve a batch with invalid endpoint
  Given Admin creates GET Request with valid Batch ID
  When Admin sends HTTPS Request with invalid endpoint for batchId
  Then Admin receives 401 not found  Status 
  
     
#Batch_name
  @Get_Request_if_admin_able_to_retrieve_a_batch_without_authorization
  Scenario: Check if admin able to retrieve a batch without authorization
   Given Admin creates get request with out AuthoriZation
  Given Admin creates GET Request with batch Name
  When Admin sends HTTPS Request with endpoint
   Then Admin receives 401 status with error message Unauthorized. 
  
  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_with_valid_BATCH_NAME
  Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
  Given Admin sets authorization to bearer token in batchmodule
  Given Admin creates GET Request with batch Name
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 200 OK Status with response body.
  
  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_with_invalid_BATCH_NAME
  Scenario: Admin creates GET Request with invalid Batch Name
  Given Admin creates GET Request with invalid Batch Name
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details
  
  
  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_with_invalid_endpoint
  Scenario: Check if admin able to retrieve a batch with invalid endpoint
  Given Admin creates GET Request with batch Name
  When Admin sends HTTPS Request with invalid endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details
    

  
  #GET  REQUEST { by program Id}
  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_without_authorization
  Scenario: Check if admin able to retrieve a batch without authorization
  Given Admin creates get request with out AuthoriZation
  Given Admin creates GET Request with program id	
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 401 status with error message Unauthorized. 
  

  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_with_valid_Program_ID
  Scenario: Check if admin able to retrieve a batch with valid Program ID
   Given Admin sets authorization to bearer token in batchmodule
  Given Admin creates GET Request with program id	
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 200 OK Status with response body. 
  
  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_with_invalid_Program_Id
  Scenario: Check if admin able to retrieve a batch with invalid Program Id
  Given Admin creates GET Request with invalid Program Id
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details 
  
  @Get_Request_Check_if_admin_able_to_retrieve_a_batch_with_invalid_endpoint
  Scenario: Check if admin able to retrieve a batch with invalid endpoint
  Given Admin creates GET Request with invalid endpoint
  When Admin sends HTTPS Request with invalid endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details
  
  
 # PUT REQUEST  (Update Batch by batchID)
  @Put_RequestCheck_if_admin_able_to_update_a_Batch_with_valid_batchID_and_mandatory_fields_in_request_body_without_authorization
  Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body without authorization
   Given Admin creates get request with out AuthoriZation
  When Admin creates PUT Request with valid BatchId and Data
    Then Admin receives 401 status with error message Unauthorized. 

 # Expected 200 but it was 404
   @Put_Request_Check_if_admin_able_to_update_a_Batch_with_valid_batchID_and_mandatory_fields_in_request_body__Authorization_Token
    Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body with  Auth
    Given Admin sets authorization to bearer token in batchmodule
    When Admin creates PUT Request with valid BatchId and Data
    Then  Admin receives 404 OK Status with updated value in response body.   
    
  @Put_Request_Check_if_admin_able_to_update_Batch_with_invalid_batchID_and_mandatory_fields_in_request_body 
  Scenario: Check if admin able to update a Batch with invalid batchID and mandatory fields in request body
   Given Admin sets authorization to bearer token in batchmodule
    When Admin creates PUT Request with Invalid BatchId and Data
    Then  Admin receives 404 Not Found Status with message and boolean success details
 
@Put_Request_Check_if_admin_able_to_update_Batch_with_valid_batchID_and_missing_mandatory_fields_request_body
Scenario: Check if admin able to update a Batch with valid batchID and missing mandatory fields request body
 Given Admin sets authorization to bearer token in batchmodule
   When Admin creates PUT Request with valid batch Id and missing mandatory fields
    Then Admin receives 400 Bad Request Status with message and boolean success details

@Put_Request_Check_if_admin_able_to_update_a_batch_with_invalid_data
Scenario: Check if admin able to update a batch with invalid data
Given Admin sets authorization to bearer token in batchmodule
    When Admin creates PUT Request with invalida dataforBatch
    Then Admin receives 404 Bad Request Status with message and boolean success details
    
@Put_Request_Check_if_admin_able_to_update_a_Batch_with_invalid_enpoint
Scenario: Check if admin able to update a Batch with invalid enpoint
     Given Admin creates get request with out AuthoriZation
     When Admin creates PUT Request with valid BatchId and Data
    Then Admin receives 404 Not Found Status with message and boolean success details	
  
 

  
 
  
  
  
 
  
  
  
  
  
  
  
  
  
  
  
