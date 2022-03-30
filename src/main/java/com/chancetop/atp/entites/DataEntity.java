package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "t_data", uniqueConstraints = {
        @UniqueConstraint(name = "t_data", columnNames = { "data_name", "data_path"}),
})
public class DataEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "data_id", length = 32)
    private String dataId;

    @Column(name = "user_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci NOT null comment '创建人'")
    @NotBlank(message = "Please set user!")
    @NotEmpty(message = "Please set user!")
    private String user;

    @Column(name = "t_scenario_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci comment '关联的场景'")
    @NotBlank(message = "Please set user!")
    @NotEmpty(message = "Please set user!")
    private String scenarioId;

    @Column(name = "data_name", columnDefinition = "varchar(50) not null comment 'name'")
    private String name;

    @Column(name = "data_desc", columnDefinition = "varchar(250) comment 'desc'")
    private String desc;

    @Column(name = "data_path", columnDefinition = "varchar(250) not null comment 'path'")
    private String path;

    @Column(name = "data_method", columnDefinition = "varchar(10) not null comment 'method'")
    private String method;

    @Column(name = "data_body", columnDefinition = "longtext comment '所有的可变参数都通过 data body 传入'")
    private String body;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
