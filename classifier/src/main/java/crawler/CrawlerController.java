package crawler;

import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlerController {
    private List<WebEntity> webData;

    public CrawlerController(List<WebEntity> webData) {
        this.webData = webData;
    }

    @SuppressWarnings("unchecked")
    public void work(String url, int num) {
        String crawlStorageFolder = "crawlData";
        int numberOfCrawlers = 3;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxPagesToFetch(num);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,
                pageFetcher);
        CrawlController controller;
        try {
            controller = new CrawlController(config, pageFetcher,
                    robotstxtServer);

            /*
             * For each crawl, you need to add some seed urls. These are the
             * first URLs that are fetched and then the crawler starts following
             * links which are found in these pages
             */
            controller.addSeed(url);

            /*
             * Start the crawl. This is a blocking operation, meaning that your
             * code will reach the line after this only when crawling is
             * finished.
             */
            controller.start(Crawler.class, numberOfCrawlers);
            controller.waitUntilFinish();
            for (Object item : controller.getCrawlersLocalData()) {
                webData.addAll((List<WebEntity>) item);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
