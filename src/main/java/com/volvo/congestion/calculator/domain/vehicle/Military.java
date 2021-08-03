package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Military which is toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("7")
public class Military extends Vehicle {
    public Military() {
        this.type = VehicleType.Military;
    }
    @Override
    public boolean isTollFreeVehicle() {
        return true;
    }
}
