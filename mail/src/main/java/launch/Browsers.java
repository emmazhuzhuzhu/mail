package launch;

import org.openqa.selenium.WebDriver;


public class Browsers {

	private static WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
	
	public Browsers(BrowserType browserType){
		switch(browserType){
		case firefox:
			
			
		case ie:
		
		case chrome:
			System.setProperty("webdriver.chrome.driver", "");
			
		case safari:
			
		
		
		}
		
	}
}
