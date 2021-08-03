package com.volvo.congestion.calculator.domain.area;

import com.volvo.congestion.calculator.domain.rule.TaxRule;

import java.util.Date;

/**
 * represent a City which defined various rule for calculate toll fee to meet requirement that
 * the same application should be used in other cities with different tax rules
 *
 * @author Guitar
 * @version 0.1
 */
public interface Area {
    /**
     * calculate toll fee of a given date for a specific area
     *
     * @param   date  a date time for calculation
     * @return  calculation result of toll fee
     * */
    int getTollFeeOfDate(Date date);

    /**
     * get maximum amount fee per day for a specific area
     *
     * @return amount of fee for specific area
     */
    int getMaximumAmountPerDay();

    /**
     * get a TaxRule applied for this area. For example, Gothenburg will apply SingleChargeRule,etc
     *
     * @return TaxRule object
     */
    TaxRule getTaxRule();
}
