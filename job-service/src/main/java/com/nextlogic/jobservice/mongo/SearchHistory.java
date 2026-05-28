package com.nextlogic.jobservice.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("search_history")
public class SearchHistory {

    @Id
    private String id;

    private String userId;
    private String keyword;
    private long timestamp;
}
