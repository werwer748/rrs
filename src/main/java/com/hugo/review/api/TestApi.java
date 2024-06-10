package com.hugo.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {
    /*
    * 메소드만 바뀌고 url은 모두 동일
    */

    @GetMapping("/hello/world")
    public String helloWorld() {
        return "[Get] Hello world!!!";
    }

    @PostMapping("/hello/world")
    public String postHelloWorld() {
        return "[Post] Hello world!!!";
    }

    @PutMapping("/hello/world")
    public String putHelloWorld() {
        return "[Put] Hello world!!!";
    }

    @DeleteMapping("/hello/world")
    public String deleteHelloWorld() {
        return "[Delete] Hello world!!!";
    }
}
