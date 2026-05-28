package com.nextlogic.jobservice.api.dto;

import lombok.Data;

@Data
public class JobSearchRequest {
    private String keyword;
    private String location;
    private String company;
    private Boolean remote;
    private int page = 0;
    private int size = 20;
    private String sort = "createdAt,desc";
}
