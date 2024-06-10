package com.hugo.review.api;

import com.hugo.review.api.request.CreateAndEditRestaurantRequest;
import com.hugo.review.model.RestaurantEntity;
import com.hugo.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestaurantApi {

    private final RestaurantService restaurantService;

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
    public void createRestaurant(
            @RequestBody CreateAndEditRestaurantRequest request
            ) {
        restaurantService.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(
            @PathVariable Long restaurantId,
            @RequestBody CreateAndEditRestaurantRequest request
    ) {
        restaurantService.editRestaurant(restaurantId, request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(
            @PathVariable Long restaurantId
    ) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}
