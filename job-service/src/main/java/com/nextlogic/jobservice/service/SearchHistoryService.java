package com.nextlogic.jobservice.service;

import com.nextlogic.jobservice.mongo.SearchHistory;
import com.nextlogic.jobservice.mongo.SearchHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchHistoryService {

    private final SearchHistoryRepository repository;

    public SearchHistoryService(SearchHistoryRepository repository) {
        this.repository = repository;
    }

    public void saveSearch(String userId, String keyword) {
        SearchHistory history = new SearchHistory();
        history.setUserId(userId);
        history.setKeyword(keyword);
        history.setTimestamp(System.currentTimeMillis());
        repository.save(history);
    }
}
