package com.marjoz.car_rental.car

import com.marjoz.car_rental.car.dto.CardDto
import com.marjoz.car_rental.car.dto.Category

class CarDataProvider {

    static CardDto provideCar(int id,
                              String make,
                              String model,
                              int productionYear,
                              Category category) {

        return new CardDto(id, make, model, productionYear, category)
    }
}