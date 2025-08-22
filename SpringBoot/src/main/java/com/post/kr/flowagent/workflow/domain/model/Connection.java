package com.post.kr.flowagent.workflow.domain.model;

import com.post.kr.flowagent.iam.domain.model.Tenant;
import jakarta.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {

    @Id
    @Column(name = "connection_id") // 'con_1' 같은 문자열이므로 GeneratedValue 사용 안 함
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(name = "service_name", length = 255)
    private String serviceName;

    @Column(name = "encrypted_credentials", length = 255)
    private String encryptedCredentials;

    @Column(name = "is_active", length = 1)
    private Boolean isActive;
}