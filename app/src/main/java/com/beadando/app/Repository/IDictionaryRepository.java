package com.beadando.app.Repository;

import com.beadando.app.Models.DictionaryElement;

import java.util.List;
import java.util.UUID;

public interface IDictionaryRepository {
    List<DictionaryElement> findAllElement();
    void deleteElement(UUID id);
    void updateElement(DictionaryElement updateElement);
    void addElement(DictionaryElement addElement);
}
