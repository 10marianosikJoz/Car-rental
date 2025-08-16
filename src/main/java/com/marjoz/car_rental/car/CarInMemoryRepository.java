package com.marjoz.car_rental.car;

import com.marjoz.car_rental.car.dto.CarNotFoundException;
import com.marjoz.car_rental.car.dto.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class CarInMemoryRepository {

    private static final Map<Integer, Car> DATABASE = new ConcurrentHashMap<>();
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    void clear() {
        DATABASE.clear();
    }

    void save(Car car) {
        if (car.getId() == null) {
            car.setId(ID_GENERATOR.getAndIncrement());
        }
        DATABASE.put(car.getId(), car);
    }

    List<Car> getAvailableCars() {
        return new ArrayList<>(DATABASE.values());
    }

    Car show(String make, String model) {
        return DATABASE.values().stream()
                .filter(it -> it.getMake().equals(make) && it.getModel().equals(model))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("Car not found"));
    }

    List<Car> getAvailableCarsFromCategory(Category category) {
        return DATABASE.values().stream()
                .filter(it -> it.getCategory().equals(category))
                .toList();
    }

    void delete(Car car) {
        DATABASE.remove(car.getId());
    }
}