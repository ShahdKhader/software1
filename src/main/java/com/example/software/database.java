package com.example.software;

import animatefx.animation.FadeIn;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class database {
    static Logger logger = Logger.getLogger(HelloController.class.getName());

    public static ResultSet createDatabase(String string) {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("SN");
            ods.setPassword("123456");
            Connection con = ods.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(string);
            return rs;
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
        return null;
    }

    public static void insertIntoDatabase(String string) {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("SN");
            ods.setPassword("123456");
            Connection con = ods.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(string);
        } catch (SQLException e) {
            logger.log(null,"Database connection error: ");
        }
    }

}
