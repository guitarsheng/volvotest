package com.volvo.congestion.calculator.service.impl;

import com.volvo.congestion.calculator.domain.BusinessException;
import com.volvo.congestion.calculator.domain.CongestionTaxCalculator;
import com.volvo.congestion.calculator.domain.area.City;
import com.volvo.congestion.calculator.domain.area.CityRepository;
import com.volvo.congestion.calculator.domain.area.CityType;
import com.volvo.congestion.calculator.domain.vehicle.Vehicle;
import com.volvo.congestion.calculator.domain.vehicle.VehicleRepository;
import com.volvo.congestion.calculator.domain.vehicle.VehicleType;
import com.volvo.congestion.calculator.service.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * an implementation of TaxCalculatorService
 *
 * @author Guitar
 * @version 0.1
 */
@Service
@Slf4j
public class TaxCalculatorServiceImpl implements TaxCalculatorService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public int calculatorCongestionTax(CityType cityType, VehicleType vehicleType, Date[] dates) throws BusinessException, SystemException{
        try{
            City city = cityRepository.findOneByType(cityType);
            if (city==null)
                throw new BusinessException("city["+cityType+"] cannot be found");
            Vehicle vehicle = vehicleRepository.findOneByType(vehicleType);
            if (vehicle==null)
                throw new BusinessException("vehicle["+vehicleType+"] cannot be found");
            if (dates==null || dates.length==0)
                throw new BusinessException("time line dates should be provided");
            return CongestionTaxCalculator.calculateTax(city, vehicle, dates);
        }catch (PersistentObjectException e){
            log.error("calculatorCongestionTax db error {}", e);
            throw new SystemException("db error", e);
        }catch (BusinessException e){
            throw e;
        }catch (Exception e){
            log.error("calculatorCongestionTax other error {}", e);
            throw new SystemException("unknown error", e);
        }
    }
}
