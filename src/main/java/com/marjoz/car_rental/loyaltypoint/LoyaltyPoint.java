package com.marjoz.car_rental.loyaltypoint;

import lombok.*;

@Builder
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@EqualsAndHashCode
class LoyaltyPoint {

    private int userId;
    private int points;
}