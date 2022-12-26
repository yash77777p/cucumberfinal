package steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseClass {

	public WebDriver driver;
	Properties prop;
	String homePageURL;

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		
		try {
		prop = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\config\\config.properties");
		prop.load(fp);

		String browser = prop.getProperty("browser");
		homePageURL = prop.getProperty("url");
		//prop.setProperty("name", "yogendra");

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					((System.getProperty("user.dir") +"\\WebDriver\\chromedriver_105\\chromedriver.exe")));
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					((System.getProperty("user.dir") +"\\WebDriver\\geckodriver.exe")));
			driver = new FirefoxDriver();
			// Need to handle firefox driver code
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS );
		
		System.out.println("Before scenario global hook executed");
		}
		catch(IOException e) {
			e.getMessage();
		}
	}

	@After
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			//Take Screenshot
			final byte[] scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getName());
		}
			driver.close();
			
			System.out.println("After scenario global hook executed");
	}
	
	
	public WebDriver getwebdriver() {
		return driver;
	}
	
	
	public String gethomepageurl(){
		return homePageURL;
	}
	

}
