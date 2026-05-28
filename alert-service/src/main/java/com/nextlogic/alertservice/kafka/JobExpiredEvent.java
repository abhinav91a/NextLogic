package com.nextlogic.alertservice.kafka;

import lombok.Data;

@Data
public class JobExpiredEvent {
    private String url;
}
