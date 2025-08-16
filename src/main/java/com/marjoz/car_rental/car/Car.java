package com.marjoz.car_rental.car;

import com.marjoz.car_rental.car.dto.CardDto;
import com.marjoz.car_rental.car.dto.Category;
import lombok.*;

@Builder
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@EqualsAndHashCode
class Car {

    private Integer id;
    private String make;
    private String model;
    private Integer productionYear;
    private Category category;

    CardDto cardDto() {
        return CardDto.builder()
                .id(id)
                .make(make)
                .model(model)
                .productionYear(productionYear)
                .category(category)
                .build();
    }
}