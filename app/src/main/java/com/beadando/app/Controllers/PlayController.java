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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayController implements Initializable {
    private final DictionaryService dictionaryService = new DictionaryService();
    @FXML
    private Label wordOneLabel;
    @FXML
    private Label wordTwoLabel;
    @FXML
    private Label wordThreeLabel;
    @FXML
    private Label helperSentenceOneTextField;
    @FXML
    private Label helperSentenceTwoTextField;
    @FXML
    private Label helperSentenceThreeTextField;
    @FXML
    private TextField wordOneTextField;
    @FXML
    private TextField wordTwoTextField;
    @FXML
    private TextField wordThreeTextField;
    @FXML
    private Button resultButton;
    private List<DictionaryElement> quizElements = new ArrayList<>();

    @FXML
    private void resultButtonOnCLick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Result.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ResultController resultController = fxmlLoader.getController();
            resultController.initData(generateResult());
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quizElements = dictionaryService.generateQuizElements();
        wordOneLabel.setText(quizElements.get(0).getWord());
        wordTwoLabel.setText(quizElements.get(1).getWord());
        wordThreeLabel.setText(quizElements.get(2).getWord());
        helperSentenceOneTextField.setText(quizElements.get(0).getSentence());
        helperSentenceTwoTextField.setText(quizElements.get(1).getSentence());
        helperSentenceThreeTextField.setText(quizElements.get(2).getSentence());
    }

    private int generateResult() {
        int result = 0;
        if (quizElements.size() > 0) {
            if (wordOneTextField.getText().equals(quizElements.get(0).getMeaning())) {
                result++;
            }

            if (wordTwoTextField.getText().equals(quizElements.get(1).getMeaning())) {
                result++;
            }

            if (wordThreeTextField.getText().equals(quizElements.get(2).getMeaning())) {
                result++;
            }
        }
        float calculation = ((float)result/3) * 100;
        return (int)calculation;
    }


    /*
    TODO:
    - Generate result
    - Open result view
    - Export pdf
     */

}
