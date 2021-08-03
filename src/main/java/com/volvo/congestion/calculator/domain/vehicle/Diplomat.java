package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Diplomat which is toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("4")
public class Diplomat extends Vehicle {
    public Diplomat() {
        this.type = VehicleType.Diplomat;
    }
    @Override
    public boolean isTollFreeVehicle() {
        return true;
    }
}
