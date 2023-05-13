package com.beadando.app.Repository;

import com.beadando.app.DAO.UOW;
import com.beadando.app.Models.DictionaryElement;

import java.util.List;

public class DictionaryRepository implements IDictionaryRepository{
    private UOW uow = new UOW();
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
    public void deleteElement() {

    }

    @Override
    public void updateElement() {

    }
}
