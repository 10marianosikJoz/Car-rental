package com.marjoz.car_rental

class AcceptanceSpecification extends IntegrationSpecification {

    def "positive car rental scenario"() {
        given: 'inventory has an economy car "Volkswagen Polo" and a premium car "Tesla Model S"'

        when: 'I go to /vehicles'
        then: 'I see both cars available'

        when: 'I go to /loyalty-points'
        then: 'I see I have no loyalty points'

        when: 'I post to /calculate with both cars for 3 days'
        then: 'I can see it will cost me 900 EURO for BMW X5 and 90 EURO for Toyota Corolla'

        when: 'I post to /rent with both cars for 3 days'
        then: 'I have rented both vehicles'

        when: 'I go to /rentals'
        then: 'I see both cars are currently rented'

        when: 'I go to /loyalty-points'
        then: 'I see I have 3 loyalty points'

        when: 'I post to /return with BMW X5'
        then: 'BMW X5 is returned successfully'

        when: 'I go to /rentals'
        then: 'I see only Toyota Corolla is still rented'
    }
}