package com.andrey.jobportal.technicaltest.auth.model.dto;

import lombok.Data;

@Data
public class JwtResponseDto {
    private String token;
    private String type = "Bearer";

    public JwtResponseDto(String token) {
        this.token = token;
    }
}
