Feature: User API tests


  Scenario: Verify ability to remove existing user from the system
    Given create new user with firstName "firstName", lastName "lastName", userName "username"
    When a client deletes a user with "username" from the system
    Then verify that user with "username" has been deleted
