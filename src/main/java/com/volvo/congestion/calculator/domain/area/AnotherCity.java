package com.volvo.congestion.calculator.domain.area;

import com.volvo.congestion.calculator.domain.rule.OtherTaxRule;
import com.volvo.congestion.calculator.domain.rule.TaxRule;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.List;

/**
 * a demo city object which use TimeTableRepository to load timetable rule
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@DiscriminatorValue("2")
public class AnotherCity extends City{
    @Transient
    TaxRuleTableRepository repository;

    public AnotherCity() {
        this.type = CityType.AnotherCity;
    }

    public void setRepository(TaxRuleTableRepository repository) {
        this.repository = repository;
    }

    @Override
    public int getMaximumAmountPerDay() {
        return 900;
    }

    @Override
    public TaxRule getTaxRule() {
        return new OtherTaxRule(this);
    }

    @Override
    public int getTollFeeOfTime(int hour, int minute) {
        List<TaxRuleTable> taxRuleTableList = repository.findByCity(CityType.AnotherCity);
        int totalFee=0;
        for(TaxRuleTable timetable: taxRuleTableList){
            if (hour==timetable.getHour()) {
                if (minute>=timetable.getMinuteFrom() && minute<= timetable.getMinuteTo()){
                    totalFee = timetable.getFee();
                    break;
                }
            }
        }
        return totalFee;
    }
}
