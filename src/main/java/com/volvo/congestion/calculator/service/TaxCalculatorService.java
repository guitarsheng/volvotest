package com.volvo.congestion.calculator.service;

import com.volvo.congestion.calculator.domain.area.CityType;
import com.volvo.congestion.calculator.domain.vehicle.VehicleType;

import java.util.Date;

/**
 * a service responsible for tax calculation
 *
 * @author Guitar
 * @version 0.1
 */
public interface TaxCalculatorService {
    /**
     * service entry for calculate congestion tax for a given city and vehicle during time period provided
     *
     * @param cityType     type of city
     * @param vehicleType  type of vehicle
     * @param dates        array of time period list
     * @return
     */
    int calculatorCongestionTax(CityType cityType, VehicleType vehicleType, Date[] dates);
}
