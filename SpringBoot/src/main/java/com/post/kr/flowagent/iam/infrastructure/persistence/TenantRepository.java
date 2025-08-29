package com.post.kr.flowagent.iam.infrastructure.persistence;

import com.post.kr.flowagent.iam.domain.model.Tenant;
import com.post.kr.flowagent.iam.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
