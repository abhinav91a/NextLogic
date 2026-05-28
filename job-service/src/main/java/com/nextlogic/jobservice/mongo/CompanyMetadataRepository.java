package com.nextlogic.jobservice.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CompanyMetadataRepository extends MongoRepository<CompanyMetadata, String> {
    Optional<CompanyMetadata> findByNameIgnoreCase(String name);
}
