package com.nextlogic.alertservice.service;

import com.nextlogic.alertservice.api.dto.AlertResponse;
import com.nextlogic.alertservice.domain.Alert;
import com.nextlogic.alertservice.kafka.ScrapedJobEvent;
import com.nextlogic.alertservice.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;

    /**
     * Called internally by AlertMatchingService when a job matches a user's preferences.
     */
    public void createAlert(Long userId, ScrapedJobEvent job) {
        Alert alert = Alert.builder()
                .userId(userId)
                .jobTitle(job.getTitle())
                .jobLocation(job.getLocation())
                .jobUrl(job.getUrl())
                .createdAt(Instant.now())
                .build();

        alertRepository.save(alert);
    }

    /**
     * Manual CRUD API support (optional).
     */
    public AlertResponse create(AlertResponse request) {
        Alert alert = Alert.builder()
                .userId(request.getUserId())
                .jobTitle(request.getJobTitle())
                .jobLocation(request.getJobLocation())
                .jobUrl(request.getJobUrl())
                .createdAt(Instant.now())
                .build();

        Alert saved = alertRepository.save(alert);
        return toResponse(saved);
    }

    public List<AlertResponse> findAll() {
        return alertRepository.findAll().stream()
                .map(this::toResponse)
                .collect(toList());
    }

    public AlertResponse getById(Long id) {
        return alertRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow();
    }

    public AlertResponse update(Long id, AlertResponse request) {
        Alert alert = alertRepository.findById(id).orElseThrow();

        alert.setJobTitle(request.getJobTitle());
        alert.setJobLocation(request.getJobLocation());
        alert.setJobUrl(request.getJobUrl());
        alert.setCreatedAt(Instant.now());

        Alert saved = alertRepository.save(alert);
        return toResponse(saved);
    }

    public void delete(Long id) {
        alertRepository.deleteById(id);
    }

    public void deleteAlertsByJobUrl(String jobUrl) {
        alertRepository.deleteByJobUrl(jobUrl);
    }


    private AlertResponse toResponse(Alert alert) {
        return AlertResponse.builder()
                .id(alert.getId())
                .userId(alert.getUserId())
                .jobTitle(alert.getJobTitle())
                .jobLocation(alert.getJobLocation())
                .jobUrl(alert.getJobUrl())
                .createdAt(alert.getCreatedAt())
                .build();
    }
}
