package com.nextlogic.alertservice.service;

import com.nextlogic.alertservice.api.dto.AlertResponse;
import com.nextlogic.alertservice.domain.Alert;
import com.nextlogic.alertservice.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertResponse create(AlertResponse request) {
        Alert alert = Alert.builder()
                .companyId(request.getCompanyId())
                .title(request.getTitle())
                .location(request.getLocation())
                .url(request.getUrl())
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
        alert.setTitle(request.getTitle());
        alert.setLocation(request.getLocation());
        alert.setUrl(request.getUrl());
        Alert saved = alertRepository.save(alert);
        return toResponse(saved);
    }

    public void delete(Long id) {
        alertRepository.deleteById(id);
    }

    private AlertResponse toResponse(Alert Alert) {
        return AlertResponse.builder()
                .id(Alert.getId())
                .companyId(Alert.getCompanyId())
                .title(Alert.getTitle())
                .location(Alert.getLocation())
                .url(Alert.getUrl())
                .createdAt(Alert.getCreatedAt())
                .updatedAt(Alert.getUpdatedAt())
                .build();
    }
}
