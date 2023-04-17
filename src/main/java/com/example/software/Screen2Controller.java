package com.example.software;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
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
import javafx.stage.Stage;
import javax.swing.*;
import javafx.scene.control.TextField;
import java.lang.String.*;
public class Screen2Controller implements Initializable {
    @FXML
    private TextField colorscreen2,quantityscreen2;
    @FXML
    private ComboBox<String> sizescreen2;
    @FXML
    private ComboBox<String> namescreen2;
    @FXML
    private String temp;
    @FXML
    private Button importPicture,save;
    @FXML
    private ImageView orderPicture;
    public String customerEnteredId2;
    public int discount;
    @FXML
    void saveClicked(ActionEvent event) {
   // if(TESTINPUT.ordernameTest(namescreen2.getValue())==0) JOptionPane.showMessageDialog(null,"Unvalied name","ERROR",JOptionPane.ERROR_MESSAGE);
     if(!TESTINPUT.orderQuantityTest(quantityscreen2.getText())) JOptionPane.showMessageDialog(null,"Unvalied Quantity","ERROR",JOptionPane.ERROR_MESSAGE);
    //else if(!TESTINPUT.orderSizeTest(sizescreen2.getValue())) JOptionPane.showMessageDialog(null,"Unvalied Size","ERROR",JOptionPane.ERROR_MESSAGE);
    else if(!TESTINPUT.orderColorTest(colorscreen2.getText())) JOptionPane.showMessageDialog(null,"Unvalied Color","ERROR",JOptionPane.ERROR_MESSAGE);
    else {
        HelloController h=new HelloController();
       String x= h.z;
            System.out.println(x);
        ResultSet customerEnteredId= database.createDatabase("select CID from CUSTOMER where GMAIL ="+"'"+x+"'");
        try{
            while (customerEnteredId.next()) {
                customerEnteredId2 = customerEnteredId.getString(1);
                System.out.println(customerEnteredId2);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        String type= namescreen2.getValue();
        int money=0;
        if(type =="COVER"&&sizescreen2.getValue()=="SMALL" ) money=50*Integer.parseInt(quantityscreen2.getText());
        else if(type =="COVER"&&sizescreen2.getValue()=="MEDIUM" ) money=100*Integer.parseInt(quantityscreen2.getText());
        else if(type =="COVER"&&sizescreen2.getValue()=="LARGE" ) money=150*Integer.parseInt(quantityscreen2.getText());
        else if(type =="CARPET"&&sizescreen2.getValue()=="SMALL" ) money=150*Integer.parseInt(quantityscreen2.getText());
        else if(type =="CARPET"&&sizescreen2.getValue()=="MEDIUM" ) money=200*Integer.parseInt(quantityscreen2.getText());
        else if(type =="CARPET"&&sizescreen2.getValue()=="LARGE" ) money=250*Integer.parseInt(quantityscreen2.getText());
        else if(type =="BLANKET"&&sizescreen2.getValue()=="SMALL" ) money=100*Integer.parseInt(quantityscreen2.getText());
        else if(type =="BLANKET"&&sizescreen2.getValue()=="MEDIUM" ) money=150*Integer.parseInt(quantityscreen2.getText());
        else if(type =="BLANKET"&&sizescreen2.getValue()=="LARGE" ) money=200*Integer.parseInt(quantityscreen2.getText());

         database.insertIntoDatabase("insert into PRODUCT values(productSequence1.nextval,'"+ "407222222"+"','"+customerEnteredId2+ "','"+namescreen2.getValue()+"','" +
                quantityscreen2.getText()+"','"+sizescreen2.getValue()+"','"+colorscreen2.getText()+"','"+"waiting"+"','"+money+"')");
        JOptionPane.showMessageDialog(null, "DONE ", "INSERTED", JOptionPane.INFORMATION_MESSAGE);

        try{
            Parent root;
            FXMLLoader fxmlLoader;
            root = FXMLLoader.load(getClass().getResource("Screen3.fxml"));
            Stage stage = (Stage) save.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (Exception e){
            throw new RuntimeException(e);
        }


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
        namescreen2.setItems(FXCollections.observableArrayList("COVER","CARPET","BLANKET"));
        sizescreen2.setItems(FXCollections.observableArrayList("SMALL","MEDUIM","LARGE"));

    }
}
