package com.nextlogic.jobservice.scheduler;

import com.nextlogic.jobservice.kafka.JobExpiredEvent;
import com.nextlogic.jobservice.kafka.JobExpiredProducer;
import com.nextlogic.jobservice.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobExpiryScheduler {

    private final JobRepository jobRepository;
    private final JobExpiredProducer jobExpiredProducer;

    @Scheduled(cron = "0 0 * * * *") // every hour
    public void removeExpiredJobs() {
        var now = Instant.now();
        var expired = jobRepository.findByExpiresAtBefore(now);

        if (!expired.isEmpty()) {
            log.info("Removing {} expired jobs", expired.size());

            expired.forEach(job -> {
                jobExpiredProducer.publish(new JobExpiredEvent(job.getId(), job.getUrl()));
            });

            jobRepository.deleteAll(expired);
        }
    }
}
