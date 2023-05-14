package com.example.software;
import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class Screen3 implements Initializable {
    static Logger logger = Logger.getLogger(Screen3.class.getName());

    @FXML
    private ImageView invoicePicture;
    @FXML
    private Label back;

    @FXML
    private Label nameLabel;

    @FXML
    private Label sizeLabel;

    @FXML
    private Label quantityLabel;
    @FXML
    private Label colorLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label newPriceLabel;

    @FXML
    private Label discountLabel;
    @FXML
    void backClicked(MouseEvent event) {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
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
       nameLabel.setText(Screen2Controller.getName());
       sizeLabel.setText(Screen2Controller.getSize());
       quantityLabel.setText(Screen2Controller.getQuantity());
       colorLabel.setText(Screen2Controller.getColor());
       invoicePicture.setImage(Screen2Controller.getOrderPic().getImage());
       priceLabel.setText(String.valueOf(Screen2Controller.getMoney()));
       ResultSet r= Database.createDatabase("select * from product where cid='"+Screen2Controller.getCustomerEnteredId2()+"'");
       int count=0;
       try{
           while (r.next())count+=Integer.parseInt(r.getString(5));
       } catch (SQLException e) {
           logger.log(null,"Database connection error: ");
       }
       if(count>20)discountLabel.setText(String.valueOf(Screen2Controller.getMoney()*0.1));
       newPriceLabel.setText(String.valueOf(Screen2Controller.getMoney()-Screen2Controller.getMoney()*0.1));

    }
}
