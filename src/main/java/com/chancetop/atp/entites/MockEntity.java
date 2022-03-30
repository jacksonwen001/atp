package com.chancetop.atp.entites;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author jackson
 *  制造测试数据， 采用 mock Server 的方式来制造
 */
@Entity
@Getter
@Setter
@Table(name = "t_mock", uniqueConstraints = {
        @UniqueConstraint(name = "t_mock", columnNames = { "mock_name", "mock_path"}),
})
public class MockEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "mock_id", length = 32)
    private String mockId;

    @Column(name = "mock_name", columnDefinition = "varchar(50) not null comment 'mock name'")
    private String name;

    @Column(name = "mock_desc",columnDefinition = "varchar(250) comment 'mock desc'")
    private String desc;

    @Column(name = "mock_path", columnDefinition = "varchar(250) not null comment 'mock path'")
    private String urlPath;

    @Column(name = "mock_method", columnDefinition = "varchar(10) not null comment 'mock method'")
    private String method;

    @Column(name = "mock_headers", columnDefinition = "longtext comment 'mock headers'")
    private String headers;

    @Column(name = "mock_cookies", columnDefinition = "longtext comment 'mock cookies'")
    private String cookies;

    @Column(name = "mock_body", columnDefinition = "longtext comment 'mock body'")
    private String body;
}
