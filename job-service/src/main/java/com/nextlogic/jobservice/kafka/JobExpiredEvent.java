package com.nextlogic.jobservice.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobExpiredEvent {
    private Long jobId;
    private String url;
}
