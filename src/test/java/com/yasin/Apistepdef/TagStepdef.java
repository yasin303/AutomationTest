package com.yasin.Apistepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Api.ApiPage;

public class TagStepdef {

    ApiPage apiPage;

    public TagStepdef(){
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for tag {string}")
    public void prepareUrlFor(String url) {
        apiPage.urlFor(url);
    }

    @And("input tag valid API key in header {string}")
    public void inputValidAPIKeyInHeader(String appId) {
        String apiKey = "65aa383a388ff105f776f3f6";
        apiPage.addHeader(appId, apiKey);
        // System.out.println(appId + " = " + apiKey);
    }

    @When("hit GET list tags")
    public void hitGETListTags() {
        apiPage.hitGetTag();
    }

    @Then("validation tag status code is equals {int}")
    public void validationStatusCodeIsEquals(int statuscode) {
        apiPage.validateStatusCode(statuscode);
    }

    @Then("validation tag response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String schemaFile) {
        apiPage.validateJson(schemaFile);
    }
}
