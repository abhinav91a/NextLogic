package com.nextlogic.scrapperservice.api;

import com.nextlogic.scrapperservice.api.dto.ScrapperResponse;
import com.nextlogic.scrapperservice.service.ScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scrappers")
@RequiredArgsConstructor
public class ScrapperController {

    private final ScrapperService scrapperService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScrapperResponse create(@RequestBody ScrapperResponse request) {
        return scrapperService.create(request);
    }

    @GetMapping
    public List<ScrapperResponse> getAll() {
        return scrapperService.findAll();
    }

    @GetMapping("/{id}")
    public ScrapperResponse getById(@PathVariable Long id) {
        return scrapperService.getById(id);
    }

    @PutMapping("/{id}")
    public ScrapperResponse update(@PathVariable Long id,
                                @RequestBody ScrapperResponse request) {
        return scrapperService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        scrapperService.delete(id);
    }
}
