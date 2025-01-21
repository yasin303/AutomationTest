package com.yasin.Apistepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Api.ApiPage;

public class UserStepdef {

    ApiPage apiPage;

    public UserStepdef(){
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.urlFor(url);
    }

    @And("input valid API key in header {string}")
    public void inputValidAPIKeyInHeader(String appId) {
        String apiKey = "65aa383a388ff105f776f3f6";
        apiPage.addHeader(appId, apiKey);
    }

    @When("hit POST request with valid data")
    public void hitPOSTRequestWithValidData() {
        apiPage.hitPostCreateUser();
    }

    @Then("hit DELETE request with valid user ID")
    public void hitDELETERequestWithValidUserID() {
        apiPage.hitDeleteUser();
    }

    @When("hit PUT request with update data")
    public void hitPUTRequest() {
        apiPage.hitUpdateUser();
    }

    @When("hit GET request with user ID")
    public void hitGETRequestWithUserID() {
        apiPage.hitGetUserId();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statuscode) {
        apiPage.validateStatusCode(statuscode);
    }

    @And("validation response body post create")
    public void validationResponseBodyPostCreate() {
        apiPage.validateResponseBody();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String schemaFile) {
        apiPage.validateJson(schemaFile);
    }
}
