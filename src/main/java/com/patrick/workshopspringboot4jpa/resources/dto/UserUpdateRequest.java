package com.patrick.workshopspringboot4jpa.resources.dto;

public record UserUpdateRequest(
        String name,
        String email,
        String phone
) {
}
