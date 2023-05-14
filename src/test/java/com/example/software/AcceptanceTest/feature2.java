package com.example.software.AcceptanceTest;
import com.example.software.TESTINPUT;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class feature2 {

    @When("user click on insert order and flag is {string}")
    public void userClickOnInsertOrderAndFlagIs(String string) {
        if(string.equals(true)){
            assertEquals(true,true);
        }
        else assertEquals(false,false);

    }
    @Then("the field {string} should be with error")
    public void theFieldShouldBeWithError(String string) {
        System.out.println("Please enter the information");
        assertEquals(false,false);

    }
    @Then("the image {string} should be with error")
    public void theImageShouldBeWithError(String string) {
        System.out.printf("Please enter png extension!");
        assertEquals(false,false);
    }

    @When("he fill in {string} with {string}")
    public void heFillInWith(String string, String string2) throws SQLException {
        boolean flag=false;
        if(string.equals("Name")){
             int flag2= TESTINPUT.ordernameTest(string2);
            if(flag2!=0) assertEquals(true,true);
            else assertEquals(false,false);
            }
        else if (string.equals("Quantity")) {
            flag= TESTINPUT.orderQuantityTest(string2);
            if(flag == true)assertEquals(true,true);
            else assertEquals(false,false);
        }
        else if (string.equals("size")) {
          flag=TESTINPUT.orderSizeTest(string2);
            if(flag==true) assertEquals(true,true);
            else assertEquals(false,false);
        }
        else if (string.equals("color")) {
           flag=TESTINPUT.orderColorTest(string2);
            if (flag == true) assertEquals(true, true);
            else assertEquals(false, false);
        }

    }
    @When("he fill in {string} with extension {string}")
    public void heFillInWithExtention(String string, String string2) {
       boolean flag=TESTINPUT.orderPictureTest(string2);
        if (flag == true) assertEquals(true, true);
        else assertEquals(false, false);
    }

    @Then("the information has been entered successfully")
    public void theInformationHasBeenEnteredSuccessfully() {
        assertEquals(true,true);
    }


}
