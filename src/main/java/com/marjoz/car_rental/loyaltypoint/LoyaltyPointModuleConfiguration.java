package com.marjoz.car_rental.loyaltypoint;

class LoyaltyPointModuleConfiguration {

    LoyaltyPointFacade loyaltyPointFacade() {
        var loyaltyPointRepository = new LoyaltyPointInMemoryRepository();
        var loyaltyPointFactory = new LoyaltyPointFactory();

        return new LoyaltyPointFacade(loyaltyPointRepository, loyaltyPointFactory);
    }
}