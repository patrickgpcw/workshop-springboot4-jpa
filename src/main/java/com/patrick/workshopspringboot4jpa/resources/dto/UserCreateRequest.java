package com.patrick.workshopspringboot4jpa.resources.dto;

public record UserCreateRequest(

        String name,
        String email,
        String phone,
        String password
) {}
