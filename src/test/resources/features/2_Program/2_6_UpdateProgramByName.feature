@Program
Feature: PUT REQUEST  Using  program name

  @Program
  Scenario:Check if Admin able to update a program with  Valid program Name and request body	
   Given 	Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields for UpdateProgramByName for program
   When   	Admin sends HTTPS Request with valid endpoint and with  Valid program Name and request body for UpdateProgramByName for program
   Then  	Admin receives TwoHundred OK Status with updated value in response body for UpdateProgramByName for program                                          

Scenario:Check if Admin able to update a program with  invalid program Name and request body
   Given Admin creates PUT Request for the LMS API endpoint with valid request Body with mandatory , additional  fields with  invalid program Name and request body for UpdateProgramByName for program
   When  Admin sends HTTPS Request with invalid endpoint with  invalid program Name and request body for UpdateProgramByName for program
   Then Admin receives FourNotFour Not Found Status with message and boolean success details for UpdateProgramByName for program
   
Scenario:Check if Admin able to update a program using valid program name - missing mandatory fields in request body 	
   Given 	Admin creates PUT Request for the LMS API  with missing mandatory fields for UpdateProgramByName for program 
   When  	Admin sends HTTPS Request with valid endpoint with missing mandatory fields for UpdateProgramByName for program
   Then 	Admin receives FourHundred Bad Request Status with message and boolean success details with missing mandatory fields for UpdateProgramByName for program

Scenario:Check if Admin able to update a program with  invalid values in request body 	
   Given 	Admin creates PUT Request for the LMS API endpoint  and  invalid program Name with  invalid values in request body for UpdateProgramByName for program
   When  	Admin sends HTTPS Request  and  request Body with mandatory fields. program Description , program Name, program status for UpdateProgramByName for program
   Then 	Admin receives FourHundred Bad Request Status with message and boolean success details for UpdateProgramByName for program

Scenario:Check if Admin able to update a program with  invalid program Description	
   Given 	Admin creates PUT Request for the LMS API endpoint  and  invalid program Description for UpdateProgramByName for program
   When  	Admin sends HTTPS Request  and  request Body with mandatory fields.invalid program Description , program Name, program status for UpdateProgramByName for program
   Then 	Admin receives FourHundred Bad Request Status with message and boolean success details with  invalid program Description for UpdateProgramByName for program

Scenario:Check if Admin able to update a program status	
   Given 	Admin creates PUT Request for the LMS API endpoint and Valid program Name and status for UpdateProgramByName for program
   When  	Admin sends HTTPS Request with valid endpoint with  Valid program Name and status for UpdateProgramByName for program
   Then 	Admin receives TwoHundred OK Status with updated value in response body  and Valid program Name and status for UpdateProgramByName for program                                         

Scenario:Check if Admin able to update a program without Authorization	
   Given 	Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields without Authorization for UpdateProgramByName for program
   When  	Admin sends HTTPS Request with valid endpoint	without Authorization for UpdateProgramByName for program
   Then 	Admin receives FourHundredOne Unauthorized msg for UpdateProgramByName for program
  
  
