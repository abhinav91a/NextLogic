package com.nextlogic.jobservice.api.dto;

import com.nextlogic.jobservice.mongo.CompanyMetadata;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class JobResponse {
    Long id;
    String title;
    String description;
    String location;
    boolean remote;
    String companyName;

    CompanyMetadata companyMetadata;

    Long companyId;
    String url;
}
