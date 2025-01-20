package com.yasin.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.yasin.Webstepdef"},
        features = "src/test/resources/webfeature",
        tags = "@web",
        plugin = {"pretty", "html:reports/web/report.html", "json:reports/web/report.json"}
)
public class CucumberWebRunner {
}
