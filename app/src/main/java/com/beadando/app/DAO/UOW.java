package com.beadando.app.DAO;

import com.beadando.app.Models.DictionaryElement;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UOW {
    public List<DictionaryElement> dictionaryReader(){
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<DictionaryElement>>() {}.getType();
            File jsonFile = new File("src/main/java/com/beadando/app/DAO/Dictionary.json");
            jsonFile.createNewFile();
            Reader reader = Files.newBufferedReader(Paths.get(jsonFile.getPath()));
            List<DictionaryElement> resultList = gson.fromJson(reader, listType);
            reader.close();
            return resultList;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void updateJson(List<DictionaryElement> updatedElements){
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<DictionaryElement>>() {}.getType();
            File jsonFile = new File("src/main/java/com/beadando/app/DAO/Dictionary.json");
            OutputStream outputStream = new FileOutputStream(jsonFile);
            outputStream.write(gson.toJson(updatedElements).getBytes());
            outputStream.flush();

        }catch (Exception ex){
            ex.printStackTrace();

        }
    }

}
