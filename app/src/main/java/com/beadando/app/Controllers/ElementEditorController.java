package com.beadando.app.Controllers;

import com.beadando.app.Main;
import com.beadando.app.Models.DictionaryElement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public void initData(DictionaryElement element) {

        updateElement = element;
        if (updateElement != null) {
            wordTextField.setText(updateElement.getWord());
            meaningTextField.setText(updateElement.getMeaning());
            sentenceTextField.setText(updateElement.getSentence());
        }
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) {
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
    private void saveButtonOnClick() {
        System.out.println(difficultySlider.getValue());
        if (updateElement == null) {
            if (checkField(wordTextField, 1, 15) && checkField(meaningTextField, 1, 15) && checkField(sentenceTextField, 1, 25) && isJapaneseCharacter(wordTextField)) {
                //DictionaryElement newElement = new DictionaryElement()
            }
        } else {

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
            for (char c : field.getText().trim().toString().toCharArray()) {
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
