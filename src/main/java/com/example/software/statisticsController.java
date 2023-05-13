package com.example.software;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class statisticsController implements Initializable {
    @FXML
    private ImageView add;
    @FXML
    private Label back;
    @FXML
    private Button statistics;
    @FXML
    private PieChart pieChart;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int workingCount=0,completeCount=0,inTreatmentCount=0;
        ResultSet r1=database.createDatabase("select * from PRODUCT where status='working'");
        ResultSet r2=database.createDatabase("select * from PRODUCT where status='complete'");
        ResultSet r3=database.createDatabase("select * from PRODUCT where status='in treatment'");
        try{
            while(r1.next()) workingCount++;
            while(r2.next()) completeCount++;
            while(r3.next()) inTreatmentCount++;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        ObservableList<PieChart.Data>pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("WORKING",workingCount),
                new PieChart.Data("COMPLETE",completeCount),
                new PieChart.Data("IN TREATMENT",inTreatmentCount));

        pieChart.setData(pieChartData);
        pieChart.setStartAngle(90);
    }
}
