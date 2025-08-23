package com.post.kr.flowagent.iam.application.dto;

public record UserResponse(
        Long userId,
        String email,
        String firstName,
        String lastName,
        Long tenantId
) {}