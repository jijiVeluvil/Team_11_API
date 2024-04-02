@Program
Feature: Get All Programs With Admins

  @Program
  Scenario:  Check if Admin able to retrieve all programs with valid Endpoint	 
    Given   Admin creates GET Request for the LMS API for Program with valid endpoint for Get All Programs With Admins
   When     Admin sends HTTPS Request with valid endpoint	 for Program for Get All Programs With Admins
    Then   	Admin receives TwoHundred OK Status with response body for Program for Get All Programs With Admins.                                                          

Scenario: Check if Admin able to retrieve all programs with invalid Endpoint 	
    Given 	Admin creates GET Request for the LMS API with invalid Endpoint for Program for Get All Program With Admins
		When sends HTTPS Request  with invalid Endpoint  for Get All Programs With Admins 
    Then  	Admin receives FourNotFour Not Found Status with error message for Program for Get All Programs With Admins

Scenario: Check if Admin able to retrieve all programs with invalid Method
    Given Admin creates GET Request for the LMS API	with invalid Method for Program for GetAllProgramsWithAdmins
	When   Admin sends HTTPS Request with endpoint  with invalid Method for Get All Programs With Admins
    Then  Admin receives FourNotFive Method Not Allowed for Program for Get All Programs With Admins

Scenario: Check if Admin able to retrieve all programs without Authorization	 
    Given Admin creates GET Request for the LMS API without Authorization for Program for Get All Programs With Admins
	When   Admin sends HTTPS Request with endpoint for  program without Authorization for Get All Programs With Admins
    Then  Admin receives FourHundredOne Status with response body as Unauthorized for Program for Get AllPrograms With Admins
  
