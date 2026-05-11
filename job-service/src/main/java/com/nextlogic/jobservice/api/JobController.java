package com.nextlogic.jobservice.api;

import com.nextlogic.jobservice.api.dto.JobResponse;
import com.nextlogic.jobservice.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobResponse create(@RequestBody JobResponse request) {
        return jobService.create(request);
    }

    @GetMapping
    public List<JobResponse> getAll() {
        return jobService.findAll();
    }

    @GetMapping("/{id}")
    public JobResponse getById(@PathVariable Long id) {
        return jobService.getById(id);
    }

    @PutMapping("/{id}")
    public JobResponse update(@PathVariable Long id,
                              @RequestBody JobResponse request) {
        return jobService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        jobService.delete(id);
    }
}
