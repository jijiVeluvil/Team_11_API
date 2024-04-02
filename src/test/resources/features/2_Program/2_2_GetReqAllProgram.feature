@Program
Feature: Get Request All Program

  @Program
  Scenario: Check if Admin able to retrieve all programs with valid Endpoint for Program 
    Given Admin creates GET Request for the LMS API with valid Endpoint for GetReqAllProgram for Program . 
   When Admin sends HTTPS Request with valid endpoint for GetReqAllProgram for Program
    Then Admin receives TwoHundred OK Status with response body for Program for GetReqAllProgram for Program
   
 Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
    Given Admin creates GET Request for the LMS API with invalid Endpoint for GetReqAllProgram for Program
    When Admin sends HTTPS Request with endpoint for Program with invalid Endpoint for GetReqAllProgram for Program
    Then Admin receives FourNotFour not found  Status with error message for Program for GetReqAllProgram for Program
      
 Scenario: Check if Admin able to retrieve all programs with invalid Method
 Given Admin creates GET Request for the LMS API with invalid Method for GetReqAllProgram for Program
  When Admin sends HTTPS Request with endpoint for programs with invalid Method for GetReqAllProgram for Program
  Then Admin receives FourNotFive Method Not Allowed for Program with invalid Method for GetReqAllProgram for Program
  
 Scenario: 	Check if Admin able to retrieve all programs without Authorization
  Given Admin creates GET Request for the LMS API without Authorization for GetReqAllProgram for Program
  When Admin sends HTTPS Request with endpoint for Program without Authorization for GetReqAllProgram for Program
  Then Admin receives TwoHundredOne Status with response body as Unauthorized for GetReqAllProgram for Program
  
  
    
