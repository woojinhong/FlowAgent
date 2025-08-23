package com.post.kr.flowagent.iam.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//클라이언트로부터 회원가입 정보를 받아오는 역할을 하는 DTO(Data Transfer Object)
public record SignUpRequest(
        @NotBlank(message = "조직 이름은 필수입니다.")
        String tenantName,

        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "유효한 이메일 형식이 아닙니다.")
        String email,

        @NotBlank(message = "비밀번호는 필수입니다.")
        @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
        String password,

        @NotBlank(message = "이름은 필수입니다.")
        String firstName,

        @NotBlank(message = "성은 필수입니다.")
        String lastName
){}
