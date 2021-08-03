package com.volvo.congestion.calculator.domain.area;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository class for TaxRuleTable
 *
 * @author Guitar
 * @version 0.1
 */
@Repository
public interface TaxRuleTableRepository extends JpaRepository<TaxRuleTable, Integer> {
    List<TaxRuleTable> findByCity(CityType city);
}
