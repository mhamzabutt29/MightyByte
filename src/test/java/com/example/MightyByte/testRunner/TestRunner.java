package com.example.MightyByte.testRunner;

import com.example.MightyByte.MightyByteApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@SpringBootTest(classes = {MightyByteApplication.class})
@CucumberOptions(
        features = "src/test/resources/Features/login.feature",
        glue = {"classpath:com.example.MightyByte.stepDefinitions"},
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports.html"},
        monochrome = true
)

public class TestRunner {

}


