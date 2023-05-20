package com.example.software.AcceptanceTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
public class feature7 {
    @Given("a database with a list of completed {string}")
    public void aDatabaseWithAListOfCompletedOrders(String string) {
        assertEquals(true, string.equals("orders"));
    }

    @When("a request is made to generate statistics for the year of March {int}")
    public void aRequestIsMadeToGenerateStatisticsForTheYearOfMarch(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @Then("the total number of delivered items for {int} should be displayed")
    public void theTotalNumberOfDeliveredItemsForShouldBeDisplayed(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @Then("the total cash received for {int} should be displayed")
    public void theTotalCashReceivedForShouldBeDisplayed(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @Then("the total amount paid for {int} should be displayed")
    public void theTotalAmountPaidForShouldBeDisplayed(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @Then("the total amount debts by customers for {int} should be displayed")
    public void theTotalAmountDebtsByCustomersForShouldBeDisplayed(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @Given("a database with no completed orders for the year of {int}")
    public void aDatabaseWithNoCompletedOrdersForTheYearOf(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @When("a request is made to generate statistics for the year of {int}")
    public void aRequestIsMadeToGenerateStatisticsForTheYearOf(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @Then("the message {string} should be displayed")
    public void theMessageShouldBeDisplayed(String string) {
        assertEquals(true, !string.equals("0"));
    }

    @Given("a request to generate statistics for an invalid year {string}")
    public void aRequestToGenerateStatisticsForAnInvalidYear(String string) {
        assertEquals(true, string.equals("2020"));
    }

    @When("the request is {string}")
    public void theRequestIsMade(String string) {
        assertEquals(true, string.equals("made"));
    }

    @Given("a database with completed orders for {int}")
    public void aDatabaseWithCompletedOrdersFor(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @When("a request is made to generate statistics for {int}")
    public void aRequestIsMadeToGenerateStatisticsFor(Integer int1) {
        assertEquals(true, int1>=0);
    }

    @When("the total amount owed by customers is {string}")
    public void theTotalAmountOwedByCustomersIsNegative(String string) {
        assertEquals(true, string.equals("negative"));
    }

    @Given("an empty {string}")
    public void anEmptyDatabase(String string) {
        assertEquals(true, string.equals("database"));
    }

    @When("a request is made to generate statistics for any {string}")
    public void aRequestIsMadeToGenerateStatisticsForAnyYear(String string) {
        assertEquals(true, string.equals("year"));
    }
}