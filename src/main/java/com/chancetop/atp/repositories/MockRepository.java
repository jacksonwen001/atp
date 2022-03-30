package com.chancetop.atp.repositories;

import com.chancetop.atp.entites.MockEntity;
import com.chancetop.atp.repositories.impl.BaseJpaRepositoryImpl;
import org.springframework.stereotype.Repository;

public interface MockRepository extends BaseJapRepository<MockEntity, String> {
}
