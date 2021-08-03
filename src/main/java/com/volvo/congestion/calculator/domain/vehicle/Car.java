package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * an concrete type of vehicle called Car which is not toll free
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("2")
public class Car extends Vehicle {
    public Car() {
        this.type = VehicleType.Car;
    }
    @Override
    public boolean isTollFreeVehicle() {
        return false;
    }
}
