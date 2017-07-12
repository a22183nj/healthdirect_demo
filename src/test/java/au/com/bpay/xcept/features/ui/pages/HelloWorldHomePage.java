package au.com.bpay.xcept.features.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HelloWorldHomePage extends PageObject {
	@FindBy(id = "bylocation")
	private WebElementFacade mByLocation;

	@FindBy(xpath = "//input[@id='byname']")
	private WebElementFacade mByName;

	@FindBy(id = "serviceLRadio-Allied Health and Therapy Services0")
	private WebElementFacade mAlliedHealthTherapy;

	@FindBy(id = "edit-location")
	private WebElementFacade mLocation;

	@FindBy(css = "#finders_tabs > div > ul > li:nth-child(1) > a")
	private WebElementFacade mHelpAtHomeTab;

	@FindBy(css = "input[type='submit']")
	private WebElementFacade mSearchButton;
	
	// search result where location is shown after 'Providers of Allied Health
	// and Therapy Services near'
	@FindBy(css = ".help-at-home-results-header > div:nth-child(4) > div:nth-child(1) > strong:nth-child(1)")
	private WebElementFacade mSearchLocation;

	public void maximizeWindow() {
		WebDriver driver = getDriver();
		driver.manage().window().maximize();
	}

	public String getSearchResultLocation() {
		WebDriver driver = getDriver();
		driver.switchTo().frame("content");
		String searchResultLocation = mSearchLocation.getText();
		System.out.println("searchResultLocation value is: " + searchResultLocation);
		driver.switchTo().defaultContent();
		return searchResultLocation;
	}

	public void clickSearchButton() {
		WebDriver driver = getDriver();
		driver.switchTo().frame("content");
		mSearchButton.waitUntilClickable().click();
		driver.switchTo().defaultContent();
	}

	public void selectTab(String tab) {
		WebDriver driver = getDriver();
		
		switch (tab) {
		case "Help at home":
			driver.switchTo().frame("content");
			mHelpAtHomeTab.waitUntilClickable().click();
			driver.switchTo().defaultContent();
			break;
		// add other tabs here
		default:
			throw new IllegalArgumentException("Invalid tab name: " + tab);
		}
	}

	public void enterPostcodeSuburb(String location) {
		WebDriver driver = getDriver();
		driver.switchTo().frame("content");
		mLocation.waitUntilClickable().clear();
		mLocation.sendKeys(location);
		waitABit(1000);
		mLocation.sendKeys(Keys.DOWN);
		mLocation.sendKeys(Keys.RETURN);
		driver.switchTo().defaultContent();
	}

	public void selectServiceType(String serviceType) {
		WebDriver driver = getDriver();
		switch (serviceType) {
		case "Allied Health and Therapy Services":
			driver.switchTo().frame("content");
			mAlliedHealthTherapy.waitUntilClickable().click();
			driver.switchTo().defaultContent();
			break;
		// add other service type here
		default:
			throw new IllegalArgumentException("Invalid service type: "
					+ serviceType);
		}
	}

	public void selectLocationOrName(String locationOrName) {
		WebDriver driver = getDriver();
		switch (locationOrName) {
		case "Location":
			driver.switchTo().frame("content");
			mByLocation.waitUntilClickable().click();
			driver.switchTo().defaultContent();
			break;
		// add Name here
		default:
			throw new IllegalArgumentException("Invalid search by type: "
					+ locationOrName);
		}
	}
}
