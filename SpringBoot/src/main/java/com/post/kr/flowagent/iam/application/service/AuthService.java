package com.post.kr.flowagent.iam.application.service;


import com.post.kr.flowagent.iam.application.dto.SignUpRequest;
import com.post.kr.flowagent.iam.domain.model.Tenant;
import com.post.kr.flowagent.iam.infrastructure.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
//    private final TenantRepository tenantRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(SignUpRequest request) {
        // 1. 이메일 중복 확인
        if (userRepository.existsByEmailAddr(request.email())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 2. Tenant 조회 또는 생성 (✨ 여기가 핵심 ✨)
        String tenantName = request.tenantName();
        Tenant tenant = tenantRepository.findByName(tenantName)
                .orElseGet(() -> {
                    Tenant newTenant = Tenant.builder().name(tenantName).build(); // Tenant 빌더 사용 가정
                    return tenantRepository.save(newTenant);
                });

        // 3. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.password());

        // 4. DTO를 User 엔티티로 변환하여 저장
        User newUser = User.builder()
                .tenant(tenant) // 조회되거나 새로 생성된 Tenant 객체를 전달
                .password(encodedPassword)
                .firstName(request.firstName())
                .lastName(request.lastName())
                .emailAddr(request.email())
                .accountStatus("ACTIVE")
                .build();

        // 5. 데이터베이스에 사용자 정보 저장
        userRepository.save(newUser);
    }
}