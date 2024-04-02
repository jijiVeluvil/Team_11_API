@Program
Feature: Delete by Program Name

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
