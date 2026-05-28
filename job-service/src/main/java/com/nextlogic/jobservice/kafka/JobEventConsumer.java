package com.nextlogic.jobservice.kafka;

import com.nextlogic.jobservice.service.JobIngestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobEventConsumer {

    private final JobIngestionService ingestionService;

    @KafkaListener(topics = "${app.topics.job-created}", groupId = "job-service")
    public void onJobCreated(ScrapedJobEvent event) {
        log.info("Received job event: {} - {}", event.getCompanyName(), event.getTitle());
        ingestionService.ingest(event);
    }
}
