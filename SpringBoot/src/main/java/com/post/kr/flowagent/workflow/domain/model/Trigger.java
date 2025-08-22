package com.post.kr.flowagent.workflow.domain.model;

import com.post.kr.flowagent.iam.domain.model.Tenant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "triggers")
@Getter
@Setter
@NoArgsConstructor
public class Trigger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trigger_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_version_id", nullable = false)
    private WorkflowVersion workflowVersion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Enumerated(EnumType.STRING)
    @Column(name = "trigger_type", nullable = false, length = 50)
    private TriggerType triggerType;

    @Column(name = "trigger_config", columnDefinition = "json")
    private String triggerConfig;

    @Column(name = "is_active", nullable = false, length = 1)
    @ColumnDefault("'T'")
    private boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;
}