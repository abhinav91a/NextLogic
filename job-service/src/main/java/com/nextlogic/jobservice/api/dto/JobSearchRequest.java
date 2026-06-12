package com.nextlogic.jobservice.api.dto;

import lombok.Data;

@Data
public class JobSearchRequest {

    private String keyword;      // text search on title
    private String location;     // filter by location
    private Long companyId;      // filter by companyId (matches Job entity)

    private Integer page = 0;    // pagination
    private Integer size = 10;   // pagination
    private String sort = "createdAt,desc"; // default sorting
}
