package com.nextlogic.userservice.service;

import com.nextlogic.userservice.api.dto.UserResponse;
import com.nextlogic.userservice.domain.User;
import com.nextlogic.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse create(UserResponse request) {
        User user = User.builder()
                .companyId(request.getCompanyId())
                .title(request.getTitle())
                .location(request.getLocation())
                .url(request.getUrl())
                .build();
        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(this::toResponse)
                .collect(toList());
    }

    public UserResponse getById(Long id) {
        return userRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow();
    }

    public UserResponse update(Long id, UserResponse request) {
        User user = userRepository.findById(id).orElseThrow();
        user.setTitle(request.getTitle());
        user.setLocation(request.getLocation());
        user.setUrl(request.getUrl());
        User saved = userRepository.save(user);
        return toResponse(saved);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponse toResponse(User User) {
        return UserResponse.builder()
                .id(User.getId())
                .companyId(User.getCompanyId())
                .title(User.getTitle())
                .location(User.getLocation())
                .url(User.getUrl())
                .createdAt(User.getCreatedAt())
                .updatedAt(User.getUpdatedAt())
                .build();
    }
}
