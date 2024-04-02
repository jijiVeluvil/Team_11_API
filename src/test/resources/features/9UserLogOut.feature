
#User LogOut

Feature: Get LogOut

@Check_if_Admin_able_to_logout_with_authorization
Scenario: Check if Admin able to logout with authorization
   Given Admin creates request with authorization for LogOut
   When Admin calls Get Https method with valid endpoint
   Then  Admin receives 200 ok  and response with "Logout successful"
   
@Check_if_Admin_able_to_logout_with_invalid_endpoint
Scenario: Check if Admin able to logout with invalid endpoint
    Given Admin creates request with authorization for LogOut
    When Admin calls Get Https method withinvalid endpoint
    Then Admin receives 404 Not found for logout
    
@Check_if_Admin_able_to_logout_without_no_authorization 
Scenario: Check if Admin able to logout without no authorization
   Given Admin creates request without no authorization
   When Admin calls Get Https method with valid endpoint
   Then Admin receives 401  unauthorized forlogut

