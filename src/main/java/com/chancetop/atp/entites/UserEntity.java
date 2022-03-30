package com.chancetop.atp.entites;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "t_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "user_name", "email"}),
})
public class UserEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "user_id", length = 32, nullable = false)
    private String id;

    @Column(name = "user_name", columnDefinition = "VARCHAR(64) NOT NULL COMMENT 'user name'")
    private String username;

    @Column(name = "email", columnDefinition = "VARCHAR(64) NOT NULL COMMENT 'email'")
    private String email;

    @Column(name = "password", columnDefinition = "VARCHAR(256) COLLATE utf8mb4_bin DEFAULT NULL comment 'password'")
    private String password;

    @Column(name = "status", columnDefinition = "INT NOT NULL DEFAULT 0 COMMENT '0:inactive 1:active'")
    private Integer status;

    @Column(name = "created_time")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_time")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
