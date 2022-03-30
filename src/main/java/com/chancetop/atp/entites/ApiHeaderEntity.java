package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_api_header")
public class ApiHeaderEntity {
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

    @Column(name = "t_api_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String apiId;

    @Column(name = "[status]", columnDefinition = "int default 0 comment '0-active, 1-inactive'")
    private Integer status = 0;

    @Column(name = "[name]",columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'header 头'")
    private String name;
    @Column(name = "[value]", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci NOT null primary key comment 'header 值'")
    private String value;
}
