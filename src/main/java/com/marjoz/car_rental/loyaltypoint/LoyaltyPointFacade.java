package com.marjoz.car_rental.loyaltypoint;

import com.marjoz.car_rental.loyaltypoint.dto.LoyaltyPointDto;

class LoyaltyPointFacade {

    private final LoyaltyPointInMemoryRepository loyaltyPointInMemoryRepository;
    private final LoyaltyPointFactory loyaltyPointFactory;

    LoyaltyPointFacade(final LoyaltyPointInMemoryRepository loyaltyPointInMemoryRepository,
                       final LoyaltyPointFactory loyaltyPointFactory) {

        this.loyaltyPointInMemoryRepository = loyaltyPointInMemoryRepository;
        this.loyaltyPointFactory = loyaltyPointFactory;
    }

    void add(LoyaltyPointDto loyaltyPointDto) {
        var loyaltyPoint = loyaltyPointFactory.from(loyaltyPointDto);

        loyaltyPointInMemoryRepository.save(loyaltyPoint);
    }

    int getAvailablePoints(LoyaltyPointDto loyaltyPointDto) {
        var loyaltyPoint = loyaltyPointFactory.from(loyaltyPointDto);

        return loyaltyPointInMemoryRepository.getAvailablePoints(loyaltyPoint);
    }
}
