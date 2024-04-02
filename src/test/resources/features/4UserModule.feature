@UserModule
Feature: LMS API UserModule

@PostRequest_UserWithRole_WithMandatoryFields
  Scenario: Check if admin is able to create a new admin with valid endpoint and request body with mandatory fields
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS Post request with only mandatory fields and valid end point
  Then Admin receives 201 Created status with response body
  
  @PostRequest_UserWithRole_WithAllFields
  Scenario: Check if admin is able to create a new admin with valid endpoint and request body with all fields
  Given Admin sets authorization to bearer token
  When Admin sends HTTPS Post request with all fields and valid end point
  Then Admin receives 201 Created status with response body
  
  @PostRequest_UserWithRole_WithInvalidValues
  Scenario: Check if admin is able to create a new admin with valid endpoint and invalid values in request body
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS Post request with invalid values and valid end point
  Then Admin receives 400 Bad Request Status with message and boolean success details
  
  @PostRequest_UserWithRole_WithMissingMandatoryFields
  Scenario: Check if admin is able to create a admin with missing mandatory fields
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS Post request with missing mandatory fields and valid end point
  Then Admin receives 400 Bad Request Status with message and boolean success details
  
  @PostRequest_UserWithRole_WithoutAuthorization
  Scenario: Check if admin is able to create a admin with request body without authorization
  Given Admin sets authorization to No  Auth. 
  When Admin sends HTTPS Post request with all fields and without authorization
  Then Admin receives status 401 with Unauthorized message.

		@PUT_User_by_UserID_01
		Scenario: Check if admin is able to update Admin details with Admin id and mandatory fields
			Given Admin sets authorization to bearer token
			When Admin sends PUT Request with valid request body 
	  	Then Admin receives 200 OK Status with response body.
		
		@Put_User_by_userID_02
		Scenario: Check if admin is able to update Admin details with Admin id  and valid data in all fields
		Given Admin sets authorization to bearer token 
		When Admin creates PUT Request with valid data in request body (values only in mandatory fields) 
		Then Admin receives 200 Ok status with message 
		
		@PUT_User_by_UserID_03
		Scenario: Check if admin is able to update Admin details with  Admin id and invalid data
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with invalid data in request body 
		Then Admin receives 400 Bad Request Status with message and boolean success details
		
		@PUT_User_by_UserID_04
		Scenario: Check if admin is able to update Admin details with invalid AdminId
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid data and invalid AdminId in request body 
		Then Admin receives status 404 with Not Found error message
		
		@PUT_User_by_UserID_05
		Scenario: Check if admin is able to update Admin details with No authorization
		Given Admin sets authorization to No  Auth.
		When Admin sends PUT Request with valid request body
		Then Admin receives status 401 with Unauthorized message.
		
		@PUT_For_update_RoleId_of_userID_01
		Scenario: Check if admin is able to update role id of a Admin by valid Admin id
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid request body
		Then Admin receives 200 OK Status with response body. 
	
	@PUT_For_update_RoleId_of_userID_02
	Scenario: Check if admin is able to update role id of a Admin by valid Admin id
	Given Admin sets authorization to bearer token
	When Admin creates PUT Request with invalid request body to Update RoleID
	Then Admin receives 400 Bad Request Status with message and boolean success details
	
	@PUT_For_update_RoleId_of_userID_03
	Scenario: Check if admin is able to update role id of a Admin with invalid Admin id
	Given Admin sets authorization to bearer token
	When Admin creates PUT Request with request body with Invalid Admin Id
	Then Admin receives 400 Bad Request Status with message and boolean success details
	
	@PUT_For_update_RoleId_of_userID_04
	Scenario: Check if admin is able to update a Admin with Admin Role Id with already existing Admin role ID
	Given Admin sets authorization to bearer token
	When Admin creates PUT Request with valid request body
	Then Admin receives 400 Bad Request Status with message and boolean success details
	
	@PUT_For_update_RoleId_of_userID_05
	Scenario: Check if admin is able to update role id of a Admin by valid Admin id with no authorization
	Given Admin sets authorization to No  Auth.
	When Admin creates PUT Request with valid request body
	Then Admin receives status 401 with Unauthorized message.
	
	@PUT_For_update_RoleId_of_userID_06
	Scenario: Check if admin is able to update a Admin role ID with valid Admin role ID with invalid endpoint
	Given Admin sets authorization to bearer token
	When Admin creates PUT Request with request body with invalid Endpoint
	Then Admin receives status 404 with Not Found error message
	
		
		@PUT_Update_Role_Status_Of_UserID_01
		Scenario: Check if admin is able to update role status of a Admin with valid Admin id
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid data in request body 
		Then Admin receives 200 OK Status with response body.    
		
		@PUT_Update_Role_Status_Of_UserID_02
		Scenario: Check if admin is able to update role status of a Admin with valid Admin id and invalid role status
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with invalid data in request body to update roleId Status
		Then Admin receives 400 Bad Request Status with message and boolean success details
		
		@PUT_Update_Role_Status_Of_UserID_03
		Scenario:Check if admin is able to update role status of a Admin with invalid Admin id
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid data in request body With Invalid AdminID
		Then Admin receives status 404 with Not Found error message
		
		@PUT_Update_Role_Status_Of_UserID_04
		Scenario: Check if admin is able to update role status of a Admin for nonexisting/unassigned RoleID
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with nonexisting/unassigned RoleID
		Then Admin receives status 404 with Not Found error message
		
		@PUT_Update_Role_Status_Of_UserID_05
		Scenario: Check if admin is able to update role status of a Admin with valid Admin id with no authorization
		Given Admin sets authorization to No  Auth.
		When Admin creates PUT Request with valid data in request body 
		Then Admin receives status 401 with Unauthorized message.
		
		@PUT_Update_Role_Status_Of_UserID_06
		Scenario: Check if admin is able to update role status of a Admin with invalid endpoint
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid data in request body with invalid Endpoint
		Then Admin receives status 404 with Not Found error message
		
		
		@PUT_ipdate_user_Login_Status_userID_01
		Scenario: Check if admin is able to update the Admin login status by Admin ID
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid data in request body to update loginStatus
		Then Admin receives 200 OK Status with response body.
		
		@PUT_ipdate_user_Login_Status_userID_02
		Scenario: Check if admin is able to update the Admin login status by Admin ID and invalid data in request body
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with invalid data in request body to update loginstatus
		Then Admin receives 400 Bad Request Status with message and boolean success details
		
		@PUT_ipdate_user_Login_Status_userID_03
		Scenario: Check if admin is able to update the Admin login status with invalid AdminId
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request to update login Status with valid data in request body and invalid AdmiId  
		Then Admin receives status 404 with Not Found error message
		
		@PUT_ipdate_user_Login_Status_userID_03
		Scenario: Check if admin is able to update Admin details with No authorization
		Given Admin sets authorization to No  Auth.
		When Admin creates PUT Request with valid data in request body to update loginStatus
		Then Admin receives status 401 with Unauthorized message.
		
		
		@PUT_Update_Program_Batch_userId_01
		Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid data in request body to update program batch 
		Then Admin receives 200 OK Status with response body. 
		
		@PUT_Update_Program_Batch_userId_02
		Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with invalid data in request body to update program and batch
		Then Admin receives 400 Bad Request Status with message and boolean success details
		
		@PUT_Update_Program_Batch_userId_03
		Scenario: Check if admin is able to assign Admin to with program/batch by invalid Admin Id
		Given Admin sets authorization to bearer token
		When Admin creates PUT Request with valid data and invalid Admin Id in request body to assign program and batch 
		Then Admin receives status 404 with Not Found error message
		
		@PUT_Update_Program_Batch_userId_04
		Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id no authorization
		Given Admin sets authorization to No  Auth.
		When Admin creates PUT Request with valid data in request body to update program batch 
		Then Admin receives status 401 with Unauthorized message.
		
		@PUT_Update_Program_Batch_userId_05
		Scenario: Check if admin is able to update role status of a Admin with invalid endpoint
		Given Admin sets authorization to bearer token
		When Admin sends HTTPS Request with invalid endpoint to update program and Batch
		Then Admin receives status 404 with Not Found error message
		

  @GET_User_with_All_Roles_01
  Scenario: Check if admin able to retrieve all Admins with roles
    Given Admin sets authorization to bearer token
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 200 OK Status with response body.
    
   @GET_User_With_All_Roles_02 
   Scenario: Check if admin able to retrieve all Admins with roles with No authorization
   Given Admin sets authorization to No  Auth.
		When Admin sends HTTPS Request with endpoint
		Then Admin receives status 401 with Unauthorized message.
		
	 @GET_User_With_All_Roles_03 
   Scenario: Check if admin able to retrieve all Admins with roles with invalid endpoint
   	Given Admin sets authorization to bearer token
		When Admin sends HTTPS Request with invalid endpoint
		Then Admin receives status 404 with Not Found error message
	
		
		@GET_request_with_filters_01
		Scenario: Check if admin is able to retrieve all Admins with filters
		Given Admin sets authorization to bearer token
		When Admin sends HTTPS Request with endpoint to get all admins with filter
		Then Admin receives 200 OK Status with response body.
		
		@GET_request_with_filters_02
		Scenario: Check if admin is able to retrieve all Admins with filters with no authorization
		Given Admin sets authorization to No  Auth.
		When Admin sends HTTPS Request with endpoint to get all admins with filter
		Then Admin receives status 401 with Unauthorized message.
		
		
		@GET_request_with_filters_03
		Scenario: Check if admin is able to retrieve all Admins with filters with invalid endpoint
		Given Admin sets authorization to bearer token
		When Admin sends HTTPS Request with Invalid endpoint to get all admins with filter 
		Then Admin receives status 404 with Not Found error message
		
		
		
		@GetRequest_GetAllRoles
  Scenario: Check if admin is able to retreive all the available roles
  Given Admin sets authorization to bearer token
  When Admin sends HTTPS request with Get all roles endpoint
  Then Admin receives 200 OK Status with response body.
  
  @GetRequest_GetAllRoles_WithoutAuthorization
  Scenario: Check if admin is able to retreive all the available roles with out authorization
  Given Admin sets authorization to No  Auth.
  When Admin sends HTTPS request with Get all roles endpoint
  Then Admin receives status 401 with Unauthorized message.
  
  @GetRequest_GetAllRoles_WithInvalidEndpoint
  Scenario: Check if admin is able to retreive all the available roles with invalid end point
  Given Admin sets authorization to bearer token
  When Admin sends HTTPS request with Get all roles invalid end point
  Then Admin receives status 404 with Not Found error message

@GetRequest_GetAllAdmins
  Scenario: Check if admin is able to retreive all admin with valid endpoint
  Given Admin sets authorization to bearer token
  When Admin sends HTTPS request with Get all admins valid end point
  Then Admin receives 200 OK Status with response body.
  
  @GetRequest_GetAllAdmins_WithoutAuthorization
  Scenario: Check if admin is able to retreive all admin without authorization
  Given Admin sets authorization to No  Auth.
  When Admin sends HTTPS request with Get all admins valid end point
  Then Admin receives status 401 with Unauthorized message.
  
  @GetRequest_GetAllAdmins_WithInvalidEndpoint
  Scenario: Check if admin is able to retrieve all admin with invalid endpoint
  Given Admin sets authorization to bearer token
  When  Admin sends HTTPS request with Get all admins invalid end point
  Then Admin receives status 404 with Not Found error message
  #
  @GetRequest_GetByAdminId
	  Scenario: Check if admin is able to retrieve a admin with valid admin Id
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with valid Get by admin Id end point
	  Then Admin receives 200 OK Status with response body.
	  
	  @GetRequest_GetByAdminId_WithInvalidEndpoint
	  Scenario: Check if admin is able to retrieve a admin with valid admin Id and invalid endpoint
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with invalid Get by admin Id end point
	  Then Admin receives status 404 with Not Found error message
	  
	  @GetRequest_GetByAdminId_WithoutAuthorization
	  Scenario: Check if admin is able to retrieve a admin with valid admin Id with no authorization
	  Given Admin sets authorization to No  Auth.
	  When Admin sends HTTPS request with valid Get by admin Id end point
	  Then Admin receives status 401 with Unauthorized message.
	  
	  @GetRequest_GetByAdminId_WithInvalidAdminId
	  Scenario: Check if admin is able to retrieve a admin with invalid admin Id
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with invalid admin Id and valid end point
	  Then Admin receives status 404 with Not Found error message
  
		@GetRequest_GetAllActiveAdmins
	  Scenario: Check if admin is able to retrieve all active admins
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with Get all active admins end point 
	  Then Admin receives 200 OK Status with response body.
	  
	  @GetRequest_GetAllActiveAdmins_WithoutAuthorization
	  Scenario: Check if admin is able to retrieve all active admins with no authorization
	  Given Admin sets authorization to No  Auth.
	  When Admin sends HTTPS request with Get all active admins end point
	  Then Admin receives status 401 with Unauthorized message.
	  
	  @GetRequest_GetAllActiveAdmins_WithInvalidEndpoint
	  Scenario: Check if admin is able to retrieve all active admins with invalid end point
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with invalid Get all active admins end point
	  Then Admin receives status 404 with Not Found error message
	  
	  @GetRequest_GetInactiveAndActiveAdmins
  Scenario: Check if admin is able to get count of active and inactive admins
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with Get inactive and active end point
  Then Admin receives 200 OK Status with response body.
  
  @GetRequest_GetInactiveAndActiveAdmins_WithoutAuthorization
  Scenario: Check if admin is able to get count of active and inactive admins with no authorization
  Given Admin sets authorization to No  Auth.
  When Admin sends HTTPS request with Get inactive and active end point
  Then Admin receives status 401 with Unauthorized message.
  
  @GetRequest_GetInactiveAndActiveAdmins_WithInvalidEndpoint
  Scenario: Check if admin is able to get count of active and inactive admins with invalid end point
  Given Admin sets authorization to bearer token  
  When Admin sends HTTPS request with Get inactive and active invalid endpoint
  Then Admin receives status 404 with Not Found error message
  
  @GetRequest_GetInactiveAndActiveAdmins_ByRoleId
  Scenario: Check if admin is able to get count of active and inactive admins by role Id
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with valid role Id and Get inact and act admins by role id endpoint
  Then Admin receives 200 OK Status with response body.
  
  @GetRequest_GetInactiveAndActiveAdmins_ByInvalidRoleId
  Scenario: Check if admin is able to get count of active and inactive admins by inavalid role Id
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with invalid role Id and Get inact and act admins by role id endpoint
  Then Admin receives status 404 with Not Found error message
  
  @GetRequest_GetAdmins_ByProg.BatchesWithValidBatchId
  Scenario: Check if admin is able to get the admins by program batches for valid batch Id
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with valid batch Id and Get admin by program batches end point
  Then Admin receives 200 OK Status with response body.
  
  @GetRequest_GetAdmins_ByProg.BatchesWithInvalidBatchId
  Scenario: Check if admin is able to get the admins by program batches for invalid batch Id
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with invalid batch Id and Get admin by program batches end point
  Then Admin receives status 404 with Not Found error message
  
  @GetRequest_GetAdmins_ByProg.BatchesWithValidBatchId_WithoutAuthorization
  Scenario: Check if admin is able to get the admins by program batches for valid batch id with no authorization
  Given Admin sets authorization to No  Auth.
  When Admin sends HTTPS request with valid batch Id and Get admin by program batches end point
  Then Admin receives status 401 with Unauthorized message.
  
  @GetRequest_GetAdmins_ByProg.BatchesWithvalidBatchId_WithInvalidEndpoint
  Scenario: Check if admin is able to get the admins by program batches for valid batch id with invalid end point
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with Get admin by program batches invalid end point
  Then Admin receives status 404 with Not Found error message
  
  
  @GetRequest_GetAdmins_ByProgramId
  Scenario: Check if admin is able to get the admins for valid program Id
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with valid program Id and Get admin by program Id valid end point
  Then Admin receives 200 OK Status with response body.
  
  @GetRequest_GetAdmins_ByInvalidProg.Id
  Scenario: Check if admin is able to get the admins for invalid program Id
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with invalid program Id and Get admin by program Id valid end point
  Then Admin receives status 404 with Not Found error message
  
  @GetRequest_GetAdmins_ByValidProg.Id_WithoutAuthorization
  Scenario: Check if admin is able to get the admins for valid program Id with out authorization
  Given Admin sets authorization to No  Auth.
  When Admin sends HTTPS request with valid program Id and Get admin by program Id valid end point
  Then Admin receives status 401 with Unauthorized message.
  
  @GetRequest_GetAdmins_ByValidProg.Id_WithInvalidEndpoint
  Scenario: Check if admin is able to get the admins for valid program Id with invalid end point
  Given Admin sets authorization to bearer token 
  When Admin sends HTTPS request with valid program Id and Get admin by program Id invalid end point
  Then Admin receives status 404 with Not Found error message
  
  @GetRequest_GetAdmin_ByValidRoleId
	  Scenario: Check if admin is able to retrieve admins by valid role Id
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with valid role id and Get admin by role Id end point
	  Then Admin receives 200 OK Status with response body.
	  
	  @GetRequest_GetAdmin_ByInvalidRoleId
	  Scenario: Check if admin is able to retrieve admins by invalid role Id
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with invalid role id and Get admin by role Id end point
	  Then Admin receives status 404 with Not Found error message
	  
	  @GetRequest_GetAdmin_ByValidRoleId_WithoutAuthorization
	  Scenario: Check if admin is able to retrieve admins by valid role Id with no authorization
	  Given Admin sets authorization to No  Auth. 
	  When Admin sends HTTPS request with valid role id and Get admin by role Id end point
	  Then Admin receives status 401 with Unauthorized message.
	  
	  @GetRequest_GetAdmin_ByValidRoleId_WithInvalidEndpoint
	  Scenario: Check if admin is able to retrieve admins by valid role Id with invalid end point
	  Given Admin sets authorization to bearer token 
	  When Admin sends HTTPS request with valid role id and Get admin by role Id invalid end point
	  Then Admin receives status 404 with Not Found error message
 		
		
		

		
		
		
		
		
		
		
		
		
		

		
		
		               
		
		
		                                                          

		
		
		
		
		
		

		
		
		
   	
                                                                      


    
