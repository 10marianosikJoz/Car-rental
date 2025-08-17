package com.marjoz.car_rental.loyaltypoint.dto;

import lombok.Builder;

@Builder
public record LoyaltyPointDto(int userId, int points) {}
