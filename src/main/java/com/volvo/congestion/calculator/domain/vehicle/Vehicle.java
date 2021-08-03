package com.volvo.congestion.calculator.domain.vehicle;

import javax.persistence.*;

/**
 * an abstract class for Vehicle for adding some common behavior
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "vehicle")
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.INTEGER, length = 1)
@DiscriminatorValue("0")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", unique = true)
    protected VehicleType type;
    /**
     * check if vehicle is toll free
     *
     * @return return true ,if vehicle is toll free
     */
    public abstract boolean isTollFreeVehicle();
}
