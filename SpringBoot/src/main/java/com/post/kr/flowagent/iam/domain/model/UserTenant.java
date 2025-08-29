package com.post.kr.flowagent.iam.domain.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_tenants")
public class UserTenant {

    @EmbeddedId
    private UserTenantId id;


    // User 엔티티와의 다대일(N:1) 관계
    // @MapsId는 복합 키의 필드와 매핑합니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    // Tenant 엔티티와의 다대일(N:1) 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tenantId")
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

}
