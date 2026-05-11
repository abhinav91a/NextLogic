package com.nextlogic.jobservice.service;

import com.nextlogic.jobservice.api.dto.JobResponse;
import com.nextlogic.jobservice.domain.Job;
import com.nextlogic.jobservice.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public JobResponse create(JobResponse request) {
        Job job = Job.builder()
                .companyId(request.getCompanyId())
                .title(request.getTitle())
                .location(request.getLocation())
                .url(request.getUrl())
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
        return JobResponse.builder()
                .id(job.getId())
                .companyId(job.getCompanyId())
                .title(job.getTitle())
                .location(job.getLocation())
                .url(job.getUrl())
                .createdAt(job.getCreatedAt())
                .updatedAt(job.getUpdatedAt())
                .build();
    }
}
