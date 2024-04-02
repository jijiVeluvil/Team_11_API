  Feature: Delete Feature
  ###DELETE REQUEST  (by Batch ID)
    #ProgramId delete
  
  @Delete_Request_Check_if_admin_able_to_delete_a_Batch_with_valid_Batch_ID
  Scenario: Check if admin able to delete a Batch with valid Batch ID
  Given Admin sets authorization to bearer token in batchmodule
  When Admin creates DELETE Request with valid BatchId
  Then Admin receives 200 OK Status with updated value in response body.
  
  @Delete_Request_Check_if_admin_able_to_delete_a_Batch_with_invalid_endpoint
  Scenario: Check if admin able to delete a Batch with invalid endpoint
 Given Admin sets authorization to bearer token in batchmodule
  When Admin creates DELETE Request with invalid endpoint
  Then Admin receives 404 Not Found Status with message and boolean success details	
  
  @Delete_Request_Check_if_admin_able_to_delete_a_Batch_with_invalid_Batch_Id
  Scenario: Check if admin able to delete a Batch with invalid Batch ID
  Given Admin sets authorization to bearer token in batchmodule
  When Admin creates DELETE Request with invalid BatchId
  Then Admin receives 404 Not Found Status with message and boolean success details
  
  @Delete_Request_Check_if_admin_able_to_delete_a_Batch_with_out_AuthoriZation
  Scenario: Check if admin able to delete a Batch without authorization
   Given Admin creates get request with out AuthoriZation
  When Admin creates DELETE Request with valid BatchId
  Then  Admin receives 401 Bad Request Status with message and boolean success details 
  ##Program Module Delete
  Scenario: Check if Admin able to delete a program with valid programID
    Given Admin creates DELETE Request for the LMS API endpoint and with  valid programID for DeleteProgramById for Program .
    When Admin sends HTTPS Request with endpoint for Program with valid programID for DeleteProgramById for Program
    Then Admin receives TwoHundred Ok status with message for DeleteProgramById for that Program

  Scenario: Check if Admin able to delete a program with valid LMS API,invalid programID
    Given Admin creates DELETE Request for the LMS API endpoint  and  invalid programID for DeleteProgramById for Program .
    When Admin sends HTTPS Request with endpoint for Program with valid LMS API,invalid programID for DeleteProgramById for Program
    Then Admin receives FourNotFour Not Found Status with message and boolean success details for DeleteProgramById for Program

  Scenario: Check if Admin able to delete a program without Authorization
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid programID without Authorization for DeleteProgramById for Program
    When Admin sends HTTPS Request with endpoint for Program without Authorization for DeleteProgramBy Id for Program
    Then Admin receives FourHundredOne Unauthorized for DeleteProgramById for Program
      #Program  Name
        @Program
  Scenario: Check if Admin able to delete a program with valid programName
    Given Admin creates DELETE Request for the LMS API endpoint  and with valid programName for DeleteProgramByName for Program
    When Admin sends HTTPS Request with endpoint  with valid programName for DeleteProgramByName for Program
    Then Admin receives TwoHundred Ok status with message for DeleteProgramByName for Program

  Scenario: Check if Admin able to delete a program with valid LMS API,invalid programName for Program
    Given Admin creates DELETE Request for the LMS API endpoint  and  invalid programName for DeleteProgramByName for Program
    When Admin sends HTTPS Request with endpoint  valid LMS API,invalid programName for DeleteProgramByName for Program
    Then Admin receives FourNotFour Not Found Status with message and boolean success details for DeleteProgramByName for Program

  Scenario: Check if Admin able to delete a program without Authorization
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName without Authorization for DeleteProgramByName for Program
    When Admin sends HTTPS Request with endpoint without Authorization for DeleteProgramByName for Program
    Then Admin receives FourHundredOne Unauthorized for DeleteProgramByName for Program
        
    
    @Get_Request_Check_if_admin_able_to_retrive_a_batch_after_the_programID_is_deleted
  Scenario: Check if admin able to retrive a batch after the programID is deleted
  Given Admin creates GET Request with program id
  When Admin sends HTTPS Request with endpoint 
  Then Admin receives 404 Not Found Status with message and boolean success details

  
  
  @Put_Request_Check_admin_able_update_Batch_with_valid_batchID_and_deleted_programID_field_in_request_body_with_other_mandatory_fields
Scenario: Check if admin able to update a Batch with a valid batchID and deleted programID field  in the request body with other mandatory fields
  Given Admin creates get request with out AuthoriZation
When Admin creates PUT Request for Delete ProgramId with valid batchId
 Then  Admin receives 401 Bad Request Status with message and boolean success details

   
@Get_Request_if_admin_able_to_retrive_a_batch_after_deleting_the_batch 
Scenario: Check if admin able to retrive a batch after deleting the batchId 
 Given Admin sets authorization to bearer token in batchmodule
  When Admin creates GET Request for delete with valid BatchId and Data
   Then Admin receives 200 OK Status with response body.
   @Get_Request_Check_if_admin_able_to_retrive_a_deleted_batch_using_batch_name 
  Scenario: Check if admin able to retrive a deleted batch using batch name 
  Given Admin sets authorization to bearer token in batchmodule
  When Admin creates GET Request to Delete Batch with batch Name
   Then Admin receives 200 OK Status with response body.
  
    
@Put_Request_Check_if_admin_able_to_update_a_Batch_with_a_deleted_batchID_in_the_endpoint
Scenario: Check if admin able to update a Batch with a deleted batchID in the endpoint
Given Admin sets authorization to bearer token in batchmodule
    When Admin creates PUT Request with deleted batch Id
    Then Admin receives 200 OK Status with updated value in response body.
    # Expected 200 but was 401
  
  
  #UserRoleProgramBatchMapController
  @Delete_Request_if_admin_able_to_delete_the_program_batch_for_Admin
 Scenario: Check if admin is able to delete the program batch for a Admin
Given Admin sets authorization to bearer token in UserRole_Program_BatchMap 
 When Admin sends HTTPS Request to delete Admin assigned to program/batch by valid AdminId
 Then Admin receives 200 OK UserRoleMap
    
@Delete_Request_admin_is_able_to_delete_the_program_batch_for_invalid_Admin
Scenario: Check if admin is able to delete the program batch for invalid Admin
Given Admin sets authorization to bearer token in UserRole_Program_BatchMap
   When Admin sends HTTPS Reques to delete Admin assigned to program/batch by invalid AdminId 
  Then Admin receives 404 with Unauthorized message UserRoleMap
   
@Delete_Request_if_admin_able_to_delete_the_program_batch_for_valid_Admin_and_No_Authorization
Scenario: Check if admin is able to delete the program batch for valid Admin and No Authorization
Given Admin sets No authorization to bearer token in UserRole_Program_BatchMap 
 When Admin sends HTTPS Request to delete Admin assigned to program/batch by valid AdminId
   Then Admin receives status 401 with Unauthorized message UserRoleMap
   
   #UserModule
   @Delete_request_01
		Scenario: Check if Admin able to delete a Admin with valid Admin Id
		Given Admin sets authorization to bearer token
		When Admin sends HTTPS request with endpoint to delete user
		Then Admin receives 200 Ok status with message 
		
		@Detlete_02
		Scenario: Check if Admin able to delete a invalid Admin Id	
		Given Admin sets authorization to bearer token
    When Admin sends HTTPS request with endpoiint to delete user with invalid UserId
    Then Admin receives status 404 with Not Found error message
		
		@Delete_03 
		Scenario: Check if Admin able to delete a Admin with No authorization	
		Given Admin sets authorization to No  Auth.
		When 	Admin sends HTTPS request with endpoint to delete user
	  Then Admin receives status 401 with Unauthorized message.
		
		
   
  