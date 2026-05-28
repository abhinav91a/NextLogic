package com.nextlogic.scraperservice.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScrapedJobEvent {
    private Long companyId;
    private String companyName;
    private String title;
    private String location;
    private String url;
}
