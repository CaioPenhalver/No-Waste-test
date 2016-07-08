package features.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.page_objects.HomePage;
import support.page_objects.SignupFrame;

public class SignupStep {

	private HomePage homePage = new HomePage();
	private SignupFrame signupFrame;
	private String response;
	
	@Given("^I am on register form$")
	public void i_am_on_register_form() throws Throwable {
		signupFrame = homePage.clickOnSignup();
	}

	@When("^I fill in \"([^\"]*)\" in username field$")
	public void i_fill_in_in_username_field(String username) throws Throwable {
		signupFrame.setUsernameField(username);
	}

	@When("^I fill in \"([^\"]*)\" in firstname field$")
	public void i_fill_in_in_firstname_field(String firstname) throws Throwable {
	    signupFrame.setFirstNameField(firstname);
	}

	@When("^I fill in \"([^\"]*)\" in lastname field$")
	public void i_fill_in_in_lastname_field(String lastname) throws Throwable {
	    signupFrame.setlastNameField(lastname);
	}

	@When("^I fill in \"([^\"]*)\" in password field$")
	public void i_fill_in_in_password_field(String password) throws Throwable {
	    signupFrame.setPasswordField(password);
	}
	
	@When("^I fill in \"([^\"]*)\" in password confirmation field$")
	public void i_fill_in_in_password_confirmation_field(String password) throws Throwable {
		signupFrame.setPasswordConfirmationField(password);
	}

	@When("^I click on sing-up button$")
	public void i_click_on_sing_up_button() throws Throwable {
	    response = signupFrame.register();
	}

	@Then("^I should see \"([^\"]*)\" message$")
	public void i_should_see_message(String message) throws Throwable {
	    assertThat(message, equalTo(response));
	}
}
