package com.example.software;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import animatefx.animation.FadeIn;
import java.sql.ResultSet;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.logging.Logger;

public class Screen2Controller implements Initializable {
    static Logger logger = Logger.getLogger(Screen2Controller.class.getName());

    @FXML
    private TextField colorscreen2;

    @FXML
    private TextField quantityscreen2;
    @FXML
    private Label back;
    @FXML
    private ComboBox<String> sizescreen2;
    @FXML
    private ComboBox<String> namescreen2;
    @FXML
    private String temp;
    @FXML
    private Button importPicture;
    @FXML
    private Button save;
    @FXML
    private ImageView orderPicture;
    private static String customerEnteredId2;

    public static String getCustomerEnteredId2() {
        return customerEnteredId2;
    }

    public static void setCustomerEnteredId2(String customerEnteredId2) {
        Screen2Controller.customerEnteredId2 = customerEnteredId2;
    }

    private int discount;
    private static String name;
    private static String quantity;
    private static String size;
    private static String color;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Screen2Controller.name = name;
    }

    public static String getQuantity() {
        return quantity;
    }

    public static void setQuantity(String quantity) {
        Screen2Controller.quantity = quantity;
    }

    public static String getSize() {
        return size;
    }

    public static void setSize(String size) {
        Screen2Controller.size = size;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        Screen2Controller.color = color;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Screen2Controller.money = money;
    }

    private static  int money=0;
    public static ImageView orderPic;
    @FXML
    void backClicked(MouseEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Stage stage = (Stage) back.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
        }catch (IOException e){
            logger.log(null," An error occurred while opening a new window:");
        }
    }
    @FXML
    void saveClicked(ActionEvent event) {
        if(namescreen2.getSelectionModel().isEmpty() && sizescreen2.getSelectionModel().isEmpty() && quantityscreen2.getText().isEmpty() && colorscreen2.getText().isEmpty()) JOptionPane.showMessageDialog(null,"Please Fill the Data First !","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(namescreen2.getSelectionModel().isEmpty())JOptionPane.showMessageDialog(null,"Select The Name !","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(sizescreen2.getSelectionModel().isEmpty())JOptionPane.showMessageDialog(null,"Select The Size !","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(quantityscreen2.getText().isEmpty())JOptionPane.showMessageDialog(null,"Select The Size !","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(colorscreen2.getText().isEmpty())JOptionPane.showMessageDialog(null,"Select The Size !","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(!TESTINPUT.orderQuantityTest(quantityscreen2.getText())) JOptionPane.showMessageDialog(null,"Unvalied Quantity","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(!TESTINPUT.orderColorTest(colorscreen2.getText())) JOptionPane.showMessageDialog(null,"Unvalied Color","ERROR",JOptionPane.ERROR_MESSAGE);
    else {
        HelloController h=new HelloController();
       String x= h.getZ();
        ResultSet customerEnteredId= database.createDatabase("select CID from CUSTOMER where GMAIL ="+"'"+x+"'");
        try{
            while (customerEnteredId.next()) {
                setCustomerEnteredId2(customerEnteredId.getString(1));
            }
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
        String type= namescreen2.getValue();
       if(sizescreen2.getValue().equals("SMALL")) {
           ResultSet r=database.createDatabase("select smallsalary from item where type='"+namescreen2.getValue()+"'");
           try{
               r.next();
               money=Integer.parseInt(quantityscreen2.getText())*Integer.parseInt(r.getString(1));
           } catch (SQLException e) {
               logger.log(null,"Database connection error: ");
           }
       }
                ResultSet r=database.createDatabase("select "+sizescreen2.getValue()+"salary from item where type='"+namescreen2.getValue()+"'");
                try{
                    r.next();
                    money=Integer.parseInt(quantityscreen2.getText())*Integer.parseInt(r.getString(1));
                } catch (SQLException e) {
                    logger.log(null,"Database connection error: ");
                }

         database.insertIntoDatabase("insert into PRODUCT values(productSequence1.nextval,'"+ "407222222"+"','"+customerEnteredId2+ "','"+namescreen2.getValue()+"','" +
                quantityscreen2.getText()+"','"+sizescreen2.getValue()+"','"+colorscreen2.getText()+"','"+"waiting"+"','"+money+"')");
        JOptionPane.showMessageDialog(null, "DONE ", "INSERTED", JOptionPane.INFORMATION_MESSAGE);
            name=namescreen2.getValue();
            quantity=quantityscreen2.getText();
            size=sizescreen2.getValue();
            color=colorscreen2.getText();
            orderPic=orderPicture;
            try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("screen3.fxml"));
            Stage stage = (Stage) save.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            new FadeIn(root).play();
            }catch (IOException e){
                logger.log(null," An error occurred while opening a new window:");
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
        ObservableList<String> o =FXCollections.observableArrayList();
        ResultSet r=database.createDatabase("select * from item");
        try {
            while (r.next()) {
                o.add(r.getString(1));
            }
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
        namescreen2.setItems(o);
        sizescreen2.setItems(FXCollections.observableArrayList("SMALL","MEDUIM","LARGE"));

    }
}
