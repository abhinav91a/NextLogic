package com.nextlogic.userservice.api.dto;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class UserResponse {
    Long id;
    Long companyId;
    String title;
    String location;
    String url;
    Instant createdAt;
    Instant updatedAt;
}
