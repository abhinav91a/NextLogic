package com.nextlogic.jobservice.service;

import com.nextlogic.jobservice.api.dto.JobResponse;
import com.nextlogic.jobservice.domain.Job;
import com.nextlogic.jobservice.mongo.CompanyMetadata;
import com.nextlogic.jobservice.mongo.CompanyMetadataRepository;
import com.nextlogic.jobservice.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final CompanyMetadataRepository metadataRepository;

    public JobResponse create(JobResponse request) {
        Job job = Job.builder()
                .companyId(request.getCompanyId())
                .title(request.getTitle())
                .location(request.getLocation())
                .url(request.getUrl())
                .companyMetadataId(null) // will be set by enrichment pipeline
                .build();

        Job saved = jobRepository.save(job);
        return toResponse(saved);
    }

    public List<JobResponse> findAll() {
        return jobRepository.findAll().stream()
                .map(this::toResponse)
                .collect(toList());
    }

    public JobResponse getById(Long id) {
        return jobRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow();
    }

    public JobResponse update(Long id, JobResponse request) {
        Job job = jobRepository.findById(id).orElseThrow();
        job.setTitle(request.getTitle());
        job.setLocation(request.getLocation());
        job.setUrl(request.getUrl());
        Job saved = jobRepository.save(job);
        return toResponse(saved);
    }

    public void delete(Long id) {
        jobRepository.deleteById(id);
    }

    private JobResponse toResponse(Job job) {

        CompanyMetadata metadata = null;

        if (job.getCompanyMetadataId() != null) {
            metadata = metadataRepository
                    .findById(job.getCompanyMetadataId())
                    .orElse(null);
        }

        return JobResponse.builder()
                .id(job.getId())
                .companyId(job.getCompanyId())
                .title(job.getTitle())
                .location(job.getLocation())
                .url(job.getUrl())
                .companyMetadata(metadata)
                .build();
    }
}
