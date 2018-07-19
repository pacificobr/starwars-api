Feature: User can successfully get, create, delete, and update planets

  Scenario: User gets a created planet
    When the user creates an planet
     And the planet is successfully created
     And the user gets the created planet
    Then the user receives status code of 200
     And the retrieved planet is correct
  
  Scenario: User gets an existing planet
   Given an planet exists
    When the user gets the created planet
    Then the user receives status code of 200
     And the retrieved planet is correct
  
  Scenario: User deletes a created planet
   Given an planet exists
     And the user deletes the created planet
     And the user receives status code of 204
    When the user gets the created planet
    Then the user receives status code of 404 
    