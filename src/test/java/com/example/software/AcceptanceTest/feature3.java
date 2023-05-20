package com.example.software.AcceptanceTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class feature3 {
    @When("user click on invoice and flag is {string}")
    public void userClickOnInvoiceAndFlagIs(String string) {
            assertEquals(true,string.equals("true"));
    }

}
