package com.nextlogic.alertservice.api.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class AlertResponse {

    private Long id;
    private Long userId;

    private String jobTitle;
    private String jobLocation;
    private String jobUrl;

    private Instant createdAt;



}
