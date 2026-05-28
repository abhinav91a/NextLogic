package com.nextlogic.scraperservice.service;

import com.nextlogic.scraperservice.domain.JobDto;
import com.nextlogic.scraperservice.kafka.JobPublisher;
import com.nextlogic.scraperservice.scraper.impl.GreenhouseScraper;
import com.nextlogic.scraperservice.scraper.impl.LeverScraper;
import com.nextlogic.scraperservice.scraper.impl.RemoteOkScraper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Stream;

@Service
public class ScraperService {

    private final Executor scraperExecutor;
    private final GreenhouseScraper greenhouseScraper;
    private final LeverScraper leverScraper;
    private final RemoteOkScraper remoteOkScraper;
    private final JobPublisher jobPublisher;

    public ScraperService(Executor scraperExecutor,
                          GreenhouseScraper greenhouseScraper,
                          LeverScraper leverScraper,
                          RemoteOkScraper remoteOkScraper,
                          JobPublisher jobPublisher) {
        this.scraperExecutor = scraperExecutor;
        this.greenhouseScraper = greenhouseScraper;
        this.leverScraper = leverScraper;
        this.remoteOkScraper = remoteOkScraper;
        this.jobPublisher = jobPublisher;
    }

    public void scrapeAllSources() {

        CompletableFuture<List<JobDto>> greenhouseFuture =
                CompletableFuture.supplyAsync(greenhouseScraper::scrape, scraperExecutor);

        CompletableFuture<List<JobDto>> leverFuture =
                CompletableFuture.supplyAsync(leverScraper::scrape, scraperExecutor);

        CompletableFuture<List<JobDto>> remoteOkFuture =
                CompletableFuture.supplyAsync(remoteOkScraper::scrape, scraperExecutor);

        List<JobDto> allJobs = Stream.of(greenhouseFuture, leverFuture, remoteOkFuture)
                .map(CompletableFuture::join)
                .flatMap(List::stream)
                .toList();

        allJobs.forEach(jobPublisher::publish);
    }

    public String runScraper() {
        scrapeAllSources();
        return "Scraper started";
    }

    public String getStatus() {
        return "Scraper running";
    }
}
