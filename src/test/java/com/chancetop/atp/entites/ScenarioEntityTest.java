package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.ScenarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScenarioEntityTest {
    @Autowired
    ScenarioRepository scenarioRepository;

    @Test
    void test(){
        ScenarioEntity entity = new ScenarioEntity();
        entity.setProjectId("4028b7a67fc06a64017fc06a7a930000");
        entity.setUserId("user-1");
        entity.setScenarioFolderId(9L);
        entity.setScenarioName("test-scenario");
        entity.setScenarioDesc("test");
        entity.setStatus(1);
        scenarioRepository.insert(entity);
    }

    @Test void test2(){
        ScenarioEntity entity = new ScenarioEntity();
        entity.setProjectId("4028b7a67fc06a64017fc06a7a930000");
        entity.setUserId("user-1");
        entity.setScenarioFolderId(9L);
        entity.setScenarioName("test-scenario-sub");
        entity.setStatus(1);
        scenarioRepository.insert(entity);
    }
}