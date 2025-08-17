package com.marjoz.car_rental.loyaltypoint;

import com.marjoz.car_rental.loyaltypoint.dto.LoyaltyPointDto;

class LoyaltyPointFactory {

    LoyaltyPoint from(LoyaltyPointDto loyaltyPointDto) {
        return LoyaltyPoint.builder()
                    .userId(loyaltyPointDto.userId())
                    .points(loyaltyPointDto.points())
                    .build();
    }
}