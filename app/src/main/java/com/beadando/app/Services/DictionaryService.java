package com.beadando.app.Services;

import com.beadando.app.Models.DictionaryElement;
import com.beadando.app.Repository.DictionaryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DictionaryService implements IDictionaryService {
    private final DictionaryRepository dictionaryRepository = new DictionaryRepository();

    @Override
    public List<DictionaryElement> findAllElement() {
        return dictionaryRepository.findAllElement();
    }

    @Override
    public List<DictionaryElement> generateQuizElements() {
        Random rand = new Random();
        int quizElementsSize = 3;
        List<DictionaryElement> dictionaryElements = dictionaryRepository.findAllElement();
        List<DictionaryElement> quizElements = new ArrayList<>();
        if(dictionaryElements.size() > 0) {
            for (int i = 0; i < quizElementsSize; i++) {
                int randomNumber = rand.nextInt(dictionaryElements.size());
                DictionaryElement randomElement = dictionaryElements.get(randomNumber);
                quizElements.add(randomElement);
            }
        }
        return quizElements;
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
