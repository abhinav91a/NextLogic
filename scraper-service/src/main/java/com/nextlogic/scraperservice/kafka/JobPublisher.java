package com.nextlogic.scraperservice.kafka;

import com.nextlogic.scraperservice.domain.JobDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobPublisher {

    private final KafkaTemplate<String, JobDto> kafkaTemplate;

    public JobPublisher(KafkaTemplate<String, JobDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(JobDto job) {
        kafkaTemplate.send("jobs-topic", job.getId(), job);
    }
}
