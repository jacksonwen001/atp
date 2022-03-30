package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.ScenarioFolderRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScenarioFolderEntityTest {
    Logger logger  = LoggerFactory.getLogger(ScenarioFolderEntityTest.class);
    @Autowired
    ScenarioFolderRepository repository;

    /**
     * test insert folder
     */
    @Test void test(){
        ScenarioFolderEntity folderEntity = new ScenarioFolderEntity();
        folderEntity.setProjectId("4028b7a67fc06a64017fc06a7a930000");
        folderEntity.setName("test-folder");
        folderEntity.setParentId(0L);
        ScenarioFolderEntity folder = repository.insert(folderEntity);
        Long parentId = folder.getId();
        logger.info("now id is :" + parentId);
        ScenarioFolderEntity folderEntity2 = new ScenarioFolderEntity();
        folderEntity2.setParentId(parentId);
        folderEntity2.setName("test-folder-2");
        folderEntity2.setProjectId("4028b7a67fc06a64017fc06a7a930000");
        repository.insert(folderEntity2);
    }

}