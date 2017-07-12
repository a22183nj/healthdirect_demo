package au.com.bpay.xcept.features.ui.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import au.com.bpay.xcept.features.ui.pages.HelloWorldHomePage;

public class HelloWorldPageSteps extends ScenarioSteps {

	private HelloWorldHomePage homePage;

	@Step
	public void verifySearchResult(String location) {
		String searchResultLocation = homePage.getSearchResultLocation();
		Assert.assertEquals(location, searchResultLocation);
	}
	
	@Step
	public void clickSearchButton() {
		homePage.clickSearchButton();
	}
	
	@Step
	public void selectTab(String tab) {
		homePage.selectTab(tab);
	}
	
	@Step
	public void enterPostcodeSuburb(String location) {
		homePage.enterPostcodeSuburb(location);
	}
	
	@Step
	public void loadHelloWorldHomePage() {
		String pageUrl = "https://www.myagedcare.gov.au/service-finder";
		homePage.openAt(pageUrl);
		homePage.maximizeWindow();
	}
	
	@Step
	public void selectLocationOrName(String locationOrName) {
		homePage.selectLocationOrName(locationOrName);
	}
	
	@Step
	public void selectServiceType(String serviceType) {
		homePage.selectServiceType(serviceType);
	}
}
