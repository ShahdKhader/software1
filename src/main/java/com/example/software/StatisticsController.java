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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class StatisticsController implements Initializable {
    @FXML
    private ImageView add;
    @FXML
    private Label back;
    @FXML
    private Button statistics;
    @FXML
    private PieChart pieChart;

    static Logger logger = Logger.getLogger(StatisticsController.class.getName());

    @FXML
    void backClicked(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int workingCount=0;
        int completeCount=0;
        int inTreatmentCount=0;
        ResultSet r1= Database.createDatabase("select * from PRODUCT where status='working'");
        ResultSet r2= Database.createDatabase("select * from PRODUCT where status='complete'");
        ResultSet r3= Database.createDatabase("select * from PRODUCT where status='in treatment'");
        try{
            while(r1.next()) workingCount++;
            while(r2.next()) completeCount++;
            while(r3.next()) inTreatmentCount++;
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
        ObservableList<PieChart.Data>pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("WORKING",workingCount),
                new PieChart.Data("COMPLETE",completeCount),
                new PieChart.Data("IN TREATMENT",inTreatmentCount));

        pieChart.setData(pieChartData);
        pieChart.setStartAngle(90);
    }
}
