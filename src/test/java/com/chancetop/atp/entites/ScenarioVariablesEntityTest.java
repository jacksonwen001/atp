package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.ScenarioRepository;
import com.chancetop.atp.repositories.ScenarioVariablesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScenarioVariablesEntityTest {
    @Autowired
    ScenarioVariablesRepository repository;

    @Test void test(){
        ScenarioVariablesEntity entity = new ScenarioVariablesEntity();
        entity.setProjectId("4028b7a67fc06a64017fc06a7a930000");
        entity.setScenarioId("4028b2d07fc4b818017fc4b8269d0000");
        entity.setScenarioFolderId(9L);
        entity.setName("timestamp");
        entity.setValue("23343123123123123");
        repository.insert(entity);
    }
}