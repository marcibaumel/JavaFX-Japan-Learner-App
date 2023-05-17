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
            requires itextpdf;
        
    opens com.beadando.app to javafx.fxml;
    exports com.beadando.app;
    exports com.beadando.app.Controllers;
    exports com.beadando.app.Models;
    opens com.beadando.app.Models;
    opens com.beadando.app.Controllers to javafx.fxml;
}