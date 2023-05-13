package com.example.software;

import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class productOperationController implements Initializable {

    @FXML
    private Button UpdateProduct1,addProduct,addProduct1,deleteProduct,deleteProduct1,gitInformation,updateProduct;
    @FXML
    private VBox addProductBox,updateProductBox;

    @FXML
    private Label back;
    @FXML
    private HBox deleteBox;
    @FXML
    private TextField productNameAdd1,smallSalaryAdd1,meduimSalaryAdd1,largeSalaryAdd1,
            productNameUpdate1,productNameUpdate1After,smallSalaryUpdate1,meduimSalaryUpdate1,largeSalaryUpdate1;
    @FXML
    private TextField productNameDelete1;
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
    void addClicked(MouseEvent event) {
        addProductBox.setVisible(true);
        deleteBox.setVisible(false);
        updateProductBox.setVisible(false);
    }
    @FXML
    void deleteClicked(MouseEvent event) {
        addProductBox.setVisible(false);
        deleteBox.setVisible(true);
        updateProductBox.setVisible(false);
    }
    @FXML
    void updateClicked(MouseEvent event) {
        addProductBox.setVisible(false);
        deleteBox.setVisible(false);
        updateProductBox.setVisible(true);
    }

    @FXML
    void addProduct1Clicked(MouseEvent event) {
        database.insertIntoDatabase("insert into item values ('"+productNameAdd1.getText()+"','"+smallSalaryAdd1.getText()+
                "','"+meduimSalaryAdd1.getText()+"','"+largeSalaryAdd1.getText()+"')");
        addProductBox.setVisible(false);
        deleteBox.setVisible(false);
        updateProductBox.setVisible(false);
    }
    @FXML
    void productDelete2Clicked(MouseEvent event) {
       database.insertIntoDatabase("delete from item where type='"+productNameDelete1.getText()+"'");
        addProductBox.setVisible(false);
        deleteBox.setVisible(false);
        updateProductBox.setVisible(false);
    }
    @FXML
    void UpdateProduct1Clicked(MouseEvent event) {
        database.insertIntoDatabase("update item set type='"+productNameUpdate1After.getText()+"',smallsalary='"+smallSalaryUpdate1.getText()+
                "',meduimsalary='"+meduimSalaryUpdate1.getText()+"',largesalary='"+largeSalaryUpdate1.getText()+"' where type='"+
                productNameUpdate1.getText()+"'");
        addProductBox.setVisible(false);
        deleteBox.setVisible(false);
        updateProductBox.setVisible(false);
    }
    @FXML
    void gitInformationClicked(MouseEvent event) {
      ResultSet r= database.createDatabase("select * from ITEM where type='"+productNameUpdate1.getText()+"'");
      try{
          while (r.next()){
              productNameUpdate1After.setText(r.getString(1));
              smallSalaryUpdate1.setText(r.getString(2));
              meduimSalaryUpdate1.setText(r.getString(3));
              largeSalaryUpdate1.setText(r.getString(4));
          }
        }catch(Exception e){
          throw new RuntimeException(e);
      }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProductBox.setVisible(false);
        deleteBox.setVisible(false);
        updateProductBox.setVisible(false);
    }
}
