package com.beadando.app.Controllers;

import com.beadando.app.Models.DictionaryElement;
import com.beadando.app.Services.DictionaryService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    private final DictionaryService dictionaryService = new DictionaryService();
    @FXML
    public ListView<DictionaryElement> dictionaryElementsListView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dictionaryElementsListView.getItems().addAll(dictionaryService.findAllElement());
    }
    @FXML
    private void addButtonOnClick(){
        for (DictionaryElement e: dictionaryService.findAllElement()) {
            System.out.println(e.getWord());
        }
    };

    @FXML
    private void deleteButtonOnCLick(){

    }

    @FXML
    private void editButtonOnClick(){}
}
