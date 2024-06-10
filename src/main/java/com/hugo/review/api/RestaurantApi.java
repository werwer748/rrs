package com.hugo.review.api;

import com.hugo.review.api.request.CreateAndEditRestaurantRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantApi {

    @GetMapping("/restaurants")
    public String getRestaurants() {
        return "This is a getRestaurants";
    }

    @GetMapping("/restaurant/{restaurantId}")
    public String getRestaurantById(
            @PathVariable("restaurantId") Long restaurantId
    ) {
        return "This is a getRestaurantById:: " + restaurantId;
    }

    @PostMapping("/restaurant")
    public String createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ) {
        return "This is a createRestaurant, name: " + request.getName() + ", address: " + request.getAddress()
//                + "menu[0].name: " + (request.getMenus().isEmpty() || ? "없음" : request.getMenus().get(0).getName());
                + "menu[0].name: " + (request.getMenus());
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        return "This is a editRestaurant:: " + restaurantId + ", name: " + request.getName() + ", address: " + request.getAddress();
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(
            @PathVariable Long restaurantId
    ) {
        return "This is a deleteRestaurant:: " + restaurantId;
    }
}
