package com.post.kr.flowagent.workflow.domain.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

/**
 * 워크 플로우의 실제 로직을 담은 버전
 */
@Entity
@Table(name = "workflow_versions")
public class WorkflowVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workflow_version_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_id", nullable = false)
    private Workflow workflow;

    @Column(name = "version_number", length = 255)
    private Integer versionNumber;

    @Column(name = "dag_definition", columnDefinition = "json")
    private String dagDefinition;

    @Column(name = "is_published", length = 1)
    private Boolean isPublished;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
