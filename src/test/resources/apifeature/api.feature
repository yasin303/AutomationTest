@api
Feature: DummyAPI User and Tag

  Scenario: Get user by valid ID
    #    "https://dummyapi.io/data/v1/user/{id}"
    Given prepare url for "GET_USER_BY_ID"
    And input valid API key in header "app-id"
    When hit GET request with valid user ID
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_user_by_id.json"

  Scenario: Create new user successfully
    #    "https://dummyapi.io/data/v1/user/create"
    Given prepare url for "CREATE_USER"
    And input valid API key in header "app-id"
    When hit POST request with valid data:
      | firstName | lastName | email              |
      | John      | Doe      | john.doe@email.com |
    Then validation status code is equals 201
    Then validation response json with JSONSchema "create_user.json"

  Scenario: Update existing user
    #    "https://dummyapi.io/data/v1/user/{id}"
    Given prepare url for "UPDATE_USER"
    And input valid API key in header "app-id"
    When hit PUT request with update data:
      | firstName | lastName |
      | Jane      | Smith   |
    Then validation status code is equals 200
    Then validation response json with JSONSchema "update_user.json"

  Scenario: Delete existing user
    #    "https://dummyapi.io/data/v1/user/{id}"
    Given prepare url for "DELETE_USER"
    And input valid API key in header "app-id"
    When hit DELETE request with valid user ID
    Then validation status code is equals 200
    And response confirms user deletion

  Scenario: Get list of tags
    #    "https://dummyapi.io/data/v1/tag"
    Given prepare url for "GET_LIST_TAGS"
    And input valid API key in header "app-id"
    When hit GET list tags
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_list_tags.json"