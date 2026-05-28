package com.nextlogic.alertservice.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_preferences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String keywords;     // "java,spring,backend"
    private String locations;    // "London,Remote"
    private boolean remoteOnly;
}
