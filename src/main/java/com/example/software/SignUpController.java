package com.example.software;
import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.scene.control.TextField;


public class SignUpController {
    static Logger logger = Logger.getLogger(SignUpController.class.getName());

    @FXML
    private TextField address;

    @FXML
    private TextField userName;

    @FXML
    private TextField gmail;

    @FXML
    private TextField id;
    @FXML
    private TextField phoneNumber;

    @FXML
    private PasswordField password;
    @FXML
    private Label back;
    @FXML
    private Button signUp2;
    @FXML
    void backClicked(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");
        }
    }

    @FXML
    void signUp2Clicked(ActionEvent event) {
        try {
            if (!TESTINPUT.idTest(id.getText())) {
                JOptionPane.showMessageDialog(null, "wrong id !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!TESTINPUT.passwordTest(password.getText())) {
                JOptionPane.showMessageDialog(null, "wrong PASSWORD !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!TESTINPUT.phoneNumberTest(phoneNumber.getText())) {
                JOptionPane.showMessageDialog(null, "wrong PHONE NUMBER !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!TESTINPUT.gmailTest(gmail.getText())) {
                JOptionPane.showMessageDialog(null, "wrong GMAIL !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (id.getText().isEmpty() || phoneNumber.getText().isEmpty() || gmail.getText().isEmpty() || userName.getText().isEmpty() || password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Field is Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ResultSet rs = Database.createDatabase("select CID,USERNAME,PASSWORD from customer");
            while (rs.next()) {
                String ID = rs.getString(1);
                String USERNAME = rs.getString(2);
                if (ID.equals(id.getText())) {
                    JOptionPane.showMessageDialog(null, "The ID is already contains", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (USERNAME.equals(userName.getText())) {
                    JOptionPane.showMessageDialog(null, "The USERNAME is already contains", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            Database.insertIntoDatabase("INSERT INTO CUSTOMER values('" + id.getText() + "','" + phoneNumber.getText() + "','" + address.getText() + "','" + gmail.getText() + "','" + userName.getText() + "','" + password.getText() + "')");
            JOptionPane.showMessageDialog(null, "DONE ", "INSERTED", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("screen3.fxml"));
            Stage stage = (Stage) signUp2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");
        }
    }
}




