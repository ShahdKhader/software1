module com.example.software {
    requires javafx.controls;
    requires javafx.fxml;
    requires AnimateFX;

    requires java.naming;
    requires com.oracle.database.jdbc;
    requires java.sql;
    requires java.desktop;
    requires java.mail;

    opens com.example.software to javafx.fxml;
    exports com.example.software;
}