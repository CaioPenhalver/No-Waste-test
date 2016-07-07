package support.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FactoryDriver {

	private static WebDriver driver;
	
	private FactoryDriver() {}
	
	public static WebDriver getInstance(){
		if(driver == null){
			synchronized(WebDriver.class){
				if(driver == null){
					System.setProperty(
							"webdriver.chrome.driver", 
							System.getProperty("user.dir")
							+"/drivers/chromedriver");
					driver = new ChromeDriver();
				}
			}
		}
		return driver;
	}

}
