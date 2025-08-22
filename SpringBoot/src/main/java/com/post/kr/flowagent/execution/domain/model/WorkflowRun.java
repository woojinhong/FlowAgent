package com.post.kr.flowagent.execution.domain.model;

import com.post.kr.flowagent.workflow.domain.model.WorkflowVersion;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "workflow_runs")
public class WorkflowRun {

    @Id
    @Column(name = "workflow_runs_id") // 'run_id' 등 단순한 이름으로 변경하는 것을 추천
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_version_id", nullable = false)
    private WorkflowVersion workflowVersion;

    // Tenant 정보는 workflowVersion을 통해 접근 가능하므로 중복 매핑을 피하거나,
    // 조인 성능 최적화를 위해 읽기 전용으로 매핑할 수 있습니다.
    @Column(name = "tenant_id", insertable = false, updatable = false)
    private Long tenantId;

    @Column(name = "workflow_runs_status", length = 255)
    private String status;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}