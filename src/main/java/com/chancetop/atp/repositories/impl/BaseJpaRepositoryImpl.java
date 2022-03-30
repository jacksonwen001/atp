package com.chancetop.atp.repositories.impl;

import com.chancetop.atp.repositories.BaseJapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class BaseJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseJapRepository<T, ID> {
    private static Logger logger = LoggerFactory.getLogger(BaseJpaRepositoryImpl.class);

    private EntityManager entityManager;
    private JpaEntityInformation<T, ?> entityInformation;


    public BaseJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

    public BaseJpaRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <S extends T> List<S> addAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(item -> {
            entityManager.persist(item);
            result.add(item);
        });
        entityManager.flush();
        entityManager.clear();
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public <S extends T> List<S> updateAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(item -> {
            this.entityManager.merge(item);
            result.add(item);
        });
        entityManager.flush();
        entityManager.clear();
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <S extends T> S update(S entity) {
        entityManager.merge(entity);
        return entity;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <S extends T> S insert(S entity) {
        entityManager.persist(entity);
        return entity;
    }
}
