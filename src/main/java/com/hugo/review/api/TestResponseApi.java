package com.hugo.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApi {

    @GetMapping("/test/response/string")
    public String stringResponse() {
        return "This is String";
    }

    @GetMapping("test/response/json")
    // public String jsonResponse() { // 응답 헤더 Content-Type : text/plain;charset=UTF-8 => application/json 으로 바꿔야 함
    public TestResponseBody jsonResponse() { // Content-Type : application/json
        return new TestResponseBody("hugo", 40);
    }

    // 응답에 실리는 Dto는 생성자(필수)와 겟터(대부분)로 구성
    public static class TestResponseBody {
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
