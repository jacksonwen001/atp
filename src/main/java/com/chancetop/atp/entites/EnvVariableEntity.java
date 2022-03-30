package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_env_variable")
public class EnvVariableEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "t_project_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String projectId;

    @Column(name = "t_env_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String envId;

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
