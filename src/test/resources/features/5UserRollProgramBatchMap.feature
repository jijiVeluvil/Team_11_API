@UserRole_Program_BatchMap
Feature: Get Request all Admins with program/batch

@Get_Request_to_retrive_all_Admins_with_Authorization
Scenario: Check if admin is able to retreive all Admins with assigned program batches
   Given Admin sets authorization to bearer token in UserRole_Program_BatchMap 
   When  Admin sends HTTPS Request to retrieve all Admins assigned to program/batch in UserRoleBatchMap
   Then Admin receives 200 OK UserRoleMap
   
@Get_Request_to_retrive_all_Admins_No_Authorization
Scenario: Check if admin is able to retreive all Admins with assigned program batches with No Authorization
   Given Admin sets No authorization to bearer token in UserRole_Program_BatchMap
   When  Admin sends HTTPS Request to retrieve all Admins assigned to program/batch in UserRoleBatchMap
   Then Admin receives status 401 with Unauthorized message UserRoleMap

@Get_Request_get_program/batchdetails_for_AdminId   
Scenario: Check if admin is able to retreive assigned program batches for valid AdminId
   Given Admin sets authorization to bearer token in UserRole_Program_BatchMap 
  When Admin sends HTTPS Request to retrieve Admin assigned to Program/Batch by AdminId 
 Then Admin receives 200 OK UserRoleMap
   
@Get_Request_if_admin_isable_to_retreive_assigned_program_batches_for_invalid_AdminId
Scenario: Check if admin is able to retreive assigned program batches for invalid AdminId 
Given Admin sets authorization to bearer token in UserRole_Program_BatchMap 
When Admin sends HTTPS Request  to retrieve Admin assigned to Program/Batch by invalid AdminID
 Then Admin receives 404 with Unauthorized message UserRoleMap
   
@Check_if_admin_is_able_to_retreive_assigned_program_batches_for_valid_AdminId_with_No_authorization
Scenario: Check if admin is able to retreive assigned program batches for valid AdminId with No authorization
  Given Admin sets No authorization to bearer token in UserRole_Program_BatchMap 
   When Admin sends HTTPS Request to retrieve Admin assigned to Program/Batch by AdminId
   When Admin receives status 401 with Unauthorized message UserRoleMap
 
 
   
   
   
   
   
   
   
   
   
   
   