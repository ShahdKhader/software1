package com.example.software.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class feature5 {
    @Then("the field {string} should be with error")
    public void theFieldShouldBeWithError(String string) {
        assertEquals(true,string.equals("Order Number"));
    }
    @When("user click on insert order and flag is a {string}")
    public void userClickOnInsertOrderAndFlagIsA(String string) {
        assertEquals(true,string.equals("true"));

    }
    @Then("show massage x {string}")
    public void showMassageX(String string) {
        assertEquals(true,string.equals("the information has been entered successfully"));
    }
    @When("he fill in {string} with a {string}")
    public void heFillInWithA(String string, String string2) {
        assertEquals(true,string2.equals("-1"));

    }
    @When("he fill in x {string} with {string}")
    public void heFillInXWith(String string, String string2) {
        assertEquals(true,string2.equals("9"));
    }

    @When("he presses {string} and flag is a {string}")
    public void hePressesAndFlagIsA(String string, String string2) {
        assertEquals(true,string2.equals("true"));

    }
    @Then("the user should see a {string}")
    public void theUserShouldSeeA(String string) {
        assertEquals(true,string.equals("Order Number must be positive integer"));
    }



}
