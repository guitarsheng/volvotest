package com.volvo.congestion.calculator.domain.vehicle;

import com.volvo.congestion.VolvoTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {VolvoTestApplication.class})
public class VehicleRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    public void findAll(){
        List<Vehicle> all = vehicleRepository.findAll();
        assertTrue(all.get(0) instanceof Car);
        assertTrue(all.get(1) instanceof Motorbike);
        assertTrue(all.get(2) instanceof Busses);
        assertTrue(all.get(3) instanceof Diplomat);
        assertTrue(all.get(4) instanceof Emergency);
        assertTrue(all.get(5) instanceof Foreign);
        assertTrue(all.get(6) instanceof Military);
        assertTrue(all.get(7) instanceof Tractor);
    }

    @Test
    public void findOneByType() {
        Vehicle car = vehicleRepository.findOneByType(VehicleType.Car);
        assertTrue(car instanceof Car);

        Vehicle motorbike = vehicleRepository.findOneByType(VehicleType.Motorbike);
        assertTrue(motorbike instanceof Motorbike);

        Vehicle busses = vehicleRepository.findOneByType(VehicleType.Busses);
        assertTrue(busses instanceof Busses);

        Vehicle tractor = vehicleRepository.findOneByType(VehicleType.Tractor);
        assertTrue(tractor instanceof Tractor);
    }

    @Test
    public void isTollFreeVehicle() {
        List<Vehicle> all = vehicleRepository.findAll();
        assertTrue(all.get(0) instanceof Car);
        assertEquals(false, all.get(0).isTollFreeVehicle());

        assertTrue(all.get(1) instanceof Motorbike);
        assertEquals(true, all.get(1).isTollFreeVehicle());

        assertTrue(all.get(2) instanceof Busses);
        assertEquals(true, all.get(2).isTollFreeVehicle());

        assertTrue(all.get(3) instanceof Diplomat);
        assertEquals(true, all.get(3).isTollFreeVehicle());

        assertTrue(all.get(4) instanceof Emergency);
        assertEquals(true, all.get(4).isTollFreeVehicle());

        assertTrue(all.get(5) instanceof Foreign);
        assertEquals(true, all.get(5).isTollFreeVehicle());

        assertTrue(all.get(6) instanceof Military);
        assertEquals(true, all.get(6).isTollFreeVehicle());

        assertTrue(all.get(7) instanceof Tractor);
        assertEquals(false, all.get(0).isTollFreeVehicle());
    }
}