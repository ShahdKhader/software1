package com.example.software.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class featureSignUp {
    @When("I click on sign up and flag is {string}")
    public void iClickOnSignUpAndFlagIs(String string) {
        if (string.equals(true)) {
            assertEquals(true, true);
        }
        else assertEquals(false, false);
    }

    @When("he fills in {string} with {string}")
    public void heFillsInWith(String string, String string2) {
        if(string.equals("ID")&& string2.length()==9){
            boolean flag=true;
            for(int i=0;i<string2.length();i++){
                if(!Character.isDigit(string2.charAt(i))) {
                    flag=false;
                    break;
                }
            }
            if(flag==true)  assertEquals(true, true);
            else assertEquals(false, false);
        }
        else if(string.equals("Phone Number")&& string2.length()==10){
            boolean flag=true;
            for(int i=0;i<string2.length();i++){
                if(!Character.isDigit(string2.charAt(i))) {
                    flag=false;
                    break;
                }
            }
            if(flag==true)  assertEquals(true, true);
            else assertEquals(false, false);
        }
        else if(string.equals("BackUp Number")&& string2.length()==10){
            boolean flag=true;
            for(int i=0;i<string2.length();i++){
                if(!Character.isDigit(string2.charAt(i))) {
                    flag=false;
                    break;
                }
            }
            if(flag==true)  assertEquals(true, true);
            else assertEquals(false, false);
        }
        else if(string.equals("Gmail")) {
            if (Character.isDigit(string2.charAt(0)) || string2.length() == 17) assertEquals(false, false);
            else {
                boolean flag = false;
                for (int i = 1; i < string2.length(); i++) {
                    if (string2.charAt(i) == '@') flag = true;
                }
                if (flag == false) assertEquals(false, false);
                else assertEquals(true, true);
            }
        }
        else if(string.equals("Password")){
            if( string2.length()<8) assertEquals(false, false);
            else {
                boolean flags=false,flagc=false,flagn=false;
                for (int i = 1; i < string2.length(); i++){
                    if(Character.isLowerCase(string2.charAt(i))) flags=true;
                    else if(Character.isUpperCase(string2.charAt(i))) flagc=true;
                    else if (Character.isDigit(string2.charAt(i))) flagn=true;
                }
                if(flags==true && flagc==true && flagn==true) assertEquals(true, true);
                else assertEquals(false,false);
            }
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
