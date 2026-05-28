package com.nextlogic.scraperservice.api;

import com.nextlogic.scraperservice.api.dto.ScraperResponse;
import com.nextlogic.scraperservice.service.ScraperService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scraper")
public class ScraperController {

    private final ScraperService scraperService;

    public ScraperController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @PostMapping("/run")
    public ScraperResponse runScraper() {
        String message = scraperService.runScraper();
        return new ScraperResponse(message, "OK");
    }

    @GetMapping("/status")
    public ScraperResponse getStatus() {
        String message = scraperService.getStatus();
        return new ScraperResponse(message, "OK");
    }
}
