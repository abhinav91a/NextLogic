package com.nextlogic.alertservice.repository;

import com.nextlogic.alertservice.domain.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    List<UserPreference> findAll();
}
