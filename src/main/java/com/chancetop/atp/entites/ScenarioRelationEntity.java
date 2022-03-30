package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_scenario_relation")
public class ScenarioRelationEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "t_project_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String projectId;

    @Column(name = "t_scenario_folder_id", columnDefinition = "bigint(11) COLLATE utf8mb4_general_ci not null comment 'project'")
    private Long scenarioFolderId;

    @Column(name = "main_scenario", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String mainScenario;

    @Column(name = "sub_scenario", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String subScenario;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
