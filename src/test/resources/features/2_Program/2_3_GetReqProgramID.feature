@Program
Feature: GET REQUEST by program ID

  #GET REQUEST (program ID)
  @Program
  Scenario: Check if Admin able to retrieve a program with valid program ID
    Given Admin creates GET Request for the LMS API with valid program for GetReqProgramID for program
    When Admin sends HTTPS Request with endpoint with valid program ID for post req Program for GetReqProgramID for program
    Then Admin receives TwoHundred OK Status with response body for post req Program for GetReqProgramID for program

  Scenario: Check if Admin able to retrieve a program with invalid program ID
    Given Admin creates GET Request for the LMS API with invalid program ID for post req Program for GetReqProgramID for program
    When Admin sends HTTPS Request with endpoint with invalid program ID for post req Program for GetReqProgramID for program
    Then Admin receives FourNotFour Not Found Status with message and boolean success details for post req Program for GetReqProgramID for program

  Scenario: Check if Admin able to retrieve a program with invalid baseURI
    Given Admin creates GET Request for the LMS API with invalid baseURI for GetReqProgramID for program
    When Admin sends HTTPS Request with endpoint for post req Program with invalid baseURI for GetReqProgramID for program
    Then Admin receives FourNotFour Not Found Status with message and boolean success details  due to  invalid baseURI for post req Program for GetReqProgramID for program

  Scenario: Check if Admin able to retrieve a program without Authorization
    Given Admin creates GET Request for the LMS API without Authorization for GetReqProgramID for program
    When Admin sends HTTPS Request with endpoint for Program without Authorization for post req Program for GetReqProgramID for program
    Then Admin receives FourHundredOne Unauthorized for Program for post req Program for GetReqProgramID for program

  Scenario: Check if Admin able to retrieve a program with invalid Endpoint
    Given Admin creates GET Request for the LMS API with invalid Endpoint	 for Program for GetReqProgramID for program
    When Admin sends HTTPS Request with endpoint with invalid Endpoint for post req Program for GetReqProgramID for program
    Then Admin receives FourNotFour Not Found Status with message and boolean success details for GetReqProgramID for program
