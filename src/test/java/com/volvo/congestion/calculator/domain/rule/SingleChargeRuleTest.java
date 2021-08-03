package com.volvo.congestion.calculator.domain.rule;

import com.volvo.congestion.calculator.domain.area.Gothenburg;
import com.volvo.congestion.calculator.facade.dto.TaxCalculateDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleChargeRuleTest {

    @Test
    public void calculateFeeDuringDates() {
        assertEquals(60, new SingleChargeRule(new Gothenburg())
                .calculateFeeDuringDates(
                        TaxCalculateDTO.convertToDateArray(loadTimeLine4SingleChargeRule())
                ));
    }

    private String[] loadTimeLine4SingleChargeRule() {
        String[] datesArr = new String[]{
                "2013-01-15 06:00:00",  //8

                "2013-01-16 06:01:00", //13
                "2013-01-16 06:12:00",
                "2013-01-16 06:15:00",
                "2013-01-16 06:19:00",
                "2013-01-16 06:20:00",
                "2013-01-16 06:39:00",

                "2013-01-16 07:19:00", //18
//                "2013-01-16 07:40:00",

                "2013-01-16 08:20:00", //13
                "2013-01-16 08:50:00",
                "2013-01-16 08:59:00",

                "2013-01-17 06:23:27",   //8
        };
        return datesArr;
    }
}