package com.yasin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.yasin"},
        features = "classpath:features",
        plugin = {"pretty","html:reports/report.html", "json:reports/report.json"}
)

public class CucumberTest {

}
