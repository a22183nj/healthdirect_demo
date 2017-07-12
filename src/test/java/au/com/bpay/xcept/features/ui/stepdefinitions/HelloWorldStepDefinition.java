package au.com.bpay.xcept.features.ui.stepdefinitions;

import net.thucydides.core.annotations.Steps;
import au.com.bpay.xcept.features.ui.steps.HelloWorldPageSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HelloWorldStepDefinition {
    @Steps
    HelloWorldPageSteps mHelloWorldPageSteps;

    @Given("^user select a tab \"([^\"]*)\"$")
    public void user_select_a_tab(String tab) throws Throwable {
    	mHelloWorldPageSteps.selectTab(tab);
    }
    
    @Given("^user navigate to service finder page$")
    public void user_navigate_to_service_finder_page() throws Throwable {
    	mHelloWorldPageSteps.loadHelloWorldHomePage();
    }
    
    @Given("^user select search by \"([^\"]*)\" in step one$")
    public void user_select_search_by_in_step_one(String locationOrName) throws Throwable {
    	mHelloWorldPageSteps.selectLocationOrName(locationOrName);
    }
    
    @Given("^user enter location \"([^\"]*)\" in step one$")
    public void user_enter_location_in_step_one(String location) throws Throwable {
    	mHelloWorldPageSteps.enterPostcodeSuburb(location);
    }
    
    @Given("^user select service type \"([^\"]*)\" in step two$")
    public void user_select_service_type_in_step_two(String serviceType) throws Throwable {
    	mHelloWorldPageSteps.selectServiceType(serviceType);
    }
    
    @Given("^user click search button$")
    public void user_click_search_button() throws Throwable {
    	mHelloWorldPageSteps.clickSearchButton();
    }
    
    @Then("^user should see search result shown for \"([^\"]*)\"$")
    public void user_should_see_search_result_shown_for(String location) throws Throwable {
    	mHelloWorldPageSteps.verifySearchResult(location);
    }
}
