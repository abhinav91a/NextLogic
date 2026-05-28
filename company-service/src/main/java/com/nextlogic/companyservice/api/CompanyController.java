package com.nextlogic.companyservice.api;
import com.nextlogic.companyservice.api.dto.CompanyResponse;
import com.nextlogic.companyservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyResponse create(@RequestBody CompanyResponse request) {
        return companyService.create(request);
    }

    @GetMapping
    public List<CompanyResponse> getAll() {
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public CompanyResponse getById(@PathVariable Long id) {
        return companyService.getById(id);
    }

    @PutMapping("/{id}")
    public CompanyResponse update(@PathVariable Long id,
                                  @RequestBody CompanyResponse request) {
        return companyService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        companyService.delete(id);
    }
}
