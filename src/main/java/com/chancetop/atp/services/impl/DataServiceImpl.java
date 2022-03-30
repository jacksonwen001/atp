package com.chancetop.atp.services.impl;

import com.chancetop.atp.entites.DataEntity;
import com.chancetop.atp.entites.MockEntity;
import com.chancetop.atp.repositories.DataRepository;
import com.chancetop.atp.services.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

@Service
public class DataServiceImpl implements DataService {
    private static Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);
    @Autowired
    DataRepository dataRepository;

    @Override
    public void invoke(HttpServletResponse response) {
        try (OutputStream outputStream = response.getOutputStream()) {
            byte[] dataBytes = "".getBytes(StandardCharsets.UTF_8);
            outputStream.write(dataBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void makeData(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletPath().replaceAll("/mock", "");
        logger.info("path is : " + path);
        DataEntity entity = new DataEntity();
        entity.setPath(path);
        Example<DataEntity> example = Example.of(entity);
        DataEntity dataEntity = dataRepository.findOne(example).get();
        assertThat(dataEntity).withFailMessage("path not exists! please confiure first! ")
                .isNotNull();

        invoke(response);
    }
}
