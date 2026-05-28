package com.nextlogic.scraperservice.scraper.impl;

import com.nextlogic.scraperservice.domain.JobDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoteOkScraper {

    public List<JobDto> scrape() {
        // TODO: implement real scraping logic
        return List.of();
    }
}
