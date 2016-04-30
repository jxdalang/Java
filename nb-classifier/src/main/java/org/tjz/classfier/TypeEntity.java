package org.tjz.classfier;

import java.util.Map;

public class TypeEntity {
    private String name;
    private int totalWords;
    private int pages;
    private Map<String, Double> freqData;

    public TypeEntity(String name, int totalWords, int pages,
            Map<String, Double> freqData) {
        super();
        this.name = name;
        this.totalWords = totalWords;
        this.pages = pages;
        this.freqData = freqData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Map<String, Double> getFreqData() {
        return freqData;
    }

    public void setFreqData(Map<String, Double> freqData) {
        this.freqData = freqData;
    }

}
