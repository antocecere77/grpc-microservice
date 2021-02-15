package com.antocecere77.protobuf;

import com.antocecere77.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        Person person = Person.newBuilder().build();

        System.out.println("City: " + person.getAddress().getCity());
        System.out.println("City: " + person.hasAddress());
    }
}
