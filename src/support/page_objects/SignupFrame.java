package support.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import support.driver.FactoryDriver;

public class SignupFrame {

	private WebDriver driver = FactoryDriver.getInstance();
	
	@FindBy(how=How.ID, using="userName")
	private WebElement usernameField;
	
	@FindBy(how=How.ID, using="firstName")
	private WebElement firstNameField;
	
	@FindBy(how=How.ID, using="lastName")
	private WebElement lastNameField;
	
	@FindBy(how=How.ID, using="password")
	private WebElement passwordField;
	
	@FindBy(how=How.ID, using="passwordConfirmation")
	private WebElement passwordConfirmationField;
	
	@FindBy(how=How.CSS, using="[ng-click='signUpForm.$setPristine()']")
	private WebElement SignupButton;
	
	public SignupFrame() {
		PageFactory.initElements(driver, this);
	}

	public String register(){
		String message = "Nothing happens!";
		SignupButton.click();
		try {
			message = driver.findElement(By.cssSelector("[ng-if='registrationMsg().success']"))
			.getText();
		} catch (NoSuchElementException e) {
			message = driver.findElement(By.cssSelector("[ng-if='registrationMsg().error']"))
			.getText();
		}
		return message;
	}
	
	public SignupFrame setUsernameField(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public SignupFrame setFirstNameField(String firstName) {
		firstNameField.sendKeys(firstName);
		return this;
	}

	public SignupFrame setlastNameField(String lastName) {
		lastNameField.sendKeys(lastName);
		return this;
	}

	public SignupFrame setPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}
	
	public SignupFrame setPasswordConfirmationField(String password){
		passwordConfirmationField.sendKeys(password);
		return this;
	}
}
