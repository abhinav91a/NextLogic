package com.nextlogic.scraperservice.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobExpiredEvent {
    private String url;
}
