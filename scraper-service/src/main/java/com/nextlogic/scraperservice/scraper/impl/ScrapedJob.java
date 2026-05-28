package com.nextlogic.scraperservice.scraper.impl;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScrapedJob {
    String title;
    String location;
    String url;
}
