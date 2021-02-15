package com.antocecere77.protobuf;

import com.antocecere77.models.Address;
import com.antocecere77.models.Car;
import com.antocecere77.models.Person;
import com.google.protobuf.Int32Value;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {

        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("main street")
                .setCity("Atlanta")
                .build();

        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2005)
                .build();

        List<Car> cars = new ArrayList<>();
        cars.add(civic);
        cars.add(accord);

        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(Int32Value.newBuilder().setValue(25).build())
                .setAddress(address)
                //.addCar(accord)
                //.addCar(civic)
                .addAllCar(cars)
                .build();

        System.out.println(sam);
    }
}
