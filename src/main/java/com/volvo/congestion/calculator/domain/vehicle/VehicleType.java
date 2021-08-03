package com.volvo.congestion.calculator.domain.vehicle;

public enum VehicleType {
    UnKnown(-1),

    Busses(1),
    Car(2),
    Diplomat(3),
    Emergency(4),
    Foreign(5),
    Military(6),
    Motorbike(7),
    Tractor(8),
    ;

    int num;
    VehicleType(int num) {
        this.num = num;
    }
}
