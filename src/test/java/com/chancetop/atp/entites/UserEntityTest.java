package com.chancetop.atp.entites;

import com.chancetop.atp.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserEntityTest {
    UserRepository userRepository;
    @Autowired
    public UserEntityTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Test
    public void test(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Jackson");
        userEntity.setEmail("Jackson@email.com");
        userEntity.setStatus(0);
        userEntity.setPassword("password");
        userRepository.save(userEntity);
    }
}
