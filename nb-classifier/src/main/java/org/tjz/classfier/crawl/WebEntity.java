package org.tjz.classfier.crawl;

import java.util.Map;

public class WebEntity {
    private int docId;
    private String url;
    private String title;
    private String type;
    private int totalWords;
    private Map<String, Integer> wordCount;
    
    public WebEntity(int docId, String url, String title, String type,
            int totalWords, Map<String, Integer> wordCount) {
        super();
        this.docId = docId;
        this.url = url;
        this.title = title;
        this.type = type;
        this.totalWords = totalWords;
        this.wordCount = wordCount;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }

    public void setWordCount(Map<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }
    
    
}
