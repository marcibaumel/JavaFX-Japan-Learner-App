package com.beadando.app.Services;

import com.beadando.app.Models.DictionaryElement;
import com.beadando.app.Repository.DictionaryRepository;

import java.util.List;

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
    public void deleteElement() {

    }

    @Override
    public void updateElement() {

    }
}
