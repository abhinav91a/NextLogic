package com.nextlogic.jobservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
public class JobSearchResponse {
    private Page<?> jobs;
}
