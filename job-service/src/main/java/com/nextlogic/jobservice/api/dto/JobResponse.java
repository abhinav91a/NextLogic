package com.nextlogic.jobservice.api.dto;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class JobResponse {
    Long id;
    Long companyId;
    String title;
    String location;
    String url;
    Instant createdAt;
    Instant updatedAt;
}
