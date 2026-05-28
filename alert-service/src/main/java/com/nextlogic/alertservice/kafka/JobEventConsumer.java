package com.nextlogic.alertservice.kafka;

import com.nextlogic.alertservice.service.AlertMatchingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobEventConsumer {

    private final AlertMatchingService matchingService;

    @KafkaListener(topics = "${app.topics.job-created}", groupId = "alert-service")
    public void onJobCreated(ScrapedJobEvent event) {
        log.info("Alert-service received job: {}", event.getTitle());
        matchingService.match(event);
    }
}
