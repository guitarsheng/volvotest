package com.volvo.congestion.calculator.domain.rule;

import com.volvo.congestion.calculator.domain.area.Area;

/**
 * an abstract class of TaxRule which hold an Area field for delegate calculation logic
 *
 * @author Guitar
 * @version 0.1
 */
public abstract class AbstractTaxRule implements TaxRule{

    //an Area which applied TaxRule
    protected Area area;

    public AbstractTaxRule(Area area) {
        this.area = area;
    }
}
