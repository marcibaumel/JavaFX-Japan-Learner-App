package com.beadando.app.Services;

import com.beadando.app.Models.DictionaryElement;

import java.util.List;

public interface IDictionaryService {
    List<DictionaryElement> findAllElement();
    List<DictionaryElement> generateQuizElements();
    void deleteElement();
    void updateElement();
}
