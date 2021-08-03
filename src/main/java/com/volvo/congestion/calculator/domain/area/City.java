package com.volvo.congestion.calculator.domain.area;

import com.volvo.congestion.calculator.domain.rule.TaxRule;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * an abstract class which implement Area interface for represent any city
 *
 * @author Guitar
 * @version 0.1
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "city")
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.INTEGER, length = 1)
@DiscriminatorValue("0")
public abstract class City implements Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", unique = true)
    protected CityType type;

    /**
     * get maximum amount fee per day for a specific area
     *
     * @return amount of fee for specific area
     */
    public abstract int getMaximumAmountPerDay();

    /**
     * get a TaxRule applied for this area. For example, Gothenburg will apply SingleChargeRule,etc
     *
     * @return TaxRule object
     */
    public abstract TaxRule getTaxRule();

    /**
     * an abstract method for calculate toll fee of a given datetime for a specific area
     * need to be implemented by concrete class
     *
     * @param hour   hour number
     * @param minute minute number
     * @return calculation result of toll fee
     */
    public abstract int getTollFeeOfTime(int hour, int minute);

    //check if a specific date is toll free
    private Boolean isTollFreeDate(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        int year = calender.get(Calendar.YEAR);
        int month = calender.get(Calendar.MONTH) + 1;
        int day = calender.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = calender.get(Calendar.DAY_OF_MONTH);

        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) return true;
        //You may limit the scope to the year 2013
        if (year == 2013) {
            if (isTollFreeDateFor2013(month, dayOfMonth))
                return true;
        }
        return false;
    }

    //The tax is not charged on weekends (Saturdays and Sundays), public holidays, days before a public holiday and during the month of July.
    private boolean isTollFreeDateFor2013(int month, int dayOfMonth) {
        if (
                (month == 1 && dayOfMonth == 1) ||
                (month == 3 && (dayOfMonth == 28 || dayOfMonth == 29)) ||
                (month == 4 && (dayOfMonth == 1 || dayOfMonth == 30)) ||
                (month == 5 && (dayOfMonth == 1 || dayOfMonth == 8 || dayOfMonth == 9)) ||
                (month == 6 && (dayOfMonth == 5 || dayOfMonth == 6 || dayOfMonth == 21)) ||
                (month == 7) ||
                (month == 11 && dayOfMonth == 1) ||
                (month == 12 && (dayOfMonth == 24 || dayOfMonth == 25 || dayOfMonth == 26 || dayOfMonth == 31))) {
            return true;
        }
        return false;
    }

    @Override
    public int getTollFeeOfDate(Date date) {
        if (isTollFreeDate(date))
            return 0;
        return getTollFeeOfTime(date.getHours(), date.getMinutes());
    }
}
