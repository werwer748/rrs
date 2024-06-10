package com.hugo.review.api;

import com.hugo.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestEntityApi {

    private final TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.create(request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable Long id
    ) {
        testService.delete(id);
    }

    @PutMapping("/test/entity/{id}")
    public void putTestEntity(
            @PathVariable("id") Long id,
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.update(id, request.getName(), request.getAge());
    }

    @AllArgsConstructor
    @Getter
    public static class CreateTestEntityRequest {
        private final String name;
        private final Integer age;
    }
}
