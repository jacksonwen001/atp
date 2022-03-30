package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_api_loop")
public class LoopEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "t_parent_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String parentId;

    @Column(name = "[status]", columnDefinition = "int default 0 comment '0-active, 1-inactive'")
    private Integer status = 0;

    @Column(name = "[times]", columnDefinition = "int default 0 comment 'loop times'")
    private Integer times;
}
