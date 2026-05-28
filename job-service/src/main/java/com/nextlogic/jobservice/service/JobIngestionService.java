package com.nextlogic.jobservice.service;

import com.nextlogic.jobservice.domain.Job;
import com.nextlogic.jobservice.kafka.ScrapedJobEvent;
import com.nextlogic.jobservice.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobIngestionService {

    private final JobRepository jobRepository;

    /**
     * Main entry point for handling incoming job events from Kafka.
     */
    public void ingest(ScrapedJobEvent event) {
        log.info("Ingesting job: {} ({})", event.getTitle(), event.getUrl());

        Job job = jobRepository.findByUrl(event.getUrl())
                .map(existing -> update(existing, event))
                .orElseGet(() -> create(event));

        jobRepository.save(job);
    }

    /**
     * Create a new job entry from the event.
     */
    private Job create(ScrapedJobEvent e) {
        log.info("Creating new job for company {}", e.getCompanyName());

        return Job.builder()
                .companyId(e.getCompanyId())
                .title(e.getTitle())
                .location(e.getLocation())
                .url(e.getUrl())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .expiresAt(Instant.now().plus(Duration.ofDays(30))) // default 30 days
                .build();
    }

    /**
     * Update an existing job entry with new data.
     */
    private Job update(Job job, ScrapedJobEvent e) {
        log.info("Updating existing job: {}", job.getUrl());

        job.setTitle(e.getTitle());
        job.setLocation(e.getLocation());
        job.setUpdatedAt(Instant.now());
        job.setExpiresAt(Instant.now().plus(Duration.ofDays(30))); // extend expiry


        return job;
    }
}
