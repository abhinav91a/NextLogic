package com.nextlogic.jobservice.repository;

import com.nextlogic.jobservice.domain.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByUrl(String url);
    List<Job> findByExpiresAtBefore(Instant time);
    Page<Job> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Job> findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCase(
            String title, String location, Pageable pageable);
    Page<Job> findByTitleContainingIgnoreCaseAndCompany_NameContainingIgnoreCase(
            String title, String company, Pageable pageable);
    Page<Job> findByTitleContainingIgnoreCaseAndRemote(
            String title, boolean remote, Pageable pageable);


}

