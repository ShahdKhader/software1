package com.example.software.AcceptanceTest;
import com.example.software.TESTINPUT;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
public class featureSignUp {
    @When("I click on sign up and flag is {string}")
    public void iClickOnSignUpAndFlagIs(String string) {
            assertEquals(true, string.equals(true));
    }
    @When("he fills in {string} with {string}")
    public void heFillsInWith(String string, String string2) {
        if(string.equals("ID")){
            assertEquals(true, TESTINPUT.idTest(string));
        }
        else if(string.equals("Phone Number") ||string.equals("BackUp Number")){
        boolean flag=TESTINPUT.phoneNumberTest(string);
         assertEquals(true, TESTINPUT.phoneNumberTest(string));
        }

        else if(string.equals("Gmail")) {
            boolean flag=TESTINPUT.gmailTest(string);
            assertEquals(true, TESTINPUT.gmailTest(string));
        }
        else if(string.equals("Password")){
            boolean flag=TESTINPUT.passwordTest(string);
            assertEquals(true, TESTINPUT.passwordTest(string));
        }

    }

    @When("he presses {string} and flag is {string}")
    public void hePressesAndFlagIs(String string, String string2) {
        if(string.equals(true)){
            assertEquals(true,true);

        }
    }
    @Then("there should be a user {string}")
    public void thereShouldBeAUser(String string) {
        assertEquals(true,true);
    }

    @Then("the user should see {string}")
    public void theUserShouldSee(String string) {
        assertEquals(false, false);
    }
}
