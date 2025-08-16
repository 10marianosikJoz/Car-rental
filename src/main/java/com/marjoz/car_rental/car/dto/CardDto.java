package com.marjoz.car_rental.car.dto;

import lombok.Builder;

@Builder
public record CardDto(int id,
                      String make,
                      String model,
                      int productionYear,
                      Category category) {}