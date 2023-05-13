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
import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


public class HelloController {
   static Logger logger = Logger.getLogger(HelloController.class.getName());
    @FXML
    public TextField gmailLogIn;
    @FXML
    private Button login1;
    @FXML
    private Button signUp;
    @FXML
    private PasswordField passwordLogIn;

    @FXML
    private static String z;

    public static String getZ() {
        return z;
    }

    public static void setZ(String z) {
        HelloController.z = z;
    }

    @FXML
    void login1Clicked(ActionEvent event) {

        try {
            ResultSet rs = database.createDatabase("select GMAIL,PASSWORD from CUSTOMER");
            ResultSet ra=database.createDatabase("select GMAIL,PASSWORD from admin ");
            while (ra.next()){
                String gmailA = ra.getString(1);
                String passwordA = ra.getString(2);
                Parent root;
                if (gmailLogIn.getText().equals(gmailA) && passwordLogIn.getText().equals(passwordA)) {
                    root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
                    Stage stage = (Stage) login1.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                    new FadeIn(root).play();
                    return;
                }
            }
            while (rs.next()) {
                String gmail = rs.getString(1);
                String password = rs.getString(2);
                Parent root;
              if (gmailLogIn.getText().equals(gmail) && !passwordLogIn.getText().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Password");
                    return;}
                else if (gmailLogIn.getText().equals(gmail) && passwordLogIn.getText().equals(password)) {
                    setZ(gmailLogIn.getText());
                    root = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
                    Stage stage = (Stage) login1.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                    new FadeIn(root).play();
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Incorrect Gmail");
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
        catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");        }
    }
    @FXML
    void signUp1Clicked(ActionEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Stage stage = (Stage) signUp.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");
        }
    }

}
