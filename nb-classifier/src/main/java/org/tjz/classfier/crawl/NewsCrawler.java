package org.tjz.classfier.crawl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class NewsCrawler extends WebCrawler {

    
    
    private List<WebEntity> localData = new ArrayList<WebEntity>();
    private WebUtil webUtil = new WebUtil();
    private final static Pattern FILTERS = Pattern
            .compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp3|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        if (FILTERS.matcher(href).matches()) {
            return false;
        }
        
        if (href.startsWith("http://money.163.com/")) {
            return true;
        }
        else if (href.startsWith("http://ent.163.com/")) {
            return true;
        }
        else if (href.startsWith("http://sports.163.com/")) {
            return true;
        }
        
        return false;
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();

            String type = "";
            if (url.startsWith("http://money.163.com/")) {
                type = "money";
            } else if (url.startsWith("http://ent.163.com/")) {
                type = "ent";
            } else if (url.startsWith("http://sports.163.com/")) {
                type = "sports";
            }

            int docId = page.getWebURL().getDocid();

            String text = htmlParseData.getText();
            text = text.replaceAll("\\s*|\n|\r|\t", "");
            Map<String, Integer> wordCount = webUtil.getFreqData(text);

            int totalWords = 0;
            for (int count : wordCount.values()) {
                totalWords += count;
            }

            WebEntity web = new WebEntity(docId, url, htmlParseData.getTitle(),
                    type, totalWords, wordCount);
            localData.add(web);
        }
    }

    @Override
    public Object getMyLocalData() {
        return localData;
    }
}
