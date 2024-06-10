package com.hugo.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    //Request Parameter 방식
    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam("name") String name, // /test/param?name=
            @RequestParam("age") Integer age ///test/param?name= &age=
    ) {
        return "Hello, Request Param, I am " + name + ", " + age;
    }

    // Path Variable 방식
    @GetMapping("/test/path/{name}/{age}") // /test/path/hugo/18
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ) {
        return "Hello, Path Variable, I am " + name + ", " + age;
    }

    // RequestBody 방식
    @PostMapping("/test/body")
    public String requestBody(
            @RequestBody TestRequestBody requestBody
    ) {
        return "Hello, Request Body I am " + requestBody.name + ", " + requestBody.age;
    }

    public static class TestRequestBody {
        String name;
        Integer age;

        // 생성자가 있어야 바디가 요청으로부터 올바르게 값을 받아 생성됨.
        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
