package com.nextlogic.companyservice.service;
import com.nextlogic.companyservice.api.dto.CompanyResponse;
import com.nextlogic.companyservice.domain.Company;
import com.nextlogic.companyservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    @Transactional
    public CompanyResponse create(CompanyResponse request) {
        Company company = Company.builder()
                .name(request.name())
                .websiteUrl(request.websiteUrl())
                .careersUrl(request.careersUrl())
                .platform(request.platform())
                .locationCity(request.locationCity())
                .locationCountry(request.locationCountry())
                .build();

        Company saved = repository.save(company);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CompanyResponse> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public CompanyResponse getById(Long id) {
        Company company = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company not found: " + id));
        return toResponse(company);
    }

    @Transactional
    public CompanyResponse update(Long id, CompanyResponse request) {
        Company company = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company not found: " + id));

        company.setName(request.name());
        company.setWebsiteUrl(request.websiteUrl());
        company.setCareersUrl(request.careersUrl());
        company.setPlatform(request.platform());
        company.setLocationCity(request.locationCity());
        company.setLocationCountry(request.locationCountry());

        return toResponse(company);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CompanyResponse toResponse(Company c) {
        return new CompanyResponse(
                c.getId(),
                c.getName(),
                c.getWebsiteUrl(),
                c.getCareersUrl(),
                c.getPlatform(),
                c.getLocationCity(),
                c.getLocationCountry(),
                c.getCreatedAt(),
                c.getUpdatedAt()
        );
    }
}