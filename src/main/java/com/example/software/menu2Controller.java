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
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.logging.Logger;

public class menu2Controller {
    @FXML
    private Label Statistics;
    @FXML
    private Label Trackorder;
    @FXML
    private Label Report;
    @FXML
    private Label customerOperation;
    @FXML
    private Label productOperation;

    static Logger logger = Logger.getLogger(menu2Controller.class.getName());

    @FXML
    void ReportClicked(MouseEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("report.fxml"));
            Stage stage = (Stage) Report.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");        }
    }

    @FXML
    void StatisticsClicked(MouseEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
            Stage stage = (Stage) Statistics.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");        }
    }

    @FXML
    void TrackOrderClicked(MouseEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("trackOrder.fxml"));
            Stage stage = (Stage) Trackorder.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");
        }
    }
    @FXML
    void customerOperationClicked(MouseEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("customerOperation.fxml"));
            Stage stage = (Stage) customerOperation.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");        }
    }

    @FXML
    void productOperationClicked(MouseEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("productOperation.fxml"));
            Stage stage = (Stage) productOperation.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");        }
    }
}
