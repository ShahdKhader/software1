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
            assertEquals(true,string.equals("true"));


    }

}
