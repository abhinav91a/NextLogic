package com.nextlogic.jobservice.service;

import com.nextlogic.jobservice.domain.Job;
import com.nextlogic.jobservice.domain.Company;
import com.nextlogic.jobservice.repository.JobRepository;
import com.nextlogic.jobservice.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobWriteService {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public JobWriteService(JobRepository jobRepository,
                           CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional
    public Job saveJobWithCompany(Job job, Company company) {

        Company savedCompany = companyRepository
                .findByName(company.getName())
                .orElseGet(() -> companyRepository.save(company));

        job.setCompany(savedCompany);

        return jobRepository.save(job);
    }
}
