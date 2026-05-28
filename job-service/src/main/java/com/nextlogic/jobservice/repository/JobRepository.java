package com.nextlogic.jobservice.repository;

import com.nextlogic.jobservice.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByUrl(String url);
    List<Job> findByExpiresAtBefore(Instant time);

}

