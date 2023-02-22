module com.example.trabalho_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens App to javafx.fxml;
    exports App;
    opens Controller to javafx.fxml;
    exports Controller;
    opens Models to javafx.fxml;
    exports Models;
}