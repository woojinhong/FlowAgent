package com.post.kr.flowagent.iam.domain.model;


import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Embeddable
@NoArgsConstructor
@EqualsAndHashCode // equals와 hashCode를 반드시 구현해야 합니다.
public class UserTenantId implements Serializable {

    private Long userId;
    private Long tenantId;

    public UserTenantId(Long userId, Long tenantId) {
        this.userId = userId;
        this.tenantId = tenantId;
    }
}
