package com.example.software;
import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
;import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.ResultSet;
public class menuController {
    @FXML
        private Label insertOrder,invoice,report,setting;

    public void InvoiceClicked(MouseEvent mouseEvent) {
    }


    public void insrtOrderClicked(MouseEvent mouseEvent) {
        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
            Stage stage = (Stage) insertOrder.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void settingClicked(MouseEvent mouseEvent) {
    }

    public void ReportClicked(MouseEvent mouseEvent) {
    }
}


