package com.beadando.app.Services;

import com.beadando.app.Models.DictionaryElement;
import com.beadando.app.Repository.DictionaryRepository;

import java.util.List;
import java.util.UUID;

public class DictionaryService implements IDictionaryService {
    private final DictionaryRepository dictionaryRepository = new DictionaryRepository();

    @Override
    public List<DictionaryElement> findAllElement() {
        return dictionaryRepository.findAllElement();
    }

    @Override
    public List<DictionaryElement> generateQuizElements() {
        return null;
    }

    @Override
    public void deleteElement(UUID id) {
        dictionaryRepository.deleteElement(id);
    }

    @Override
    public void updateElement(DictionaryElement element) {
        dictionaryRepository.updateElement(element);
    }

    @Override
    public void addElement(DictionaryElement element) {
        dictionaryRepository.addElement(element);
    }
}
