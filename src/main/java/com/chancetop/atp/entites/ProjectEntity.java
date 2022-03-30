package com.chancetop.atp.entites;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * CREATE TABLE IF NOT EXISTS `t_project`(
 *     `project_id` bigint auto_increment primary key comment '主键',
 *     `project_name` varchar(50) not null comment '项目名称',
 *     `project_owner` varchar(50) not null comment '项目owner',
 *     `project_desc` varchar(250) comment '项目描述',
 *     `created_time` datetime not null comment '创建时间',
 *     `updated_time` datetime not null comment '更新时间'
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 */

@Table(name = "t_project")
@Getter
@Setter
@Entity
public class ProjectEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "project_id",  length = 32)
    private String projectId;

    @Column(name = "project_name", columnDefinition = "VARCHAR(50) NOT NULL COMMENT '项目名称'", unique = true)
    @NotBlank(message = "project name can't be null! ")
    @NotEmpty(message = "project name can't be null! ")
    private String projectName;

    @Column(name = "project_owner", columnDefinition = "varchar(50) not null comment '项目owner'")
    @NotBlank(message = "project owner can't be null")
    @NotEmpty(message = "project owner can't be null! ")
    private String projectOwner;

    @Column(name = "project_desc", columnDefinition = "varchar(250) comment '项目描述'")
    private String projectDesc;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;



}
