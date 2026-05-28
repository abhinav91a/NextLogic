package com.nextlogic.scraperservice.client.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private String careersUrl;
    private String platform; // e.g. "GREENHOUSE", "LEVER", "CUSTOM"
}
