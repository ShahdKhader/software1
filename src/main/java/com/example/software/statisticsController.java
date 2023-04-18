package com.example.software;
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

import java.sql.ResultSet;

public class statisticsController {
    @FXML
    private ImageView add;
    @FXML
    private Label back;

    @FXML
    private TextField totalCash,totalDebt,totalDelivered,totalPaid,ID_customer;
    @FXML
    private Button statistics;
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
    void statistics(MouseEvent event) {
        int count=0;
         String z =ID_customer.getText();
       ResultSet rs= database.createDatabase("select * from PRODUCT where CID="+z);
       try {
           while (rs.next()) count++;
       }catch(Exception e){
           throw new RuntimeException(e);
       }
        totalDelivered.setText(String.valueOf(count));

    }


}
