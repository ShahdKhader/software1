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

public class menu2Controller {

    @FXML
    private Label AvailableWorker,Statistics,Trackorder,Report,customerOperation,productOperation;
    @FXML
    void AvailableWorkerClicked(MouseEvent event) {
        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("availableWorker.fxml"));
            Stage stage = (Stage) AvailableWorker.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ReportClicked(MouseEvent event) {
        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("report.fxml"));
            Stage stage = (Stage) Report.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void StatisticsClicked(MouseEvent event) {
        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
            Stage stage = (Stage) Statistics.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void TrackOrderClicked(MouseEvent event) {
        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("trackOrder.fxml"));
            Stage stage = (Stage) Trackorder.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    void customerOperationClicked(MouseEvent event) {
        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("customerOperation.fxml"));
            Stage stage = (Stage) customerOperation.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void productOperationClicked(MouseEvent event) {
        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("productOperation.fxml"));
            Stage stage = (Stage) productOperation.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
