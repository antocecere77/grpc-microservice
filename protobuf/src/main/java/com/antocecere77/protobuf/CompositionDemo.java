package com.antocecere77.protobuf;

import com.antocecere77.models.Address;
import com.antocecere77.models.Car;
import com.antocecere77.models.Person;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("main street")
                .setCity("Atlanta")
                .build();

        Car car = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(25)
                .setAddress(address)
                .setCar(car)
                .build();

        System.out.println(sam);
    }
}
