package com.volvo.congestion.calculator.domain;

import com.volvo.congestion.calculator.domain.area.Area;
import com.volvo.congestion.calculator.domain.vehicle.Vehicle;

import java.util.Arrays;
import java.util.Date;

/**
 * an important class which responsible for define key logic of toll free calculation
 *
 * @author Guitar
 * @version 0.1
 */
public class CongestionTaxCalculator {

    /**
     * calculate toll fee in an area for a vehicle and timeline
     * Congestion tax is charged during fixed hours for vehicles driving into and out of Gothenburg.
     *
     * @param area      specify an area, for example a City
     * @param vehicle   specify a type of vehicle, for example a Car or a Motorbike
     * @param dates     a given list of timeline
     * @return   total fee calculated
     */
    public static int calculateTax(Area area, Vehicle vehicle, Date[] dates) {
        if (area == null || vehicle == null || dates.length == 0)
            return 0;
        if (vehicle.isTollFreeVehicle())
            return 0;
        sortDates(dates);
        int totalFee = area.getTaxRule().calculateFeeDuringDates(dates);//total mount

        if (totalFee > area.getMaximumAmountPerDay())
            totalFee = area.getMaximumAmountPerDay();
        return totalFee;
    }

    private static void sortDates(Date[] dates) {
        Arrays.sort(dates);
    }
}
