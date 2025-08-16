package com.marjoz.car_rental.car;

import com.marjoz.car_rental.car.dto.CardDto;
import com.marjoz.car_rental.car.dto.Category;

import java.util.List;

class CarFacade {

    private final CarInMemoryRepository carInMemoryRepository;
    private final CarFactory carFactory;

    CarFacade(final CarInMemoryRepository carInMemoryRepository,
              final CarFactory carFactory) {

        this.carInMemoryRepository = carInMemoryRepository;
        this.carFactory = carFactory;
    }

    void add(CardDto cardDto) {
        var car = carFactory.from(cardDto);

        carInMemoryRepository.save(car);
    }

    List<CardDto> getAvailableCars() {
        var availableCars = carInMemoryRepository.getAvailableCars();

        return availableCars.stream()
                .map(Car::cardDto)
                .toList();
    }

    CardDto show(String make, String model) {
        var availableCar = carInMemoryRepository.show(make, model);

        return availableCar.cardDto();
    }

    List<CardDto> getAvailableCarsFromCategory(Category category) {
        var availableCars = carInMemoryRepository.getAvailableCarsFromCategory(category);

        return availableCars.stream()
                .map(Car::cardDto)
                .toList();
    }

    void remove(CardDto cardDto) {
        var car = carFactory.from(cardDto);

        carInMemoryRepository.delete(car);
    }
}