package com.volvo.congestion.calculator.domain.area;

/**
 * enum type for represent different city
 *
 * @author Guitar
 * @version 0.1
 */
public enum CityType {
    NotExist(-1),//for testing purpose

    Gothenburg(1),
    AnotherCity(2),
    ;

    private int num;

    CityType(int num) {
        this.num = num;
    }
}
