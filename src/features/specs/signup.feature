@register
Feature: Register in the system
		As I user I want to register myself in 
		the system. So, I can use the services offered.
		
		Scenario Outline:
				Given I am on register form
				When I fill in "<username>" in username field
				And I fill in "<firstname>" in firstname field
				And I fill in "<lastname>" in lastname field
				And I fill in "<password>" in password field
				And I fill in "<password>" in password confirmation field
				And I click on sing-up button
				Then I should see "Your profile has been created!" message
				
				Examples: Ture cases
					|username	|firstname	|lastname	|password	|
					|caioo		|caio				|rodriguez|123456		|
					|CPR			|caio				|alonso		|123456		|