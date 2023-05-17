package com.beadando.app.Controllers;

import com.beadando.app.Main;
import com.beadando.app.Services.DocumentGeneratorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class ResultController {
    private final DocumentGeneratorService documentGeneratorService = new DocumentGeneratorService();
    @FXML
    private ProgressBar resultProgressBar;
    @FXML
    private ProgressIndicator resultProgressIndicator;
    @FXML
    private Button generateButton;
    @FXML
    private Button doneButton;
    private double finalResult;

    @FXML
    private void doneButtonOnCLick(ActionEvent event) {
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
    private void generateButtonOnClick(ActionEvent event) {
        documentGeneratorService.generateDocument((int) (finalResult * 100));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Document is successfully generated");
        alert.showAndWait();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Welcome.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println((int) (finalResult * 100));
    }

    public void initData(int result) {
        finalResult = (double) result / 100;
        resultProgressBar.setProgress(finalResult);
        resultProgressIndicator.setProgress(finalResult);
    }
}
