package com.example.software;
import animatefx.animation.FadeIn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class trackOrderController implements Initializable {
    @FXML
    private TableView<trackOrderTable> table;
    @FXML
    private TableColumn<trackOrderTable, Integer> AID,CID,Money,OrderId,Quantity;
    @FXML
    private TableColumn<trackOrderTable, String> Color,Name,Size,Status;
    @FXML
    private Label back;
    @FXML
    private Button track;
    @FXML
    private TextField id2;

    @FXML
    private TextField status2;
    @FXML
    void trackClicked(MouseEvent event) {
        String q=id2.getText();
       String w= status2.getText();
        database.createDatabase("update product set status ='"+w+ "' where pid="+q);
        table.setItems(list);
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
    ObservableList<trackOrderTable> list= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        OrderId.setCellValueFactory(new PropertyValueFactory<trackOrderTable,Integer>("OrderId"));
        AID.setCellValueFactory(new PropertyValueFactory<trackOrderTable,Integer>("AID"));
        CID.setCellValueFactory(new PropertyValueFactory<trackOrderTable,Integer>("CID"));
        Quantity.setCellValueFactory(new PropertyValueFactory<trackOrderTable,Integer>("Quantity"));
        Money.setCellValueFactory(new PropertyValueFactory<trackOrderTable,Integer>("Money"));
        Name.setCellValueFactory(new PropertyValueFactory<trackOrderTable,String>("Name"));
        Size.setCellValueFactory(new PropertyValueFactory<trackOrderTable,String>("Size"));
        Color.setCellValueFactory(new PropertyValueFactory<trackOrderTable,String>("Color"));
        Status.setCellValueFactory(new PropertyValueFactory<trackOrderTable,String>("Status"));
            ResultSet rs = database.createDatabase("select * from PRODUCT");
        try {
            while (rs.next()) {
                int pid = Integer.parseInt(rs.getString(1));
                int aid = Integer.parseInt(rs.getString(2));
                int cid = Integer.parseInt(rs.getString(3));
                String name = rs.getString(4);
                int quantity = Integer.parseInt(rs.getString(5));
                String size = rs.getString(6);
                String color = rs.getString(7);
                String status = rs.getString(8);
                int money =Integer.parseInt( rs.getString(9));
                list.add(new trackOrderTable(pid,aid,cid,name,quantity,size,color,status,money));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        table.setItems(list);

    }
}
