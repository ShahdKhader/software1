package com.example.software;
import animatefx.animation.FadeIn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.awt.*;
import javafx.event.ActionEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

public class Screen2Controller implements Initializable {
    @FXML
    private TextField colorscreen2,sizescreen2,quantityscreen2;
    @FXML
    private Button importPicture,save;
    @FXML
    private ImageView orderPicture;
    @FXML
    private ComboBox<String> namescreen2;
    @FXML
    void saveClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            ObservableList<String> options = FXCollections.observableArrayList("CARPET", "COVER", "BLANKET");
            namescreen2= new ComboBox<>(options);
            namescreen2.setValue("CARPET");
    }
}
