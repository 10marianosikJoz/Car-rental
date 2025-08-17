package com.marjoz.car_rental.loyaltypoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class LoyaltyPointInMemoryRepository {

    private static final Map<Integer, LoyaltyPoint> DATABASE = new ConcurrentHashMap<>();

    void clear() {
        DATABASE.clear();
    }

    void save(LoyaltyPoint loyaltyPoint) {
        DATABASE.compute(loyaltyPoint.getUserId(), (userId, existing) -> {
            if (existing == null) return loyaltyPoint;
            existing.setPoints(existing.getPoints() + loyaltyPoint.getPoints());
            return existing;
        });
    }

    int getAvailablePoints(LoyaltyPoint loyaltyPoint) {
        return DATABASE.values().stream()
                .filter(it -> it.getUserId() == loyaltyPoint.getUserId())
                .map(LoyaltyPoint::getPoints)
                .reduce(0, Integer::sum);
    }

    boolean existsByUserId(int userId) {
        return DATABASE.values().stream()
                .anyMatch(it -> it.getUserId() == userId);
    }
}