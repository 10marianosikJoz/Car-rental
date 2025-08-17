package com.marjoz.car_rental.loyaltypoint

import com.marjoz.car_rental.loyaltypoint.dto.LoyaltyPointDto
import spock.lang.Specification

class LoyaltyPointSpecification extends Specification {

    private final LoyaltyPointFacade loyaltyPointFacade = new LoyaltyPointModuleConfiguration().loyaltyPointFacade()
    private final LoyaltyPointInMemoryRepository loyaltyPointInMemoryRepository = new LoyaltyPointInMemoryRepository()

    public static final LoyaltyPointDto loyaltyPointDto = LoyaltyPointDataProvider.provideLoyaltyPoint(1, 10)

    def setup() {
        loyaltyPointInMemoryRepository.clear()
    }

    def "should show available loyalty points for the user"() {
        given: 'loyalty points have been added for the user'
        loyaltyPointFacade.add(loyaltyPointDto)

        expect: 'system returns available user loyalty points'
        loyaltyPointFacade.getAvailablePoints(loyaltyPointDto) == 10
    }

    def "should add loyalty points for the user"() {
        given: 'loyalty points have been added for the user'
        loyaltyPointFacade.add(loyaltyPointDto)
        loyaltyPointFacade.add(loyaltyPointDto)

        expect: 'system returns available user loyalty points'
        loyaltyPointFacade.getAvailablePoints(loyaltyPointDto) == 20
    }
}