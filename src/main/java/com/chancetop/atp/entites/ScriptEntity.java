package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_api_condition")
public class ScriptEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "t_parent_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String parentId;

    @Column(name = "[type]", columnDefinition = "int not null comment '0-if, 1-while'")
    private Integer type;

    @Column(name = "[status]", columnDefinition = "int default 0 comment '0-active, 1-inactive'")
    private Integer status = 0;

    @Column(name = "script", columnDefinition = "varchar(250) not null comment 'script'")
    private String script;
}
