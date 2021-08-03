package com.volvo.congestion.calculator.domain.area;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class CityTest {
    City city;
    SimpleDateFormat simpleDateFormat;

    @Before
    public void setUp() throws Exception {
        city = new Gothenburg();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }

    @Test
    public void getTollFeeOfDateWithin60Minutes() throws Exception {
        //8
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-15 06:00:00")));
        //13
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 06:01:00")));
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 06:12:00")));
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 06:15:00")));
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 06:19:00")));
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 06:20:00")));
        assertEquals(13, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 06:39:00")));
        //18
        assertEquals(18, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 07:19:00")));
        assertEquals(18, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 07:40:00")));
        //13
        assertEquals(13, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 08:20:00")));
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 08:50:00")));
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-16 08:59:00")));
        //8
        assertEquals(8, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-17 06:23:27")));
    }

    @Test
    public void getTollFeeOfWeekend() throws Exception {
        //test weekend
        assertEquals(0, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-12 06:01:00")));//Saturday
        assertEquals(0, city.getTollFeeOfDate(simpleDateFormat.parse("2013-01-13 06:01:00")));//Sunday
    }

    @Test
    public void getTollFeeOfPublicHoliday() throws Exception {
        //test public holidays
        assertEquals(0, city.getTollFeeOfDate(simpleDateFormat.parse("2013-05-01 06:01:00")));//Labor day
        assertEquals(0, city.getTollFeeOfDate(simpleDateFormat.parse("2013-06-01 06:01:00")));//Children day
    }

    @Test
    public void getTollFeeOfHolidayInJuly() throws Exception {
        //test days before a public holiday and during the month of July
        assertEquals(0, city.getTollFeeOfDate(simpleDateFormat.parse("2013-07-01 06:01:00")));
        assertEquals(0, city.getTollFeeOfDate(simpleDateFormat.parse("2013-07-13 06:01:00")));
    }

    @Test
    public void testDateTime() throws Exception {
        Date date = simpleDateFormat.parse("2013-06-01 06:01:00");
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);

        assertEquals(2013, calender.get(Calendar.YEAR));
        assertEquals(6, calender.get(Calendar.MONTH) + 1); //index of month is start from 0, so need to add 1
        assertEquals(7, calender.get(Calendar.DAY_OF_WEEK));//Saturday
        assertEquals(1, calender.get(Calendar.DAY_OF_MONTH));

        assertEquals(6, date.getHours());
        assertEquals(1, date.getMinutes());
    }
}