@Program
Feature: Post Request Program

  @Program
  Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization for Program 
    Given Admin creates POST Request for the LMS with request body with Authorization for PostReqProgram . 
   When Admin sends HTTPS Request and  request Body with endpoint with Authorization  for PostReqProgram.
    Then Admin receives twohundredOne Created Status with response body for PostReqProgram.
   
   Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization for Program ID 
    Given Admin creates POST Request for the LMS with request body with Authorization for PostReqProgram ID . 
   When Admin sends HTTPS Request and  request Body with endpoint with Authorization  for PostReqProgram ID.
    Then Admin receives twohundredOne Created Status with response body for PostReqProgram ID.
    
   Scenario: Check if Admin able to create a program with valid endpoint and request body without Authorization 
    Given Check if Admin able to create a program with valid endpoint and request body without Authorization for PostReqProgram
    When Admin creates POST Request for the LMS with request body for PostReqProgram with no Auth
    Then Admin sends HTTPS Request and  request Body with endpoint	Admin receives fourNotOne Unauthorized for PostReqProgram 
    
    Scenario: Check if Admin able to create a program with invalid endpoint
 Given Admin creates POST Request for the LMS with request body invalid endpoint for PostReqProgram
  When Admin sends HTTPS Request and  request Body with invalid endpoint for PostReqProgram
  Then Admin receives fourNotFour not found  Status with message and boolean success details for PostReqProgram
    
   Scenario: Check if Admin able to create a program with already existing program name
 Given Admin creates POST Request for the LMS with request body with already existing program name for PostReqProgram
  When Admin sends HTTPS Request and  request Body with endpoint with already existing program name for PostReqProgram
  Then Admin receives fourhundred Bad Request Status with message and boolean success details for PostReqProgram
  
 Scenario: Check if Admin able to create a program with invalid method for Program	
  Given Admin creates POST Request for the LMS with request body with invalid method for PostReqProgram
  When Admin sends HTTPS Request and  request Body with endpoint for PostReqProgram with invalid method
  Then Admin receives  fourNotFive Method Not Allowed with invalid method for PostReqProgram
  
  Scenario: Check if Admin able to create a program with invalid request body 
  Given Admin creates POST Request for the LMS with invalid request body ith invalid request body  for Program
  When Admin sends HTTPS Request and  request Body with endpoint for PostReqProgram with invalid request body
  Then Admin receives fourhundred Bad Request Status with invalid request body for PostReqProgram for PostReqProgram
   
  Scenario: Check if Admin able to create a program with missing values in the request body
  Given Admin creates POST Request for the LMS with request body with missing values in the request body for PostReqProgram
  When Admin sends HTTPS Request and  request Body with endpoint with missing values in the request body for PostReqProgram
  Then Admin receives fourhundred Bad Request Status  with missing values in the request body for PostReqProgram
  
  
  Scenario: Check if Admin able to create a program with missing additional field
  Given Admin creates POST Request for the LMS with request body for PostReqProgram
  When Admin sends HTTPS Request and  request Body with endpoint with missing additional field for PostReqProgram
  Then Admin receives twohundredOne ok for Program for PostReqProgram
  
  
  
  
  
 