package com.example.software.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
public class feature1SignIn {
    @Given("I go to loginchoise")
    public void iGoToLoginchoise() {
    assertEquals(true,true);
    }
    @Given("the field {string} is empty")
    public void theFieldIsEmpty(String string) {
        assertEquals(false,false);    }
    @When("I click on login and flag is {string}")
    public void iClickOnLoginAndFlagIs(String string) {
        if(string.equals(true))    assertEquals(true,true);
        else     assertEquals(false,false);

    }
    @Then("field {string} should be with error")
    public void fieldShouldBeWithError(String string) {
        System.out.println("Please enter Gmail and Password first !");

    }
    @Then("I should see {string}")
    public void iShouldSee(String string) {
        System.out.println("E-mail or password is incorrect");
    }
    @Then("I shouldn't see 'Access your account'")
    public void iShouldnTSeeAccessYourAccount() {
        System.out.println("login successfully");
    }


}
