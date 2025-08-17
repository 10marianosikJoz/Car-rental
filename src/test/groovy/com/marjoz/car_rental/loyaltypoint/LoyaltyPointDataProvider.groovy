package com.marjoz.car_rental.loyaltypoint

import com.marjoz.car_rental.loyaltypoint.dto.LoyaltyPointDto

class LoyaltyPointDataProvider {

    static LoyaltyPointDto provideLoyaltyPoint(int userId, int points) {

        return LoyaltyPointDto.builder()
                .userId(userId)
                .points(points)
                .build();
    }
}