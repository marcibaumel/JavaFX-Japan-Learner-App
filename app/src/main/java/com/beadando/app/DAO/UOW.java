package com.beadando.app.DAO;

import com.beadando.app.Models.DictionaryElement;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UOW {
    private List<DictionaryElement> dictionaryElementList;

    public UOW(){
        this.dictionaryElementList = dictionaryReader();
    }

    public List<DictionaryElement> dictionaryReader(){
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<DictionaryElement>>() {
            }.getType();
            Reader reader = Files.newBufferedReader(Paths.get(""));
            List<DictionaryElement> resultList = gson.fromJson(reader, listType);
            reader.close();
            return resultList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void updateJson(List<DictionaryElement> updatedElements){

    }

}
