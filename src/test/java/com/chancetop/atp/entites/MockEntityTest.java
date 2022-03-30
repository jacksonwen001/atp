package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.MockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MockEntityTest {
    private MockRepository mockRepository;

    @Autowired
    public MockEntityTest(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    @Test
    public void test(){
        MockEntity mockEntity = new MockEntity();
        mockEntity.setName("测试-1");
        mockEntity.setDesc("测试用");
        mockEntity.setUrlPath("/test-1");
        mockEntity.setMethod("POST");
        mockEntity.setHeaders("{\"content-type\": \"application/json\"}");
        mockEntity.setBody("{\"name\": \"jackson\"}");
        mockRepository.save(mockEntity);
    }
}
