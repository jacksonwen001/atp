package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.ApiHeaderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiHeaderEntityTest {
    @Autowired
    ApiHeaderRepository apiHeaderRepository;

    @Test
    void test(){
        ApiHeaderEntity apiHeaderEntity = new ApiHeaderEntity();
        apiHeaderEntity.setProjectId("4028b7a67fc06a64017fc06a7a930000");
        apiHeaderEntity.setScenarioFolderId(9L);
        apiHeaderEntity.setScenarioId("4028b2d07fc4b818017fc4b8269d0000");
        apiHeaderEntity.setApiId("4028b2d07fc4eee0017fc4eeedb10000");
        apiHeaderEntity.setName("content-type");
        apiHeaderEntity.setValue("application/json");
        apiHeaderRepository.insert(apiHeaderEntity);
    }


}