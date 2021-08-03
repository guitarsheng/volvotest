package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Tractor which is not toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("9")
public class Tractor extends Vehicle {
    public Tractor() {
        this.type = VehicleType.Tractor;
    }
    @Override
    public boolean isTollFreeVehicle() {
        return false;
    }
}
