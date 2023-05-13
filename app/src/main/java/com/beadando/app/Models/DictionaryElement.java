package com.beadando.app.Models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DictionaryElement {
    private UUID id;
    private int difficulty;
    private String word;
    private String meaning;
    private String sentence;
    private Date lastEditDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
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

    public DictionaryElement(String word, String meaning, String sentence, int difficulty) {
        this.id = UUID.randomUUID();
        this.difficulty = difficulty;
        this.word = word;
        this.meaning = meaning;
        this.sentence = sentence;
        this.lastEditDate = new Date();
    }

    @Override
    public String toString() {
        return  word + '\t' + meaning ;
    }

    public DictionaryElement() {
    }
}
