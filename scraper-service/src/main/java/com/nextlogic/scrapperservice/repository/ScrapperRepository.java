package com.nextlogic.scrapperservice.repository;
import com.nextlogic.scrapperservice.domain.Scrapper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapperRepository extends JpaRepository<Scrapper, Long> {
}

