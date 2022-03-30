package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_scenario",  uniqueConstraints = {
        @UniqueConstraint(name = "t_scenario", columnNames = { "scenario_name"}),
})
public class ScenarioEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "scenario_id", length = 32)
    private String scenarioId;

    @Column(name = "t_project_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String projectId;

    @Column(name = "t_data_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String dataId;

    @Column(name = "user_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String userId;

    @Column(name = "t_env_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String envId;

    @Column(name = "t_scenario_folder_id", columnDefinition = "bigint(11) COLLATE utf8mb4_general_ci not null comment 'project'")
    private Long scenarioFolderId;

    @Column(name = "t_scenario_var_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String scenarioVarId;

    @Column(name = "scenario_name", columnDefinition = "varchar(64) COLLATE utf8mb4_general_ci not null comment 'scenario name'")
    private String scenarioName;

    @Column(name = "scenario_desc", columnDefinition = "varchar(250) COLLATE utf8mb4_general_ci comment 'description'")
    private String scenarioDesc;

    @Column(name = "scenario_status", columnDefinition = "int default 0 comment '0-active 1-inactive'")
    private Integer status=0;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
