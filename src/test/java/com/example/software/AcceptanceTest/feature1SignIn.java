package com.example.software.AcceptanceTest;

import com.example.software.Database;
import com.example.software.HelloController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
public class feature1SignIn {
    HelloController helloController=new HelloController();
        ResultSet s = Database.createDatabase("select * from customer");
        boolean x = s.next();

    public feature1SignIn() throws SQLException {
    }

    @Given("I go to loginchoise")
    public void iGoToLoginchoise() throws SQLException {
        assertEquals(x,true);
    }
    @Given("the field {string} is empty")
    public void theFieldIsEmpty(String string) { assertEquals(string.isEmpty(),true);    }
    @When("I click on login and flag is {string}")
    public void iClickOnLoginAndFlagIs(String string) {
        assertEquals(string.equals("true"),true);

    }
    @Then("field {string} should be with error")
    public void fieldShouldBeWithError(String string) {
        assertEquals(string.isEmpty(),true);
    }
    @Then("I should see {string}")
    public void iShouldSee(String string) {
        assertEquals(string.equals("E-mail or password is incorrect"),true);

    }
    @Then("I shouldnt see {string}")
    public void iShouldnTSee(String string){
        assertEquals(!string.equals("Access your account"),false);
    }
}
