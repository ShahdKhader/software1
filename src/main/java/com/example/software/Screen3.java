package com.example.software;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import oracle.jdbc.OracleConnectionWrapper;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Screen3 {

    @FXML
    private TextField Name;

    @FXML
    private TextField PhoneNumber;

    @FXML
    private TextField color;

    @FXML
    private TextField quantity;

    @FXML
    private ImageView search;

    @FXML
    private TextField size;

    @FXML
    private ImageView picture;
    @FXML
    private Label back;
    @FXML
    void backClicked(MouseEvent event) {
        try {
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            //new FadeIn(root).play();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void onSearchButtonClick(ActionEvent event) {

        Screen2Controller w=new Screen2Controller();
        Name.setText( w.namescreen2.getText());
        quantity.setText( w.namescreen2.getText());
        size.setText( w.namescreen2.getText());
        color.setText( w.namescreen2.getText());
        //picture.setImage( w.namescreen2.get());


    }




}
