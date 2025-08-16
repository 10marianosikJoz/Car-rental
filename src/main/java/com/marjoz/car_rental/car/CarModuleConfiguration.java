package com.marjoz.car_rental.car;

class CarModuleConfiguration {

    CarFacade carFacade() {
        var carInMemoryRepository = new CarInMemoryRepository();
        var carFactory = new CarFactory();

        return new CarFacade(carInMemoryRepository, carFactory);
    }
}