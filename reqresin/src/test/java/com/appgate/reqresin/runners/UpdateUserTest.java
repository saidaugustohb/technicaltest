package com.appgate.reqresin.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue="com.appgate.reqresin.definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        tags = "@UpdateUser")
public class UpdateUserTest {
}
