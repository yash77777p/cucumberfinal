package pages_actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import elements.TicketHome_Elements;
import steps.BaseClass;

public class TicketHomePage_Actions {

	WebDriver driver;
	BaseClass base;
	TicketHome_Elements tic_Home_Ele;

	public TicketHomePage_Actions(BaseClass base) {
		this.driver = base.getwebdriver();
		tic_Home_Ele = new TicketHome_Elements(driver);
		this.base = base;
	}

	public void gotothelandingpage() {
		String landingPageUrl = base.gethomepageurl();
		driver.get(landingPageUrl);
	}

	public void clickonloginlink() throws InterruptedException {

		tic_Home_Ele.loginlink.click();
		Thread.sleep(2000);
	}

	public void login(String username, String password) throws InterruptedException {
		tic_Home_Ele.usernamefld.sendKeys(username);
		tic_Home_Ele.contbtn.click();
		tic_Home_Ele.passwd.sendKeys(password);
		tic_Home_Ele.loginbtn.click();

		Thread.sleep(3000);
	}

	public String gettextafterlogin() throws InterruptedException {

		tic_Home_Ele.profileicon.click();
		Thread.sleep(1000);
		String text1 = tic_Home_Ele.profilename.getText();
		return text1;
	}

	public String gettextforinvalidlogin() {
		try {
		String  text2 = tic_Home_Ele.erromsg.getText();
		text2= text2.trim().toLowerCase();
		System.out.println(text2);
		return text2;	
		}
		catch(NoSuchElementException e) {
		    e.getMessage();
			return null;
		}
		
	}


}

