package com.beadando.app.Controllers;

import com.beadando.app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class ResultController {
    @FXML
    private ProgressBar resultProgressBar;
    @FXML
    private ProgressIndicator resultProgressIndicator;
    @FXML
    private Button generateButton;
    @FXML
    private Button doneButton;

    @FXML
    private void doneButtonOnCLick(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Welcome.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void generateButtonOnClick(ActionEvent event){

    }
}
