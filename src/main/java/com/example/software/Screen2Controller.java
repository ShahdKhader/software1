package com.example.software;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.sql.ResultSet;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.*;
import javafx.scene.control.TextField;
import java.lang.String.*;
public class Screen2Controller implements Initializable {
    @FXML
    private TextField colorscreen2,sizescreen2,quantityscreen2,namescreen2;
    @FXML
    private String temp;
    @FXML
    private Button importPicture,save;
    @FXML
    private ImageView orderPicture;
    @FXML
    void saveClicked(ActionEvent event) {
    if(TESTINPUT.ordernameTest(namescreen2.getText())==0) JOptionPane.showMessageDialog(null,"Unvalied name","ERROR",JOptionPane.ERROR_MESSAGE);
    else if(!TESTINPUT.orderQuantityTest(quantityscreen2.getText())) JOptionPane.showMessageDialog(null,"Unvalied Quantity","ERROR",JOptionPane.ERROR_MESSAGE);
    else if(!TESTINPUT.orderSizeTest(sizescreen2.getText())) JOptionPane.showMessageDialog(null,"Unvalied Size","ERROR",JOptionPane.ERROR_MESSAGE);
    else if(!TESTINPUT.orderColorTest(colorscreen2.getText())) JOptionPane.showMessageDialog(null,"Unvalied Color","ERROR",JOptionPane.ERROR_MESSAGE);
    else {
        database.insertIntoDatabase("insert into PRODUCT values('"+TESTINPUT.ordernameTest(namescreen2.getText())+"','"+"407963852"+"','"+"407123456"+"','"+namescreen2.getText()+"','"+quantityscreen2.getText()+"','"+sizescreen2.getText()+"','"+colorscreen2.getText()+"','"+"working"+"','"+"200"+"')");
        JOptionPane.showMessageDialog(null, "DONE ", "INSERTED", JOptionPane.INFORMATION_MESSAGE);

    }
    }
    @FXML
    void importPictureClicked(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage=(Stage) importPicture.getScene().getWindow();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file=fileChooser.showOpenDialog(stage);
        if (file != null) {
                String iconimagepath = file.getAbsolutePath();
                System.out.println(iconimagepath);
                orderPicture.setImage(new Image(iconimagepath));
                temp=iconimagepath;
            }
        else if(!TESTINPUT.orderPictureTest(temp)) JOptionPane.showMessageDialog(null,"Unvalied Picture","ERROR",JOptionPane.ERROR_MESSAGE);



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
