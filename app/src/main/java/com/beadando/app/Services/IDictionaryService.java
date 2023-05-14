package com.beadando.app.Services;

import com.beadando.app.Models.DictionaryElement;

import java.util.List;
import java.util.UUID;

public interface IDictionaryService {
    List<DictionaryElement> findAllElement();
    List<DictionaryElement> generateQuizElements();
    void deleteElement(UUID id);
    void updateElement(DictionaryElement element);
    void addElement(DictionaryElement element);
}
