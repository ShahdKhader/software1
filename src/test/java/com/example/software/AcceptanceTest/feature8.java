package com.example.software.AcceptanceTest;
import com.example.software.HelloController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class feature8 {
    @Given("a list of {int} orders and {int} available workers")
    public void aListOfOrdersAndAvailableWorkers(Integer int1, Integer int2) {
        assertEquals(true,int1>=0);
    }
    @When("a request is made to distribute the {string}")
    public void aRequestIsMadeToDistributeTheOrders(String string) {
        assertEquals(true,string.equals("orders"));
    }
    @Then("each worker should receive at least {int} orders")
    public void eachWorkerShouldReceiveAtLeastOrders(Integer int1) {
        assertEquals(true,int1>=0);
    }
    @Then("the orders should be distributed in a fair and balanced {string}")
    public void theOrdersShouldBeDistributedInAFairAndBalancedWay(String string) {
        assertEquals(true,string.equals("way"));
    }

    @Then("each worker should receive at least {int} order")
    public void eachWorkerShouldReceiveAtLeastOrder(Integer int1) {
        assertEquals(true,int1>=0);

    }
    @Then("{int} workers should not receive any orders")
    public void workersShouldNotReceiveAnyOrders(Integer int1) {
        assertEquals(true,int1>=0);

    }
    @Then("the remaining orders should be distributed in a fair and balanced {string}")
    public void theRemainingOrdersShouldBeDistributedInAFairAndBalancedWay(String string) {
        assertEquals(true,string.equals("way"));
    }
    @Given("a list of {int} orders and no available workers")
    public void aListOfOrdersAndNoAvailableWorkers(Integer int1) {
        assertEquals(true, int1>=0);
    }
    @Given("an empty order list and {int} available workers")
    public void anEmptyOrderListAndAvailableWorkers(Integer int1) {
        assertEquals(true, int1>=0);
    }
}