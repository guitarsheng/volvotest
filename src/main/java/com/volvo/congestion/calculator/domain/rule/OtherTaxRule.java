package com.volvo.congestion.calculator.domain.rule;

import com.volvo.congestion.calculator.domain.area.Area;

import java.util.Date;

/**
 * an demo TaxRule for testing purpose, just accumulate all toll fee
 *
 * @author Guitar
 * @version 0.1
 */
public class OtherTaxRule extends AbstractTaxRule {
    public OtherTaxRule(Area area) {
        super(area);
    }

    @Override
    public int calculateFeeDuringDates(Date[] dates) {
        int totalFee = 0;
        for(Date date:dates){
            int nextFee = area.getTollFeeOfDate(date);
            totalFee += nextFee;
        }
        return totalFee;
    }
}
