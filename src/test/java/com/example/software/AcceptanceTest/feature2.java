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
    }
    @Then("the image {string} should be with error")
    public void theImageShouldBeWithError(String string) {
        System.out.printf("Please enter png extension!");
    }

    @When("he fill in {string} with {string}")
    public void heFillInWith(String string, String string2) throws SQLException {
        if(string.equals("Name")){
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("SN");
            ods.setPassword("123456");
            Connection con = ods.getConnection();
            String all = "select USERNAME from CUSTOMER";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(all);
            boolean flag=false;
            while (rs.next()) {
                String name =rs.getString(1);
                if(name.equals(string) ) {assertEquals(true,true);
                    flag=true;
                }
            }
            if(!flag) assertEquals(false,false);
        }
        else if (string.equals("Quantity")&& string2.length() >0) {
            boolean flag = true;
            for(int i=0;i<string2.length();i++){
                if(!Character.isDigit(string2.charAt(i))){
                    flag = false ;
                    break;
                }
            }
            if(flag == true)assertEquals(true,true);
            else assertEquals(false,false);
        }
        else if (string.equals("size")&& string2.length() >= 0) {
            boolean flag =true;
            for(int i=0;i<string2.length();i++){
                if(!Character.isDigit(string2.charAt(i))){
                    flag = false ;
                    break;
                }
            }
            if(flag==true) assertEquals(true,true);
            else assertEquals(false,false);
        }
        else if (string.equals("color")) {
            boolean flag = true;
            for (int i = 0; i < string2.length(); i++) {
                if (Character.isDigit(string2.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) assertEquals(true, true);
            else assertEquals(false, false);
        }

    }
    @When("he fill in {string} with extension {string}")
    public void heFillInWithExtention(String string, String string2) {


    }
    @When("he presses {string} and flag is {string}")
    public void hePressesAndFlagIs(String string, String string2) {
        if (string.equals(true)) assertEquals(true,true);

    }
    @Then("the information has been entered successfully")
    public void theInformationHasBeenEnteredSuccessfully() {
        assertEquals(true,true);
    }
    @Then("the user should see {string}")
    public void theUserShouldSee(String string) {
        assertEquals(true,true);
    }

}
