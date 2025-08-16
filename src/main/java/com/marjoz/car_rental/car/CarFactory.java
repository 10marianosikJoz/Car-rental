package com.marjoz.car_rental.car;

import com.marjoz.car_rental.car.dto.CardDto;

class CarFactory {

    Car from(CardDto cardDto) {
        return Car.builder()
                    .id(cardDto.id())
                    .make(cardDto.make())
                    .model(cardDto.model())
                    .productionYear(cardDto.productionYear())
                    .category(cardDto.category())
                    .build();
    }
}