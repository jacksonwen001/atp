package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_scenario_variables")
public class ScenarioVariablesEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "t_project_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String projectId;

    @Column(name = "t_scenario_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String scenarioId;

    @Column(name = "t_scenario_folder_id", columnDefinition = "bigint(11) COLLATE utf8mb4_general_ci not null comment 'project'")
    private Long scenarioFolderId;

    @Column(name = "[name]", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci NOT NULL comment 'key'")
    private String name;

    @Column(name = "[value]", columnDefinition = "varchar(128) COLLATE utf8mb4_general_ci NOT NULL comment 'value'")
    private String value;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
