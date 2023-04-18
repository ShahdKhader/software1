package com.example.software;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Screen4 {

    @FXML
    private TableColumn<report, String> col_color;

    @FXML
    private TableColumn<report, Integer> col_price;

    @FXML
    private TableColumn<report, Integer> col_quantity;

    @FXML
    private TableColumn<report, Integer> col_size;

    @FXML
    private TableColumn<report,String > customer_name;

    @FXML
    private TableColumn<report,String> product_name;

    @FXML
    private TableView<report> table_report;


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

   // observableList<report> ListM;
    int index = -1 ;
    //connection conn = null ;
    ResultSet rs = null ;
    PreparedStatement pst = null ;

    @FXML
    public void initialize(URL url, ResourceBundle rb){
        col_color.setCellValueFactory(new PropertyValueFactory<report,String>("col_color"));
        col_price.setCellValueFactory(new PropertyValueFactory<report,Integer>("col_price"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<report,Integer>("col_quantity"));
        col_size.setCellValueFactory(new PropertyValueFactory<report,Integer>("col_size"));
        customer_name.setCellValueFactory(new PropertyValueFactory<report,String>("customer_name"));
        product_name.setCellValueFactory(new PropertyValueFactory<report,String>("product_name"));

        //ListM = database.getDatareport();
        //table_report.setItems(ListM);


    }

}
