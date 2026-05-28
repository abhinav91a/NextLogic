package com.nextlogic.alertservice.service;

import com.nextlogic.alertservice.domain.UserPreference;
import com.nextlogic.alertservice.kafka.ScrapedJobEvent;
import com.nextlogic.alertservice.repository.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlertMatchingService {

    private final UserPreferenceRepository preferenceRepo;
    private final AlertService alertService;

    public void match(ScrapedJobEvent job) {
        List<UserPreference> prefs = preferenceRepo.findAll();

        for (UserPreference pref : prefs) {
            if (matches(pref, job)) {
                alertService.createAlert(pref.getUserId(), job);
            }
        }
    }

    private boolean matches(UserPreference pref, ScrapedJobEvent job) {

        // Keyword match
        boolean keywordMatch = Arrays.stream(pref.getKeywords().split(","))
                .anyMatch(k -> job.getTitle().toLowerCase().contains(k.toLowerCase()));

        // Location match
        boolean locationMatch = Arrays.stream(pref.getLocations().split(","))
                .anyMatch(l -> job.getLocation().toLowerCase().contains(l.toLowerCase()));

        // Remote-only filter
        if (pref.isRemoteOnly() && !job.getLocation().toLowerCase().contains("remote")) {
            return false;
        }

        return keywordMatch && locationMatch;
    }
}
