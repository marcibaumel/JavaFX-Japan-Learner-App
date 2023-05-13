package com.beadando.app.Repository;

import com.beadando.app.Models.DictionaryElement;

import java.util.List;

public interface IDictionaryRepository {
    List<DictionaryElement> findAllElement();
    List<DictionaryElement> generateQuizElements();
    void deleteElement();
    void updateElement();
}
