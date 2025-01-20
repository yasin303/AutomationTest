package com.yasin.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.yasin.Apistepdef"},
        features = "src/test/resources/apifeature",
        tags = "@api",
        plugin = {"pretty", "html:reports/api/report.html", "json:reports/api/report.json"}
)

public class CucumberApiRunner {

}
