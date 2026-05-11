package com.nextlogic.companyservice.api.dto;

import com.nextlogic.companyservice.domain.CareersPlatform;

import java.time.Instant;

public record CompanyResponse(
        Long id,
        String name,
        String websiteUrl,
        String careersUrl,
        CareersPlatform platform,
        String locationCity,
        String locationCountry,
        Instant createdAt,
        Instant updatedAt
) {}