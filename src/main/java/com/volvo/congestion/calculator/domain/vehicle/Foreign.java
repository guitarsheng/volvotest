package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Foreign which is toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("6")
public class Foreign extends Vehicle {
    public Foreign() {
        this.type = VehicleType.Foreign;
    }
    @Override
    public boolean isTollFreeVehicle() {
        return true;
    }
}
