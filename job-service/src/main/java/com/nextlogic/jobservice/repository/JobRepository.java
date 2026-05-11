package com.nextlogic.jobservice.repository;

import com.nextlogic.jobservice.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
