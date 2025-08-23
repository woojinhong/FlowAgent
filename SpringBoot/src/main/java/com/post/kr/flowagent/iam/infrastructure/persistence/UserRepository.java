package com.post.kr.flowagent.iam.infrastructure.persistence;

import com.post.kr.flowagent.iam.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 사용자가 존재하는지 확인하는 메서드
    boolean existsByEmail(String email);

    // 이메일로 사용자를 찾는 메서드 (로그인 등에서 사용 가능)
    Optional<User> findByEmail(String email);
}