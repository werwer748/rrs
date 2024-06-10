package com.hugo.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter // 필드값들 private으로 선언됐는데 getter없으면 entity의 값을 못가져나옴..
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private ZonedDateTime createdAt; // LocalDateTime 이나 ZonedDateTime 사용
    private ZonedDateTime updatedAt;

    public void changeNameAndAddress(String name, String address) {
        this.name = name;
        this.address = address;
        this.updatedAt = ZonedDateTime.now();
    }
}
