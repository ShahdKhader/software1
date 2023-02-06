module com.example.software {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.software to javafx.fxml;
    exports com.example.software;
}