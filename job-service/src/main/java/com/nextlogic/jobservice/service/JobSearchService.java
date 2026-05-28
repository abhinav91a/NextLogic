package com.nextlogic.jobservice.service;

import com.nextlogic.jobservice.api.dto.JobSearchRequest;
import com.nextlogic.jobservice.domain.Job;
import com.nextlogic.jobservice.repository.JobRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class JobSearchService {

    private final JobRepository jobRepository;

    public JobSearchService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Page<Job> search(JobSearchRequest request) {

        Pageable pageable = PageRequest.of(
                request.getPage(),
                request.getSize(),
                Sort.by(request.getSort().split(",")[0]).descending()
        );

        String keyword = request.getKeyword() == null ? "" : request.getKeyword();
        String location = request.getLocation() == null ? "" : request.getLocation();

        if (request.getCompany() != null) {
            return jobRepository.findByTitleContainingIgnoreCaseAndCompany_NameContainingIgnoreCase(
                    keyword, request.getCompany(), pageable
            );
        }

        if (request.getRemote() != null) {
            return jobRepository.findByTitleContainingIgnoreCaseAndRemote(
                    keyword, request.getRemote(), pageable
            );
        }

        return jobRepository.findByTitleContainingIgnoreCaseAndLocationContainingIgnoreCase(
                keyword, location, pageable
        );
    }

}
