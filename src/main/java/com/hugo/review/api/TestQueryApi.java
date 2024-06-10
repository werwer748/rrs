package com.hugo.review.api;

import com.hugo.review.model.TestEntity;
import com.hugo.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestQueryApi {

    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa() {
        return testService.findAllByNameJPA("hugo");
    }

    @GetMapping("/test/query/querydsl")
    public List<TestEntity> queryQuerydsl() {
        return testService.findAllByNameByQuerydsl("hugo");
    }
}
