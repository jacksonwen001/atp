package com.chancetop.atp.services.impl;

import cn.hutool.json.JSONUtil;
import com.chancetop.atp.entites.MockEntity;
import com.chancetop.atp.repositories.MockRepository;
import com.chancetop.atp.services.MockService;
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
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * 待完善
 */
@Service
public class MockServiceImpl implements MockService {
    private static Logger logger = LoggerFactory.getLogger(MockServiceImpl.class);
    @Autowired
    MockRepository mockRepository;
    @Override
    public void dynamicMock(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getServletPath().replaceAll("/mock", "");
        logger.info("path is : " + path);
        MockEntity mockEntity = new MockEntity();
        mockEntity.setUrlPath(path);
        Example<MockEntity> example = Example.of(mockEntity);
        MockEntity mockEntityOptional = mockRepository.findOne(example).get();

        try {
            OutputStream outputStream = response.getOutputStream();
            byte[] responseData = (JSONUtil.toJsonPrettyStr(mockEntityOptional.getBody()) + "Hello this is responses")
                    .getBytes(StandardCharsets.UTF_8);
            outputStream.write(responseData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
