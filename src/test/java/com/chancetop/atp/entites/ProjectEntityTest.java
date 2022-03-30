package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProjectEntityTest {
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectEntityTest(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    /**
     * 新增一个项目
     */
    @Test
    public void testSave(){
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("test-project");
        projectEntity.setProjectOwner("jackson");
        projectEntity.setProjectDesc("this is test project");
        projectRepository.insert(projectEntity);
    }

    /**
     * 测试批量添加
     */
    @Test
    public void testAddAll(){
        List<ProjectEntity> projectEntities = new ArrayList<>();
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("test-project");
        projectEntity.setProjectOwner("jackson");
        projectEntity.setProjectDesc("this is test project");

        ProjectEntity projectEntity2 = new ProjectEntity();
        projectEntity2.setProjectName("test-project-2");
        projectEntity2.setProjectOwner("jackson2");
        projectEntity2.setProjectDesc("this is test project2");
        projectEntities.add(projectEntity);
        projectEntities.add(projectEntity2);
        projectRepository.addAll(projectEntities);

    }
    
    @Test
    public void testUpdateAll(){
        List<ProjectEntity> projectEntities = projectRepository.findAll();
        int i = 0;
        for (ProjectEntity projectEntity : projectEntities) {
            projectEntity.setProjectName("aaaaa" + i);
            i++;
        }
        projectRepository.updateAll(projectEntities);
    }
}
