package com.volvo.congestion.calculator.facade.dto;

import com.volvo.congestion.calculator.domain.area.CityType;
import com.volvo.congestion.calculator.domain.vehicle.VehicleType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Slf4j
public class TaxCalculateDTO implements Serializable {
    CityType city;
    VehicleType vehicle;
    String[] timeline;

    public static Date[] convertToDateArray(String[] datesArr) {
        Date[] dates = new Date[datesArr.length];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < dates.length; i++) {
            try {
                dates[i] = simpleDateFormat.parse(datesArr[i]);
            } catch (ParseException e) {
                log.error("convertToDateArray simpleDateFormat error {}",e);
            }
        }
        return dates;
    }

    public CityType getCity() {
        return city;
    }

    public void setCity(CityType city) {
        this.city = city;
    }

    public VehicleType getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleType vehicle) {
        this.vehicle = vehicle;
    }

    public String[] getTimeline() {
        return timeline;
    }

    public void setTimeline(String[] timeline) {
        this.timeline = timeline;
    }
}
