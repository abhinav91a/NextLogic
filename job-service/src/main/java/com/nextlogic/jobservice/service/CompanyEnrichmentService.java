package com.nextlogic.jobservice.service;

import com.nextlogic.jobservice.mongo.CompanyMetadata;
import com.nextlogic.jobservice.mongo.CompanyMetadataRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyEnrichmentService {

    private final CompanyMetadataRepository metadataRepository;

    public CompanyEnrichmentService(CompanyMetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    public CompanyMetadata enrich(String companyName) {
        return metadataRepository
                .findByNameIgnoreCase(companyName)
                .orElseGet(() -> {
                    CompanyMetadata meta = new CompanyMetadata();
                    meta.setName(companyName);
                    meta.setLogoUrl("https://logo.clearbit.com/" + companyName + ".com");
                    meta.setWebsite("https://www." + companyName.toLowerCase() + ".com");
                    meta.setIndustry("Unknown");
                    meta.setSize("Unknown");
                    return metadataRepository.save(meta);
                });
    }
}
