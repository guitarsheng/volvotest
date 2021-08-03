package com.volvo.congestion.calculator.domain.rule;

import com.volvo.congestion.calculator.domain.area.Area;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A single charge rule applies in Gothenburg. Under this rule,
 * a vehicle that passes several tolling stations within 60 minutes is only taxed once.
 * The amount that must be paid is the highest one.
 *
 * @author Guitar
 * @version 0.1
 */
@Slf4j
public class SingleChargeRule extends AbstractTaxRule {

    public SingleChargeRule(Area area) {
        super(area);
    }

    @Override
    public int calculateFeeDuringDates(Date[] dates) {
        Date intervalStart = dates[0];//start time
        int totalFee = 0;//total amount of fee
        for (int i = 0; i < dates.length; i++) {
            log.debug("dates[i]={}", dates[i]);
            Date date = dates[i];
            int tempFee = area.getTollFeeOfDate(intervalStart);
            int nextFee = area.getTollFeeOfDate(date);
            log.debug("tempFee={},nextFee={}", tempFee, nextFee);
            long diffInMillis = date.getTime() - intervalStart.getTime();
            long minutes = diffInMillis / 1000 / 60;

            //a vehicle that passes several tolling stations within 60 minutes is only taxed once.
            // The amount that must be paid is the highest one.
            log.debug("minutes={}", minutes);
            if (minutes <= 60) {
                if (totalFee > 0){
                    totalFee -= tempFee;
                    log.debug("totalFee={},tempFee={} rollback tempFee", totalFee, tempFee);
                }
                if (nextFee >= tempFee){
                    tempFee = nextFee;
                    log.debug("tempFee={},nextFee={} compare save max to tempFee", tempFee, nextFee);
                }
                totalFee += tempFee;
                log.debug("totalFee={},tempFee={} accumulate tempFee", totalFee, tempFee);
            } else {
                totalFee += nextFee;
                log.debug("totalFee={},nextFee={} accumulate nextFee", totalFee, nextFee);
                intervalStart = date;
            }
        }
        return totalFee;
    }
}
