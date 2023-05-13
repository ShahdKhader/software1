package com.example.software;

import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class customerOperationController implements Initializable {

    @FXML
    private Button add,add2,delete,delete2,update,update2;

    @FXML
    private VBox addBox,updateBox;
    @FXML
    private TextField address,address1,customerIdDelete,gmail,gmail1,id,id1,phoneNumber,phoneNumber1,userName,userName1;

    @FXML
    private Label back;
    @FXML
    private HBox deleteBox;
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    private Button gitInformation;
    @FXML
    void gitInformationClicked(MouseEvent event) {
        ResultSet r= database.createDatabase("select * from customer where CID='"+id1.getText()+"'");
        try{
            while (r.next()) {
                id1.setText(r.getString(1));
                phoneNumber1.setText(r.getString(2));
                address1.setText(r.getString(3));
                gmail1.setText(r.getString(4));
                userName1.setText(r.getString(5));
                password1.setText(r.getString(6));
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    void add2Clicked(MouseEvent event) {
        //as sign up
        try {
            if (!TESTINPUT.idTest(id.getText())){
                JOptionPane.showMessageDialog(null, "wrong id !", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;}
            else if (!TESTINPUT.passwordTest(password.getText())){
                JOptionPane.showMessageDialog(null, "wrong PASSWORD !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (!TESTINPUT.phoneNumberTest(phoneNumber.getText())){
                JOptionPane.showMessageDialog(null, "wrong PHONE NUMBER !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (!TESTINPUT.gmailTest(gmail.getText())){
                JOptionPane.showMessageDialog(null, "wrong GMAIL !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (id.getText().isEmpty() || phoneNumber.getText().isEmpty() || gmail.getText().isEmpty() || userName.getText().isEmpty() || password.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Field is Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ResultSet rs = database.createDatabase("select CID,USERNAME,PASSWORD from customer");
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
                database.insertIntoDatabase("INSERT INTO CUSTOMER values('" + id.getText() + "','" + phoneNumber.getText() + "','" + address.getText() + "','" + gmail.getText() + "','" + userName.getText() + "','" + password.getText() + "')");
                JOptionPane.showMessageDialog(null, "DONE ", "INSERTED", JOptionPane.INFORMATION_MESSAGE);
                addBox.setVisible(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addClicked(MouseEvent event) {
        addBox.setVisible(true);
        deleteBox.setVisible(false);
        updateBox.setVisible(false);
        addBox.setLayoutX(119);
        addBox.setLayoutX(152);
    }

    @FXML
    void backClicked(MouseEvent event) {
        try {
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void delete2Clicked(MouseEvent event) {
        if(customerIdDelete.getText().isEmpty()) JOptionPane.showMessageDialog(null, "Please Fill Id Customer First !", "ERROR", JOptionPane.ERROR_MESSAGE);
        else {
            database.insertIntoDatabase("delete from customer where cid ='"+customerIdDelete.getText()+"'");
            JOptionPane.showMessageDialog(null, "DONE ", "INSERTED", JOptionPane.INFORMATION_MESSAGE);
            deleteBox.setVisible(false);
        }
    }
    @FXML
    void deleteClicked(MouseEvent event) {
        addBox.setVisible(false);
        deleteBox.setVisible(true);
        updateBox.setVisible(false);
        deleteBox.setLayoutX(120);
        deleteBox.setLayoutY(215);
    }
    @FXML
    void update2Clicked(MouseEvent event) {
        String r=id1.getText();
        try {
            if (!TESTINPUT.idTest(id1.getText())){
                JOptionPane.showMessageDialog(null, "wrong id !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (!TESTINPUT.passwordTest(password1.getText())){
                JOptionPane.showMessageDialog(null, "wrong PASSWORD !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (!TESTINPUT.phoneNumberTest(phoneNumber1.getText())){
                JOptionPane.showMessageDialog(null, "wrong PHONE NUMBER !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (!TESTINPUT.gmailTest(gmail1.getText())){
                JOptionPane.showMessageDialog(null, "wrong GMAIL !", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;}
            else if (id1.getText().isEmpty() || phoneNumber1.getText().isEmpty() || gmail1.getText().isEmpty() || userName1.getText().isEmpty() || password1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Field is Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ResultSet rs = database.createDatabase("select CID,USERNAME,PASSWORD from customer");
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
        database.insertIntoDatabase("update customer set phonenumber='"+phoneNumber1.getText()+"',address='"+
                address1.getText()+"',gmail='"+gmail1.getText()+"',username='"+userName1.getText()+"',password='"+password1.getText()+"'"
                +"where CID='"+r+"'");
        JOptionPane.showMessageDialog(null, "DONE ", "INSERTED", JOptionPane.INFORMATION_MESSAGE);
        updateBox.setVisible(false);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    @FXML
    void updateClicked(MouseEvent event) {
        addBox.setVisible(false);
        deleteBox.setVisible(false);
        updateBox.setVisible(true);
        updateBox.setLayoutX(120);
        updateBox.setLayoutX(151);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addBox.setVisible(false);
        deleteBox.setVisible(false);
        updateBox.setVisible(false);
    }
}
