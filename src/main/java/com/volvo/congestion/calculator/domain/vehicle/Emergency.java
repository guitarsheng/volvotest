package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Emergency which is toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("5")
public class Emergency extends Vehicle {
    public Emergency() {
        this.type = VehicleType.Emergency;
    }
    @Override
    public boolean isTollFreeVehicle() {
        return true;
    }
}
