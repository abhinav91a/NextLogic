package com.nextlogic.jobservice.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("company_metadata")
public class CompanyMetadata {

    @Id
    private String id;

    private String name;
    private String logoUrl;
    private String industry;
    private String size;
    private String website;

}
