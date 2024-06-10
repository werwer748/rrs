package com.hugo.review.repository;

import com.hugo.review.model.TestEntity;

import java.util.List;

public interface TestRepositoryCustom {
    List<TestEntity> findAllByNameByQuerydsl(String name);
}
