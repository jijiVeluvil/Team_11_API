@UserLogin
Feature: LMS API UserLogin

  @User_Login
  Scenario: User login with valid credentials
    Given Admin creates POST Request  with valid credentials for login. 
    	|email                 |  password           |
    	|numpyninja@gmail.com  | lmsHackathon@2024   |
    When Admin creates Post Https method  with valid endpoint for login.
    Then Admin User receives the bearer token for login.
    
       @User_Login_InvaliCredentials_InvalidEndPoint
	 Scenario: Check if Admin able to generate token with invalid endpoint
	   Given Admin creates POST Request  with valid credentials for login. 
    	|email                 |  password           |
	    	|numpyninja@gmail1.com  | lmsHackathon@2024   |
	  When Admin calls Post Https method with invalid endpoint for login
	  Then Admin receives 401 unauthorized for login
	  
	  @User_Login_InvalidCredentials_WithOutEmail
	  Scenario: Check if Admin able to generate token with invalid credentials
	  Given Admin creates POST request with out Email 
	  |email                 |  password           |
    |                      | lmsHackathon@2024   |
	  When Admin creates Post Https method  with valid endpoint for login.
	  Then Admin receives 400 Bad request for login
    
    @User_Login_InvalidCredentials_WithOutPassword
	  Scenario: Check if Admin able to generate token with invalid credentials
	  Given Admin creates POST request with out Password
	  |email                 |  password           |
    |numpyninja@gmail1.com|                      |
	  When Admin creates Post Https method  with valid endpoint for login.
	  Then Admin receives 400 Bad request for login
	  
	   @User_Login_InvalidCredentials_WithOutValidFields
	  Scenario: Check if Admin able to generate token with invalid credentials
	  Given Admin creates POST request with out fields for login
	  |email                 |  password           |
	  When Admin creates Post Https method  with valid endpoint for login.
	  Then Admin receives 400 Bad request for login
    
    
    
    
    
    
    
 