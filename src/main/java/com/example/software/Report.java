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
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Report implements Initializable{
    static Logger logger = Logger.getLogger(Report.class.getName());

    @FXML
    private Label back;

    @FXML
    private TableColumn<ReportTable, Integer> customerId;

    @FXML
    private TableView<ReportTable> reportTable;
    @FXML
    private TableColumn<ReportTable, Integer> totalAmountOfMoney;

    @FXML
    void backClicked(MouseEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");        }
    }
    @FXML
    ObservableList<ReportTable> list1= FXCollections.observableArrayList();

    public  void initialize(URL url, ResourceBundle resourceBundle){
        customerId.setCellValueFactory(new PropertyValueFactory<ReportTable,Integer>("customerId"));
        totalAmountOfMoney.setCellValueFactory(new PropertyValueFactory<ReportTable,Integer>("totalAmountOfMoney"));
        ResultSet r= Database.createDatabase("select cid,moneyamount from product");
        try {
            while (r.next()) {
                int cid1 = Integer.parseInt(r.getString(1));
                int  moneyamount = Integer.parseInt(r.getString(2));

                list1.add(new ReportTable(cid1,moneyamount));
            }
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
        reportTable.setItems(list1);




    }




}