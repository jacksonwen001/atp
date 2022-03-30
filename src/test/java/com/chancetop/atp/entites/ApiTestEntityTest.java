package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.ApiTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ApiTestEntityTest {
    @Autowired
    ApiTestRepository apiTestRepository;

    @Test void test(){
        ApiTestEntity apiTestEntity = new ApiTestEntity();
        apiTestEntity.setProjectId("4028b7a67fc06a64017fc06a7a930000");
        apiTestEntity.setUserId("user-1");
        apiTestEntity.setScenarioFolderId(9L);
        apiTestEntity.setScenarioId("4028b2d07fc4b818017fc4b8269d0000");
        apiTestEntity.setName("api-test-1");
        apiTestEntity.setDesc("api testing");
        apiTestEntity.setUrl("https://httpbin.org/post");
        apiTestEntity.setMethod("POST");
        apiTestEntity.setBody("{\"name\": \"jackson\"}");
        apiTestRepository.save(apiTestEntity);
    }

}