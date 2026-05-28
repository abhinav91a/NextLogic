package com.nextlogic.alertservice.kafka;

import lombok.Data;

@Data
public class ScrapedJobEvent {
    private Long companyId;
    private String companyName;
    private String title;
    private String location;
    private String url;
}
