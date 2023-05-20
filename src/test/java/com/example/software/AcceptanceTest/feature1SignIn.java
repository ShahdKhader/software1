package com.example.software.AcceptanceTest;
import com.example.software.Database;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
public class feature1SignIn {
        ResultSet s = Database.createDatabase("select * from customer");
        boolean x = s.next();

    public feature1SignIn() throws SQLException {
    }

    @Given("I go to loginchoise")
    public void iGoToLoginchoise()  {
        assertEquals(true,x);
    }
    @Given("the field {string} is empty")
    public void theFieldIsEmpty(String string) { assertEquals(true,string.isEmpty());    }
    @When("I click on login and flag is {string}")
    public void iClickOnLoginAndFlagIs(String string) {
        assertEquals(true,string.equals("true"));

    }
    @Then("field {string} should be with error")
    public void fieldShouldBeWithError(String string) {
        assertEquals(true,string.isEmpty());
    }
    @Then("I should see {string}")
    public void iShouldSee(String string) {
        assertEquals(true,string.equals("E-mail or password is incorrect"));

    }
    @Then("I shouldnt see {string}")
    public void iShouldnTSee(String string){
        assertEquals(false,!string.equals("Access your account"));
    }
}
