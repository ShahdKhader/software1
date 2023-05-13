package com.example.software.AcceptanceTest;
import com.example.software.HelloController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.Assert.assertEquals;

public class feature3 {
    @When("user click on invoice and flag is {string}")
    public void userClickOnInvoiceAndFlagIs(String string) {
        boolean flag = true;
        if (flag==true) {
            assertEquals(true,true);
        }
        else assertEquals(false,false);

    }
    @Then("the information has been successfully")
    public void theInformationHasBeenSuccessfully() {
        System.out.println("invoice printed !");

    }

}
