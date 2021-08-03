package com.volvo.congestion.calculator.domain;

import com.volvo.congestion.VolvoTestApplication;
import com.volvo.congestion.calculator.domain.area.*;
import com.volvo.congestion.calculator.domain.vehicle.*;
import com.volvo.congestion.calculator.facade.dto.TaxCalculateDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {VolvoTestApplication.class})
public class CongestionTaxCalculatorTest {

    @Test
    public void testCalculateTax4TaxExemptVehicles() {
        //Looking around your colleagues desk, you find a list of dates scribbled on a post-it.
        // Maybe they’ll come in handy.
        String[] datesArr = loadTimeLine1();
        Date[] dates = TaxCalculateDTO.convertToDateArray(datesArr);
        Area gothenburg = new Gothenburg();

        assertEquals(0, CongestionTaxCalculator.calculateTax(gothenburg, new Emergency(), dates));
        assertEquals(0, CongestionTaxCalculator.calculateTax(gothenburg, new Busses(), dates));
        assertEquals(0, CongestionTaxCalculator.calculateTax(gothenburg, new Diplomat(), dates));
        assertEquals(0, CongestionTaxCalculator.calculateTax(gothenburg, new Motorbike(), dates));
        assertEquals(0, CongestionTaxCalculator.calculateTax(gothenburg, new Military(), dates));
        assertEquals(0, CongestionTaxCalculator.calculateTax(gothenburg, new Foreign(), dates));
    }

    @Test
    public void testCalculateTax4SingleChargeRule() {
        //Looking around your colleagues desk, you find a list of dates scribbled on a post-it.
        // Maybe they’ll come in handy.
        String[] datesArr = loadTimeLine4SingleChargeRule();
        Date[] dates = TaxCalculateDTO.convertToDateArray(datesArr);
        Area gothenburg = new Gothenburg();
        assertEquals(42, CongestionTaxCalculator.calculateTax(gothenburg, new Car(), dates));
        assertEquals(42, CongestionTaxCalculator.calculateTax(gothenburg, new Tractor(), dates));
    }

    @Autowired
    TaxRuleTableRepository taxRuleTableRepository;

    @Test
    public void testCalculateTax4Extension() {
        //Looking around your colleagues desk, you find a list of dates scribbled on a post-it.
        // Maybe they’ll come in handy.
        String[] datesArr = loadTimeLine1();
        Date[] dates = TaxCalculateDTO.convertToDateArray(datesArr);
        AnotherCity demoCity = new AnotherCity();
        demoCity.setRepository(taxRuleTableRepository);
        assertEquals(250, CongestionTaxCalculator.calculateTax(demoCity, new Car(), dates));
        assertEquals(250, CongestionTaxCalculator.calculateTax(demoCity, new Tractor(), dates));
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

    private String[] loadTimeLine4SingleChargeRule() {
        String[] datesArr = new String[]{
                "2013-01-15 06:00:00",  //8

                "2013-01-16 06:01:00",  //13
                "2013-01-16 06:12:00",
                "2013-01-16 06:15:00",
                "2013-01-16 06:19:00",
                "2013-01-16 06:20:00",
                "2013-01-16 06:39:00",

                "2013-01-16 08:20:00",   //13
                "2013-01-16 08:50:00",
                "2013-01-16 08:59:00",

                "2013-01-17 06:23:27",   //8
        };
        return datesArr;
    }
}