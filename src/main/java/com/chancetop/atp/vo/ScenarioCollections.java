package com.chancetop.atp.vo;

import com.chancetop.atp.entites.ScenarioEntity;
import com.chancetop.atp.entites.ScenarioFolderEntity;
import lombok.Data;

import java.util.List;

@Data
public class ScenarioCollections {
    private List<ScenarioFolderEntity> scenarioFolderEntities;
    private List<ScenarioEntity> scenarioEntities;
}
