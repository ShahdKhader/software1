module com.example.software {
    requires javafx.controls;
    requires javafx.fxml;


    requires java.naming;
    requires com.oracle.database.jdbc;
    requires java.sql;
    requires java.desktop;

    opens com.example.software to javafx.fxml;
    exports com.example.software;
}