package au.com.bpay.xcept.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features={"src/test/resources/features/hello_world/Hello_World_UI.feature"}, tags={"~@ignore","~@manual","~@wip"})
public class AcceptanceTests {}
