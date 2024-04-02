@Program
Feature: Delete Program By Id

  @Program
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
