package com.nextlogic.scrapperservice.service;

import com.nextlogic.scrapperservice.api.dto.ScrapperResponse;
import com.nextlogic.scrapperservice.domain.Scrapper;
import com.nextlogic.scrapperservice.repository.ScrapperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ScrapperService {

    private final ScrapperRepository scrapperRepository;

    public ScrapperResponse create(ScrapperResponse request) {
        Scrapper scrapper = Scrapper.builder()
                .companyId(request.getCompanyId())
                .title(request.getTitle())
                .location(request.getLocation())
                .url(request.getUrl())
                .build();
        Scrapper saved = scrapperRepository.save(scrapper);
        return toResponse(saved);
    }

    public List<ScrapperResponse> findAll() {
        return scrapperRepository.findAll().stream()
                .map(this::toResponse)
                .collect(toList());
    }

    public ScrapperResponse getById(Long id) {
        return scrapperRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow();
    }

    public ScrapperResponse update(Long id, ScrapperResponse request) {
        Scrapper scrapper = scrapperRepository.findById(id).orElseThrow();
        scrapper.setTitle(request.getTitle());
        scrapper.setLocation(request.getLocation());
        scrapper.setUrl(request.getUrl());
        Scrapper saved = scrapperRepository.save(scrapper);
        return toResponse(saved);
    }

    public void delete(Long id) {
        scrapperRepository.deleteById(id);
    }

    private ScrapperResponse toResponse(Scrapper Scrapper) {
        return ScrapperResponse.builder()
                .id(Scrapper.getId())
                .companyId(Scrapper.getCompanyId())
                .title(Scrapper.getTitle())
                .location(Scrapper.getLocation())
                .url(Scrapper.getUrl())
                .createdAt(Scrapper.getCreatedAt())
                .updatedAt(Scrapper.getUpdatedAt())
                .build();
    }
}
