package com.hugo.review.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "test")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티에 생성자 작성피 빈 생성자가 필요함 - 아무렇게나 생성되는거 방지
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    public TestEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // 업데이트를 위한 메서드 생성
    public void changeNameAndAge(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
