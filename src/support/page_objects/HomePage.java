package support.page_objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.driver.FactoryDriver;

public class HomePage {

	private WebDriver driver;

	@FindBy(how=How.NAME, using="password")
	private WebElement passwordField;

	@FindBy(how=How.NAME, using="username")
	private WebElement usernameField;

	@FindBy(how=How.CSS, using="[ng-disabled='!loginForm.$valid']")
	private WebElement loginButton;

	@FindBy(how=How.ID, using="facebook-button")
	private WebElement facebookButton;

	public HomePage() {
		driver = FactoryDriver.getInstance();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		driver.get("http://nowaste.mybluemix.net/");
	}

	public String getHomePageUrl(){
		return driver.getCurrentUrl();
	}

	public HomePage setPassword(String password){
		passwordField.sendKeys(password);
		return this;
	}

	public HomePage setUsername(String username){
		usernameField.sendKeys(username);
		return this;
	}

	public AgendaPage login(){
		loginButton.click();
		try {
			if((new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.getCurrentUrl().contains("agenda");
				}
			})){
				return new AgendaPage(driver.getCurrentUrl());
			}
		} catch (TimeoutException e) {
			return null;
		}
		return null;
	}
}
