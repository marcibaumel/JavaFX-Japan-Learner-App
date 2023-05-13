package com.beadando.app.Repository;

import com.beadando.app.DAO.UOW;
import com.beadando.app.Models.DictionaryElement;

import java.util.List;

public class DictionaryRepository implements IDictionaryRepository{
    private UOW uow = new UOW();

    @Override
    public List<DictionaryElement> findAllElement() {
        return uow.dictionaryReader();
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
