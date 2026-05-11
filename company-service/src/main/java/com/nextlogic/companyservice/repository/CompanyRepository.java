package com.nextlogic.companyservice.repository;
import com.nextlogic.companyservice.domain.CareersPlatform;
import com.nextlogic.companyservice.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByNameIgnoreCase(String name);

    List<Company> findByPlatform(CareersPlatform platform);

    List<Company> findByLocationCityIgnoreCase(String city);

}
