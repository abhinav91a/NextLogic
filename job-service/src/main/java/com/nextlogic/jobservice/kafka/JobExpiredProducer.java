package com.nextlogic.jobservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JobExpiredProducer {

    private final KafkaTemplate<String, JobExpiredEvent> kafkaTemplate;

    @Value("${app.topics.job-expired}")
    private String topic;

    public void publish(JobExpiredEvent event) {
        kafkaTemplate.send(topic, event);
    }
}
