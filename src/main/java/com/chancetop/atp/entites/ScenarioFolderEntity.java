package com.chancetop.atp.entites;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_scenario_folder")
public class ScenarioFolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "t_project_id", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci not null comment 'project'")
    private String projectId;

    @Column(name = "name", columnDefinition = "varchar(32) COLLATE utf8mb4_general_ci NOT NULL comment '名字'")
    private String name;

    @Column(name = "parent_id", columnDefinition = "bigint(11) default 0")
    private Long parentId;

    @Column(name = "tree_path", columnDefinition = "varchar(255) comment ''")
    private String treePath;
}
