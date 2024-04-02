@Program

Feature: PUT REQUEST  Update program by ID

  @Program
  Scenario:  Check if Admin able to update a program with valid programID endpoint  and valid request body 
   Given  Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields for UpdateProgramById for Program
   When Admin sends HTTPS Request with valid endpoint and valid request body  valid programID endpoint  and valid request body for UpdateProgramById for Program
   Then  Admin receives TwoHundred OK Status with updated value in response body  valid programID endpoint  and valid request body for UpdateProgramById for Program                                                         

Scenario: Check if Admin able to update a program with invalid programID endpoint  and valid request body  
   Given Admin creates PUT Request for the LMS API invalid programID endpoint with valid request Body with mandatory , additional  fields for UpdateProgramById for Program
   When  Admin sends HTTPS Request with invalid programID endpoint with valid request Body with mandatory , additional  fields for UpdateProgramById for Program
   Then  Admin receives FourNotFour Not Found Status with message and boolean success details for Program for invalid programID endpoint  and valid request body for UpdateProgramById for Program
   
Scenario:  Check if Admin able to update a program with invalid request body 
   Given Admin creates PUT Request for the LMS API  with invalid request body for UpdateProgramById for Program
   When    Admin sends HTTPS Request with invalid endpoint with invalid request body  wid invalid request body for UpdateProgramById for Program
   Then  Admin receives FourHundredOne Bad Request Status with message and boolean success details with invalid request body for UpdateProgramById for Program

Scenario: Check if Admin able to update a program without request body  
   Given  Admin creates PUT Request for the LMS API  with missing mandatory fields for UpdateProgramById for Program
   When    Admin sends HTTPS Request with valid endpoint and with missing mandatory fields for UpdateProgramById for Program
   Then  Admin receives FourHundredOne Bad Request Status with message and boolean success details without request body for UpdateProgramById for Program
   
Scenario:   Check if Admin able to update a program with invalid baseURI
   Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields with invalid baseURI  for UpdateProgramById for Program
   When   Admin sends HTTPS Request with valid endpoint and with invalid baseURI for Program
   Then  Admin receives FourNotFour Not Found Status with message and boolean success details with invalid baseURI for UpdateProgramById for Program
   
Scenario: Check if Admin able to update a program with invalid method	Admin sets Authorization  for Program
   Given  Admin creates PUT Request for the LMS API endpoint with request Body for UpdateProgramById for Program
   When    Admin sends HTTPS Request with valid endpoint and invalid method for UpdateProgramById for Program
   Then  Admin receives FourNotFive Method Not Allowed for UpdateProgramById for Program
   
Scenario: Check if Admin able to update a program without Authorization  
   Given  Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields and without Authorizationfor UpdateProgramById for Program
   When   Admin sends HTTPS Request with valid endpoint and without Authorization for UpdateProgramById for Program
   Then  Admin receives FourHundredOne Unauthorized for UpdateProgramById for Program
   
