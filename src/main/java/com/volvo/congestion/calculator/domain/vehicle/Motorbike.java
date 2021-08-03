package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Motorbike which is toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("8")
public class Motorbike extends Vehicle {
    public Motorbike() {
        this.type = VehicleType.Motorbike;
    }
    @Override
    public boolean isTollFreeVehicle() {
        return true;
    }
}
