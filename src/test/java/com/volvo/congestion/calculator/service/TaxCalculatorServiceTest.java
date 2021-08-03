package com.volvo.congestion.calculator.service;

import com.volvo.congestion.VolvoTestApplication;
import com.volvo.congestion.calculator.domain.area.CityType;
import com.volvo.congestion.calculator.domain.vehicle.VehicleType;
import com.volvo.congestion.calculator.facade.dto.TaxCalculateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {VolvoTestApplication.class})
@WebAppConfiguration
public class TaxCalculatorServiceTest {

    @Autowired
    TaxCalculatorService taxCalculatorService;

    @Test
    public void calculatorCongestionTax() {
        String[] datesArr = loadTimeLine1();
        Date[] dates = TaxCalculateDTO.convertToDateArray(datesArr);
        assertEquals(60, taxCalculatorService.calculatorCongestionTax(
                CityType.Gothenburg, VehicleType.Car, dates
        ));
    }

    private String[] loadTimeLine1() {
        String[] datesArr = new String[]{
                "2013-01-14 21:00:00",
                "2013-01-15 21:00:00",
                "2013-02-07 06:23:27",
                "2013-02-07 15:27:00",
                "2013-02-08 06:27:00",
                "2013-02-08 06:20:27",
                "2013-02-08 14:35:00",
                "2013-02-08 15:29:00",
                "2013-02-08 15:47:00",
                "2013-02-08 16:01:00",
                "2013-02-08 16:48:00",
                "2013-02-08 17:49:00",
                "2013-02-08 18:29:00",
                "2013-02-08 18:35:00",
                "2013-03-26 14:25:00",
                "2013-03-28 14:07:27"
        };
        return datesArr;
    }
}