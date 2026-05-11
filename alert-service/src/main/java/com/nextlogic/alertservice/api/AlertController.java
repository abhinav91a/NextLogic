package com.nextlogic.alertservice.api;

import com.nextlogic.alertservice.api.dto.AlertResponse;
import com.nextlogic.alertservice.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertResponse create(@RequestBody AlertResponse request) {
        return alertService.create(request);
    }

    @GetMapping
    public List<AlertResponse> getAll() {
        return alertService.findAll();
    }

    @GetMapping("/{id}")
    public AlertResponse getById(@PathVariable Long id) {
        return alertService.getById(id);
    }

    @PutMapping("/{id}")
    public AlertResponse update(@PathVariable Long id,
                              @RequestBody AlertResponse request) {
        return alertService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        alertService.delete(id);
    }
}
