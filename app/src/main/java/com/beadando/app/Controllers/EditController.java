package com.beadando.app.Controllers;

import com.beadando.app.Main;
import com.beadando.app.Models.DictionaryElement;
import com.beadando.app.Services.DictionaryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    private final DictionaryService dictionaryService = new DictionaryService();
    @FXML
    public ListView<DictionaryElement> dictionaryElementsListView;
    private List<DictionaryElement> dictionaryElements;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionaryElements = dictionaryService.findAllElement();
        if(dictionaryElements != null) {
            dictionaryElementsListView.getItems().addAll(dictionaryElements);
        }
    }

    @FXML
    private void addButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementEditor.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteButtonOnCLick(ActionEvent event) {
        int selectedItem = dictionaryElementsListView.getSelectionModel().getSelectedIndex();
        if (selectedItem != -1) {
            DictionaryElement selectedModel = dictionaryElementsListView.getItems().get(selectedItem);
            dictionaryElementsListView.getItems().remove(selectedItem);
            dictionaryElements.remove(selectedModel);
            dictionaryService.deleteElement(selectedModel.getId());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("No element selected");
            alert.setContentText("Please select a valid element to delete");
            alert.showAndWait();
        }
    }

    @FXML
    private void editButtonOnClick(ActionEvent event) {
        int selectedItem = dictionaryElementsListView.getSelectionModel().getSelectedIndex();
        if (selectedItem != -1) {
            DictionaryElement selectedModel = dictionaryElementsListView.getItems().get(selectedItem);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ElementEditor.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ElementEditorController elementEditorController = fxmlLoader.getController();
                elementEditorController.initData(selectedModel);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("No element selected");
            alert.setContentText("Please select a valid element to edit");
            alert.showAndWait();
        }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Welcome.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
