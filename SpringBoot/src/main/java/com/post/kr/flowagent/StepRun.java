package com.post.kr.flowagent;

import jakarta.persistence.*;

@Entity
@Table(name = "step_runs")
public class StepRun {

    @Id
    @Column(name = "step_run_id") // 'srn_001' 같은 문자열이므로 GeneratedValue 사용 안 함
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_run_id", nullable = false)
    private WorkflowRun workflowRun;

    @Column(name = "step_name", length = 255)
    private String stepName;

    @Column(name = "step_status", length = 255)
    private String stepStatus;

    @Column(name = "step_inputs", columnDefinition = "json")
    private String inputs;

    @Column(name = "step_outputs", columnDefinition = "json")
    private String outputs;

    @Column(name = "duration_ms")
    private Integer durationMs;
}