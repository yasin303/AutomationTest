@api
Feature: DummyAPI User and Tag

  Scenario: Get user by valid ID
    Given prepare url for "CREATE_USER"
    And input valid API key in header "app-id"
    When hit POST request with valid data
    And validation response body post create
    Then prepare url for "GET_USER_BY_ID"
    And input valid API key in header "app-id"
    When hit GET request with user ID
    Then validation status code is equals 200
    Then validation response json with JSONSchema "get_user_by_id.json"

  Scenario: Create new user successfully
    Given prepare url for "CREATE_USER"
    And input valid API key in header "app-id"
    When hit POST request with valid data
    Then validation status code is equals 200
    And validation response body post create
    Then validation response json with JSONSchema "create_user.json"

  Scenario: Update existing user
    Given prepare url for "CREATE_USER"
    And input valid API key in header "app-id"
    When hit POST request with valid data
    And validation response body post create
    Then prepare url for "UPDATE_USER"
    And input valid API key in header "app-id"
    When hit PUT request with update data
    Then validation status code is equals 200
    Then validation response json with JSONSchema "update_user.json"

  Scenario: Delete existing user
    Given prepare url for "CREATE_USER"
    And input valid API key in header "app-id"
    When hit POST request with valid data
    And validation response body post create
    Then prepare url for "DELETE_USER"
    And input valid API key in header "app-id"
    Then hit DELETE request with valid user ID
    Then validation status code is equals 200

  Scenario: Get list of tags
    Given prepare url for tag "GET_LIST_TAGS"
    And input tag valid API key in header "app-id"
    When hit GET list tags
    Then validation tag status code is equals 200
    Then validation tag response json with JSONSchema "get_list_tags.json"