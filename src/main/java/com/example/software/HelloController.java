package com.example.software;
import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    public TextField gmailLogIn;

    @FXML
    private Button login1;

    @FXML
    private PasswordField passwordLogIn;

    @FXML
    private Button signUp;

    @FXML
    public static String z;
    @FXML
    void login1Clicked(ActionEvent event) {

        try {
            int flag=0;
            ResultSet rs = database.createDatabase("select GMAIL,PASSWORD from CUSTOMER");
            while (rs.next()) {
                String gmail = rs.getString(1);
                String Password = rs.getString(2);
                Parent root;
                if(gmailLogIn.getText().equals("admin")&&passwordLogIn.getText().equals("admin")){
                    FXMLLoader fxmlLoader;
                    System.out.println("yes");

                    root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
                    Stage stage = (Stage) login1.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                    new FadeIn(root).play();
                    System.out.println("yes");
                    break;
                }
                else if (gmailLogIn.getText().equals(gmail) && !passwordLogIn.getText().equals(Password)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                    break;}
                else if (!gmailLogIn.getText().equals(gmail) && passwordLogIn.getText().equals(Password)) {
                        JOptionPane.showMessageDialog(null, "Incorrect Gmail");
                        break;
                }
                else if (gmailLogIn.getText().equals(gmail) && passwordLogIn.getText().equals(Password)) {
                    z=gmailLogIn.getText();
                    FXMLLoader fxmlLoader;
                    root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    Stage stage = (Stage) login1.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                    new FadeIn(root).play();
                    break;
                }

            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    void signUp1Clicked(ActionEvent event) {
        try{
        Parent root;
        FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Stage stage = (Stage) login1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
