module com.beadando.app {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires com.google.gson;
        
    opens com.beadando.app to javafx.fxml;
    exports com.beadando.app;
    exports com.beadando.app.Controllers;
    opens com.beadando.app.Controllers to javafx.fxml;
}