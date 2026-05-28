package com.nextlogic.scraperservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScraperResponse {
    private String message;
    private String status;
}
