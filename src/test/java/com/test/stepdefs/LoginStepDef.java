package com.test.stepdefs;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.basetest.BaseClass;
import com.test.hooks.Hooks;
import com.test.pages.LandingPage;
import com.test.pages.LoginPage;
import com.test.pages.RegisterPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDef extends BaseClass {
	public RegisterPage registerPage=new RegisterPage(driver);
	public LoginPage loginPage = new LoginPage(driver);
	public LandingPage landingPage = new LandingPage(driver);

	@When("^I click on register link$")
	public void i_click_on_register_link() throws Throwable {
		loginPage.clickRegisterLink();
	}

	@Then("^I should see registration form displayed$")
	public void i_should_see_registration_form_displayed() throws Throwable {
		Assert.assertTrue("Registartion form not displayed",
				wait.until(ExpectedConditions.visibilityOf(registerPage.registerForm)).isDisplayed());
	}

	@Given("^I am a Valid user$")
	public void i_am_a_Valid_user() throws Throwable {
		
	}

	@When("^I login to application$")
	public void i_login_to_application() throws Throwable {
		loginPage.enterUserName("atulluta").enterPassword("ab00338092").clickLoginButton();
	}

	@Then("^I should see logout option$")
	public void i_should_see_logout_option() throws Throwable {
		Assert.assertTrue("Registartion form not displayed",
				wait.until(ExpectedConditions.visibilityOf(landingPage.logoutLink)).isDisplayed());
	}
}
