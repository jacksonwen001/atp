package com.chancetop.atp.entites;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.boot.model.source.spi.IdentifierSource;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_api_test")
public class ApiTestEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "t_project_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String projectId;

    @Column(name = "t_parent_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String parentId;

    @Column(name = "[status]", columnDefinition = "int default 0 comment '0-active, 1-inactive'")
    private Integer status = 0 ;

    @Column(name = "t_scenario_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String scenarioId;

    @Column(name = "user_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String userId;

    @Column(name = "t_scenario_folder_id", columnDefinition = "bigint(11) COLLATE utf8mb4_general_ci not null comment 'project'")
    private Long scenarioFolderId;

    @Column(name = "api_name", columnDefinition = "varchar(50) not null comment 'name'")
    private String name;

    @Column(name = "api_desc", columnDefinition = "varchar(250) comment 'desc'")
    private String desc;

    @Column(name = "api_url", columnDefinition = "varchar(250) not null comment 'path'")
    private String url;

    @Column(name = "api_method", columnDefinition = "varchar(10) not null comment 'method'")
    private String method;

    @Column(name = "api_body", columnDefinition = "longtext comment '所有的可变参数都通过 data body 传入'")
    private String body;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
