package com.chancetop.atp.controllers;

import com.chancetop.atp.entites.ScenarioEntity;
import com.chancetop.atp.entites.ScenarioFolderEntity;
import com.chancetop.atp.services.ScenarioService;
import com.chancetop.atp.vo.ScenarioCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/v1/scenario")
public class ScenarioController {
    @Autowired
    ScenarioService scenarioService;

    @GetMapping("/collections")
    public ScenarioCollections getCollections(@Param(value = "id") Long id){
        return scenarioService.getAllScenarioFolder(id);
    }

    @PostMapping("/collections")
    public ScenarioFolderEntity addFolder(@RequestBody ScenarioFolderEntity scenarioFolderEntity){
        return scenarioService.addFolder(scenarioFolderEntity);
    }

    @PutMapping("/collections")
    public ScenarioFolderEntity updateFolder(@RequestBody ScenarioFolderEntity scenarioFolderEntity) {
        return scenarioService.updateFolder(scenarioFolderEntity);
    }

    @DeleteMapping("/collections")
    public ScenarioFolderEntity deleteFolder(@Param(value = "id") Long id) {
        return scenarioService.deleteFolder(id);
    }


}
