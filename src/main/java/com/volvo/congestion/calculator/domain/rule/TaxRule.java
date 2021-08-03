package com.volvo.congestion.calculator.domain.rule;

import java.util.Date;

/**
 * an interface represent same feature of different tax rule object
 * the same application should be used in other cities with different tax rules
 *
 * @author Guitar
 * @version 0.1
 */
public interface TaxRule {
    /**
     * calculate total fee during given time line
     *
     * @param dates  list of date time for calculate toll free
     * @return total fee calculated
     */
    int calculateFeeDuringDates(Date[] dates);
}
