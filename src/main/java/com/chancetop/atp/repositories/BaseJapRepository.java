package com.chancetop.atp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@NoRepositoryBean
public interface BaseJapRepository<T,ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    <S extends T> List<S> addAll(Iterable<S> entities);
    <S extends T> List<S> updateAll(Iterable<S> entities);
    <S extends T> S update(S entity);
    <S extends T> S insert(S entity);
}
