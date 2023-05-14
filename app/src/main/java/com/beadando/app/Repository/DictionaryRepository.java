package com.beadando.app.Repository;

import com.beadando.app.DAO.UOW;
import com.beadando.app.Models.DictionaryElement;

import java.util.List;
import java.util.UUID;

public class DictionaryRepository implements IDictionaryRepository {
    private final UOW uow = new UOW();
    private List<DictionaryElement> elements;

    @Override
    public List<DictionaryElement> findAllElement() {
        elements = uow.dictionaryReader();
        return elements;
    }

    @Override
    public List<DictionaryElement> generateQuizElements() {
        return null;
    }
    @Override
    public void deleteElement(UUID id) {
        findAllElement();
        try {
            elements.removeIf(e -> e.getId().equals(id));
            uow.updateJson(elements);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateElement(DictionaryElement updateElement) {
        findAllElement();
        try {
            int searchedElementIndex = -1;
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getId().equals(updateElement.getId())) {
                    searchedElementIndex = i;
                }
            }
            if (searchedElementIndex > -1) {
                elements.set(searchedElementIndex, updateElement);
                uow.updateJson(elements);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addElement(DictionaryElement addElement) {
        findAllElement();
        System.out.println(addElement);
        if (!addElement.getMeaning().isEmpty() && !addElement.getWord().isEmpty()) {
            try {
                elements.add(elements.size(),addElement);
                uow.updateJson(elements);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
