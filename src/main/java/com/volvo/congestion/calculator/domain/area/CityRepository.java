package com.volvo.congestion.calculator.domain.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository class for City
 *
 * @author Guitar
 * @version 0.1
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findOneByType(CityType type);
}
