package com.patrick.workshopspringboot4jpa.resources.mapper;

import com.patrick.workshopspringboot4jpa.entities.User;
import com.patrick.workshopspringboot4jpa.resources.dto.UserCreateRequest;
import com.patrick.workshopspringboot4jpa.resources.dto.UserResponse;
import com.patrick.workshopspringboot4jpa.resources.dto.UserUpdateRequest;

public class UserMapper {

    private UserMapper() {
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public static User toEntity(UserCreateRequest request) {
        return new User(
                null,
                request.name(),
                request.email(),
                request.phone(),
                request.password()
        );
    }

    public static void updateEntity(UserUpdateRequest request, User user) {
        if (request.name() != null) {
            user.setName(request.name());
        }
        if (request.email() != null) {
            user.setEmail(request.email());
        }
        if (request.phone() != null) {
            user.setPhone(request.phone());
        }

    }
}
