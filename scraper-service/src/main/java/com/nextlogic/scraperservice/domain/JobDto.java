package com.nextlogic.scraperservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDto {
    private String id;
    private String title;
    private Long companyId;
    private String location;
    private String url;
}
