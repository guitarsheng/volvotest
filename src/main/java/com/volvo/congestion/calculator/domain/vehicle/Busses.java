package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Busses which is toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("1")
public class Busses extends Vehicle {
    public Busses() {
        this.type = VehicleType.Busses;
    }

    @Override
    public boolean isTollFreeVehicle() {
        return true;
    }
}
