package com.hugo.review.repository;

import com.hugo.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {

    // JPA를 이용한 검색
    List<TestEntity> findAllByName(String name);
}
