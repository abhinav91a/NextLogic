package com.nextlogic.apigateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/company")
    public ResponseEntity<String> companyFallback() {
        return ResponseEntity.ok("Company service temporarily unavailable");
    }

    @GetMapping("/fallback/job")
    public ResponseEntity<String> jobFallback() {
        return ResponseEntity.ok("Job service temporarily unavailable");
    }

    @GetMapping("/fallback/user")
    public ResponseEntity<String> userFallback() {
        return ResponseEntity.ok("User service temporarily unavailable");
    }

    @GetMapping("/fallback/scraper")
    public ResponseEntity<String> scraperFallback() {
        return ResponseEntity.ok("Scraper service temporarily unavailable");
    }
}

