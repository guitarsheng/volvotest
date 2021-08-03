package com.volvo.congestion.calculator.domain.area;

import com.volvo.congestion.calculator.domain.rule.SingleChargeRule;
import com.volvo.congestion.calculator.domain.rule.TaxRule;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * a concrete city class called "Gothenburg" which defined different
 * rule for calculate toll fee
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@Slf4j
@DiscriminatorValue("1")
public class Gothenburg extends City {
    public Gothenburg() {
        this.type = CityType.Gothenburg;
    }

    @Override
    public int getMaximumAmountPerDay() {
        //In Gothenburg, The maximum amount per day and vehicle is 60 SEK.
        return 60;
    }

    @Override
    public TaxRule getTaxRule() {
        //Hours and amounts for congestion tax in Gothenburg. A single charge rule applies in Gothenburg.
        //Under this rule, a vehicle that passes several tolling stations within 60 minutes is only taxed once.
        //The amount that must be paid is the highest one.
        return new SingleChargeRule(this);
    }

    @Override
    public int getTollFeeOfTime(int hour, int minute) {
        int result;
             if (hour == 6  && minute >= 0  && minute <= 29) result = 8;
        else if (hour == 6  && minute >= 30 && minute <= 59) result = 13;
        else if (hour == 7  && minute >= 0  && minute <= 59) result = 18;
        else if (hour == 8  && minute >= 0  && minute <= 29) result = 13;
        else if (hour == 8  && minute >= 30 && minute <= 59) result = 8;
        else if (hour == 9  && minute >= 0  && minute <= 59) result = 8;
        else if (hour == 10 && minute >= 0  && minute <= 59) result = 8;
        else if (hour == 11 && minute >= 0  && minute <= 59) result = 8;
        else if (hour == 12 && minute >= 0  && minute <= 59) result = 8;
        else if (hour == 13 && minute >= 0  && minute <= 59) result = 8;
        else if (hour == 14 && minute >= 0  && minute <= 59) result = 8;
        else if (hour == 15 && minute >= 0  && minute <= 29) result = 13;
        else if (hour == 15 && minute >= 30 && minute <= 59) result = 18;
        else if (hour == 16 && minute >= 0  && minute <= 59) result = 18;
        else if (hour == 17 && minute >= 0  && minute <= 59) result = 13;
        else if (hour == 18 && minute >= 0  && minute <= 29) result = 8;
        else if (hour == 18 && minute >= 30 && minute <= 59) result = 0;
        else result = 0;
//        log.debug("hour={}, minute={}, result={}", hour, minute, result);
        return result;
    }
}
