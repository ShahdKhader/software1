package com.example.software;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;

public class Screen2 implements Initializable {


    @FXML
    private ImageView menu ;

    @FXML
    private AnchorPane Pane1, menuPane2;



    @java.lang.Override
    public void initialize(java.net.URL url, java.util.ResourceBundle resourceBundle) {
        menu.setOnMouseClicked(event -> {
            Pane1.setVisible(true);

        });
        Pane1.setVisible(false);
    }




    }


