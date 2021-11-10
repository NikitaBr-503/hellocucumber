Feature: User API tests


  Scenario Outline: Verify ability to remove existing user from the system
    Given create new user with firstName "<firstName>", lastName "lastName", userName "<userName>"
    When a client deletes a user with "<userName>" from the system
    Then verify that user with "<userName>" has been deleted

    Examples:
      | firstName | userName     |
      | Nikita    | qwqwqwqwqw12 |
      | James     | cmvbcmv      |