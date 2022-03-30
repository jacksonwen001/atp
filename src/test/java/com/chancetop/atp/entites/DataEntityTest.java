package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.DataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;

@SpringBootTest
public class DataEntityTest {
    @Autowired
    DataRepository dataRepository;

    @Test
    public void test(){
        DataEntity dataEntity = new DataEntity();
        dataEntity.setName("Test-1");
        dataEntity.setPath("/test-1");
        dataEntity.setUser("user1");
        dataEntity.setMethod("post");
        dataEntity.setBody("{\"name\": \"Jackson\"}");
        dataRepository.insert(dataEntity);
    }

}
