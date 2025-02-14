module com.example.edpfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.edpfx to javafx.fxml;
    exports com.example.edpfx;
}