package com.beadando.app.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DictionaryElement {
    private int id;
    private String word;
    private String meaning;
    private String sentence;
    private Date lastEditDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public DictionaryElement(int id, String word, String meaning, String sentence, String lastEditDate) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.sentence = sentence;

    }

    @Override
    public String toString() {
        return  word + '\t' + meaning ;
    }

    public DictionaryElement() {
    }
}
