package com.volvo.congestion;

import com.volvo.congestion.calculator.domain.area.*;
import com.volvo.congestion.calculator.domain.vehicle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class VolvoTestApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(VolvoTestApplication.class, args);
    }

    @PostConstruct
    void setDefaultTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    @Autowired
    CityRepository cityRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    TaxRuleTableRepository taxRuleTableRepository;

    private void initData() {
        //init city data
        List<City> cities = new ArrayList<>();
        cities.add(new Gothenburg());
        AnotherCity anotherCity = new AnotherCity();
        anotherCity.setRepository(taxRuleTableRepository);
        cities.add(anotherCity);
        cityRepository.saveAll(cities);

        //init vehicle data
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Motorbike());
        vehicles.add(new Busses());
        vehicles.add(new Diplomat());
        vehicles.add(new Emergency());
        vehicles.add(new Foreign());
        vehicles.add(new Military());
        vehicles.add(new Tractor());
        vehicleRepository.saveAll(vehicles);

        //init tax rule table
        List<TaxRuleTable> tableConfigs = new ArrayList<>();
        tableConfigs.add(new TaxRuleTable(5, 0, 59, 10, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(6, 0, 20, 20, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(6, 21, 39, 10, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(6, 40, 59, 10, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(14, 0, 59, 30, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(15, 0, 59, 40, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(15, 0, 59, 5, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(16, 0, 59, 10, CityType.AnotherCity));
        tableConfigs.add(new TaxRuleTable(17, 0, 59, 10, CityType.AnotherCity));
        taxRuleTableRepository.saveAll(tableConfigs);
    }
}
