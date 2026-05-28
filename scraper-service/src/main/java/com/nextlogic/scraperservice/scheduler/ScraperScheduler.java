package com.nextlogic.scraperservice.scheduler;

import com.nextlogic.scraperservice.service.ScraperService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScraperScheduler {

    private final ScraperService scraperService;

    public ScraperScheduler(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @Scheduled(fixedDelayString = "600000") // every 10 minutes
    public void runScraper() {
        scraperService.scrapeAllSources();
    }
}
