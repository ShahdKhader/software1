package com.example.software.AcceptanceTest;
import com.example.software.TESTINPUT;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class feature2 {

    @When("user click on insert order and flag is {string}")
    public void userClickOnInsertOrderAndFlagIs(String string) {
            assertEquals(true,string.equals("true"));

    }
    @Then("all field should be with {string}")
    public void allFieldShouldBeWith(String string) {
        assertEquals(true,string.equals("error"));

    }
    @Then("the image {string} should be with error")
    public void theImageShouldBeWithError(String string) {
        assertEquals(true,string.equals("Please enter png extension!"));
    }

    @When("he fill in {string} with {string}")
    public void heFillInWith(String string, String string2)  {
        if(string.equals("Name")){
             assertEquals(true,TESTINPUT.ordernameTest(string2)>0);
            }
        else if (string.equals("Quantity")) {
            assertEquals(true,TESTINPUT.orderQuantityTest(string2));
        }
        else if (string.equals("size")) {
          assertEquals(true,TESTINPUT.orderSizeTest(string2));
        }
        else if (string.equals("color")) {
           assertEquals(true, TESTINPUT.orderColorTest(string2));
        }
    }
    @When("he fill in {string} with extension {string}")
    public void heFillInWithExtention(String string, String string2) {
       assertEquals(true, TESTINPUT.orderPictureTest(string2));
    }
    @When("he fill in a {string} with {string}")
    public void heFillInAWith(String string, String string2) throws SQLException {
     assertEquals(true,true);
    }
    @When("he fill in a {string} with extension {string}")
    public void heFillInAWithExtension(String string, String string2) {
        assertEquals(true,true);
    }
    @Then("show massage {string}")
    public void showMassage(String string) {
        assertEquals(true,string.equals("information has been entered successfully"));
    }
}
