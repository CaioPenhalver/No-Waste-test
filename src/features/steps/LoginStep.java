package features.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.page_objects.AgendaPage;
import support.page_objects.HomePage;

public class LoginStep {

	private HomePage homePage = new HomePage();
	private AgendaPage agendaPage;

	@Given("^I am on HomePage$")
	public void i_am_on_HomePage() throws Throwable {
	    assertThat("http://nowaste.mybluemix.net/#/", equalTo(homePage.getHomePageUrl()));
	}

	@When("^I fill in \"([^\"]*)\" in the field username$")
	public void i_fill_in_in_the_field_username(String username) throws Throwable {
	    homePage.setUsername(username);
	}

	@When("^I fill in \"([^\"]*)\" in the field password$")
	public void i_fill_in_in_the_field_password(String password) throws Throwable {
	    homePage.setPassword(password);
	}

	@When("^I click on Log in$")
	public void i_click_on_Log_in() throws Throwable {
	    agendaPage = homePage.login();
	    assertThat("Dont be redirected!", agendaPage != null);
	}

	@Then("^I should be redirect to AngendaPage$")
	public void i_should_be_redirect_to_AngendaPage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
