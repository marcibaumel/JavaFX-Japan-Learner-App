package com.beadando.app.Controllers;

import com.beadando.app.Main;
import com.beadando.app.Models.DictionaryElement;
import com.beadando.app.Services.DictionaryService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Date;

public class ElementEditorController {
    @FXML
    private TextField wordTextField;
    @FXML
    private TextField meaningTextField;
    @FXML
    private TextField sentenceTextField;
    @FXML
    private Slider difficultySlider;
    private DictionaryElement updateElement;
    private final DictionaryService dictionaryService = new DictionaryService();

    public void initData(DictionaryElement element) {
        updateElement = element;

        if (updateElement != null) {
            wordTextField.setText(updateElement.getWord());
            meaningTextField.setText(updateElement.getMeaning());
            sentenceTextField.setText(updateElement.getSentence());
            difficultySlider.setValue(updateElement.getDifficulty());
        }
    }

    public void errorMessage(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Data error");
        alert.setHeaderText("Something wrong with your given data");
        alert.setContentText("Please give valid values");
        alert.showAndWait();

        wordTextField.setText("");
        meaningTextField.setText("");
        sentenceTextField.setText("");
        difficultySlider.setValue(0);

        if (updateElement != null) {
            wordTextField.setText(updateElement.getWord());
            meaningTextField.setText(updateElement.getMeaning());
            sentenceTextField.setText(updateElement.getSentence());
            difficultySlider.setValue(updateElement.getDifficulty());
        }
    }

    public void backToEditView(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Edit.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
        backToEditView(event);
    }

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        System.out.println((int)difficultySlider.getValue());
        if (updateElement == null) {
            if (checkField(wordTextField, 1, 15) && checkField(meaningTextField, 1, 15) && checkField(sentenceTextField, 3, 25) && isJapaneseCharacter(wordTextField)) {
                DictionaryElement newElement = new DictionaryElement(wordTextField.getText(), meaningTextField.getText(), sentenceTextField.getText(), (int)difficultySlider.getValue());
                System.out.println(newElement);
                dictionaryService.addElement(newElement);
                backToEditView(event);
            }
            else {
                errorMessage();
            }
        } else {
            if (checkField(wordTextField, 1, 15) && checkField(meaningTextField, 1, 15) && checkField(sentenceTextField, 3, 25) && isJapaneseCharacter(wordTextField)) {
                updateElement.setWord(wordTextField.getText());
                updateElement.setMeaning(meaningTextField.getText());
                updateElement.setSentence(sentenceTextField.getText());
                updateElement.setDifficulty((int)difficultySlider.getValue());
                updateElement.setLastEditDate(new Date());

                dictionaryService.updateElement(updateElement);
                backToEditView(event);
            }
            else {
                errorMessage();
            }
        }
    }

    private boolean checkField(TextField field, int minLength, int maxLength) {
        if (field.getText() == null || field.getText().trim().isEmpty() || field.getText().trim().length() < minLength || field.getText().trim().length() > maxLength) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isJapaneseCharacter(TextField field) {
        boolean hasJapanese = false;
        if (field.getText().trim().length() > 0) {
            for (char c : field.getText().trim().toCharArray()) {
                if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                        || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HIRAGANA
                        || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.KATAKANA
                        || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                        || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                        || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
                    hasJapanese = true;
                    break;
                }
            }
        }

        return hasJapanese;
    }
}
