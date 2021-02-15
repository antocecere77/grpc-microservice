package com.antocecere77.protobuf;

import com.antocecere77.models.BodyStyle;
import com.antocecere77.models.Car;
import com.antocecere77.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {
        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .setBodyStyle(BodyStyle.COUPE)
                .build();

        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2005)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2005, civic)
                .putModel(2020, accord)
                .build();

        System.out.println(dealer.getModelOrThrow(2005));
        System.out.println(dealer.getModelOrDefault(2019, accord));

        System.out.println(dealer.getModelMap());

        System.out.println(dealer.getModelOrThrow(2005).getBodyStyle());
        System.out.println(dealer.getModelOrThrow(2020).getBodyStyle());
    }
}
