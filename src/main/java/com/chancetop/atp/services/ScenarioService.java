package com.chancetop.atp.services;

import com.chancetop.atp.entites.ApiHeaderEntity;
import com.chancetop.atp.entites.ApiTestEntity;
import com.chancetop.atp.entites.ScenarioEntity;
import com.chancetop.atp.entites.ScenarioFolderEntity;
import com.chancetop.atp.vo.ScenarioCollections;

import java.util.List;

public interface ScenarioService {
    ScenarioCollections getAllScenarioFolder(Long id);
    ScenarioFolderEntity updateFolder(ScenarioFolderEntity scenarioFolderEntity);
    ScenarioFolderEntity addFolder(ScenarioFolderEntity scenarioFolderEntity);
    ScenarioFolderEntity deleteFolder(Long id);

    List<ScenarioEntity> getAllScenario(Long folderId);
    ScenarioEntity getScenario(String scenarioId);
    ScenarioEntity updateScenario(ScenarioEntity scenarioEntity);
    ScenarioEntity addScenario(ScenarioEntity scenarioEntity);

    List<ApiTestEntity> getAllApiTest(String scenarioId);
    ApiTestEntity getApiTestEntity(String apiId);
    ApiTestEntity updateApiTestEntity(ApiTestEntity apiTestEntity);
    ApiTestEntity addApiTestEntity(ApiTestEntity apiTestEntity);
    ApiTestEntity deleteApiTestEntity(String apiId);

    ApiHeaderEntity getApiHeaderEntity(String apiId);
    ApiHeaderEntity updateAPiHeaderEntity(ApiHeaderEntity headerEntity);
    ApiTestEntity addApiHeader(ApiHeaderEntity headerEntity);
    ApiHeaderEntity deleteHeader(String headerId);
}
