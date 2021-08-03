package com.volvo.congestion.calculator.domain.area;

import lombok.Data;

import javax.persistence.*;

/**
 * a collection of pre-defined rule for calculate toll free for various city
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@Data
public class TaxRuleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int hour;
    private int minuteFrom;
    private int minuteTo;
    private int fee;
    @Enumerated(EnumType.ORDINAL)
    private CityType city;

    public TaxRuleTable() {
    }

    public TaxRuleTable(int hour, int minuteFrom, int minuteTo, int fee) {
        this.hour = hour;
        this.minuteFrom = minuteFrom;
        this.minuteTo = minuteTo;
        this.fee = fee;
    }

    public TaxRuleTable(int hour, int minuteFrom, int minuteTo, int fee, CityType city) {
        this.hour = hour;
        this.minuteFrom = minuteFrom;
        this.minuteTo = minuteTo;
        this.fee = fee;
        this.city = city;
    }
}
