package com.hugo.review.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLombokApi {

    @GetMapping("/test/lombok")
    public TestLombokResponseBody testLombok() {
        return new TestLombokResponseBody("zugo", 18);
    }


    // Lombok: 응답으로 생성될 JSON이 되기위해 필요한 getter와 생성자를 어노테이션으로 작성
    @Getter
    @AllArgsConstructor
    public static class TestLombokResponseBody {
        String name;
        Integer age;
    }
}
