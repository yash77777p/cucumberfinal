package pages_actions;

import org.openqa.selenium.WebDriver;
import steps.BaseClass;

public class Common_Actions {

	WebDriver driver;
	BaseClass base;
	static int PAGE_LOAD_TIMEOUT = 20;
	static int IMPLICIT_WAIT = 30;

	public Common_Actions(BaseClass base) {
		this.driver = base.getwebdriver();
		this.base = base;
	}

	
	//to get the current url
	public String getcurrenturl() {
		return driver.getCurrentUrl();

	}

	//to get the page title
	public String getcurrenttitle() {
		return driver.getTitle();

	}

	//to launch the application
	public void launchApplication(String url) {
		driver.get(url);
		driver.manage().deleteAllCookies();

	}

}
