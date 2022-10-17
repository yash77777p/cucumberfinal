package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TicketHome_Elements {

	WebDriver driver;
	
	//@CacheLookup
	@FindBy(xpath="//a[@Class=\"HcPVsG_text HcPVsG_variant_invert HcPVsG_size_b3 HcPVsG_weight_bold\" and contains(text(),\"Login\")]") public WebElement loginlink;
	//a[@class="HcPVsG_text HcPVsG_variant_highEmphasis HcPVsG_size_b3 HcPVsG_weight_bold"][3]
	//
	//@FindBy(linkText="Login") public WebElement loginlink;
	@FindBy(xpath="//input[@name=\"username\"]") public WebElement usernamefld;
	@FindBy(xpath="//button[text()=\"Continue\"]") public WebElement contbtn;
	@FindBy(xpath="//input[@name=\"password\"]") public WebElement passwd;
	@FindBy(xpath="//button[text()=\"Log in\"]") public WebElement loginbtn;
	//@FindBy(xpath="//div[contains(text(),\"match\")]") public WebElement erromsg;
	//@FindBy(xpath="//div[contains(text(),\"reached\")]") public WebElement erromsg1;
	@FindBy(xpath="//div[@class=\"alert-item\"]") public WebElement erromsg;
	//@FindBy(xpath="//span[@class=\"User_avatar__cMv7Q User_LV1__k5FOy HcPVsG_text HcPVsG_size_b2 HcPVsG_weight_bold\"]") public WebElement profileicon;
	@FindBy(xpath="//*[@id=\"__next\"]/main/div[2]/header/div/div[2]/header/div/div/div[2]/div[3]/span") public WebElement profileicon;
	@FindBy(xpath="//body[1]/div[1]/main[1]/div[2]/header[1]/div[1]/div[2]/header[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/span[1]") public WebElement profilename;
	//@FindBy(xpath="//span[@class=\"HcPVsG_text HcPVsG_size_b1 HcPVsG_weight_bold\" and text()=\"yog patil\"]") public WebElement profilename;
	
	@FindBy(xpath="//a[text()=\"Log Out\"]")  public WebElement logoutlink; 
	
	
	public TicketHome_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	
}
