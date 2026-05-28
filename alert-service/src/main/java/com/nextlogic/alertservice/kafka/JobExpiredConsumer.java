package com.nextlogic.alertservice.kafka;

import com.nextlogic.alertservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobExpiredConsumer {

    private final AlertService alertService;

    @KafkaListener(topics = "${app.topics.job-expired}", groupId = "alert-service")
    public void consume(JobExpiredEvent event) {
        log.info("Received job.expired event for URL: {}", event.getUrl());
        alertService.deleteAlertsByJobUrl(event.getUrl());
    }
}
