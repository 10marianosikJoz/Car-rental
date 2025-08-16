package com.marjoz.car_rental.car

import com.marjoz.car_rental.car.dto.CarNotFoundException
import com.marjoz.car_rental.car.dto.CardDto
import com.marjoz.car_rental.car.dto.Category
import spock.lang.Specification

class CarSpecification extends Specification {

    private final CarFacade carFacade = new CarModuleConfiguration().carFacade()
    private final CarInMemoryRepository carInMemoryRepository = new CarInMemoryRepository()
    private final CardDto tesla = CarDataProvider.provideCar(1,"Tesla","Tesla Model S", 2025, Category.PREMIUM)
    private final CardDto bmw = CarDataProvider.provideCar(2, "BMW", "BMW X5", 2020, Category.STANDARD)

    def setup() {
        carInMemoryRepository.clear()
    }

    def "should show available cars in the system"() {
        given: 'cars are in the system'
          carFacade.add(tesla)
          carFacade.add(bmw)

        expect: 'system returns available cars'
          carFacade.getAvailableCars() == [tesla, bmw]
    }

    def "should throw exception when car is not available in the system"() {
        when: "system is asked for a car that is not present"
        carFacade.show("some car we don't have", "some model we don't have")

        then:
        thrown(CarNotFoundException)
    }

    def "should show cars from PREMIUM category"() {
        given: 'cars are in the system'
        carFacade.add(tesla)
        carFacade.add(bmw)

        expect: 'system returns cars from the PREMIUM category'
        carFacade.getAvailableCarsFromCategory(Category.PREMIUM) == [tesla]
    }

    def "should remove car from available cars in the system"() {
        given: 'cars are in the system'
        carFacade.add(tesla)
        carFacade.add(bmw)

        when: 'Tesla car is removed'
        carFacade.remove(tesla)

        then: 'system returns only BMW car'
        carFacade.getAvailableCars() == [bmw]
    }
}