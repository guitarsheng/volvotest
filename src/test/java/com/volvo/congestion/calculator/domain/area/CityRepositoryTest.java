package com.volvo.congestion.calculator.domain.area;

import com.volvo.congestion.VolvoTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {VolvoTestApplication.class})
public class CityRepositoryTest {

    @Autowired
    CityRepository cityRepository;

    @Test
    public void findOneByType() {
        City gothenburg = cityRepository.findOneByType(CityType.Gothenburg);
        assertTrue(gothenburg instanceof Gothenburg);
        City anotherCity = cityRepository.findOneByType(CityType.AnotherCity);
        assertTrue(anotherCity instanceof AnotherCity);
    }

    @Test
    public void findAll() {
        List<City> all = cityRepository.findAll();
        assertTrue(all.get(0) instanceof Gothenburg);
        assertTrue(all.get(1) instanceof AnotherCity);
    }
}