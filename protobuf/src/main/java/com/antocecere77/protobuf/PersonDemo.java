package com.antocecere77.protobuf;

import com.antocecere77.models.Person;

public class PersonDemo {

    public static void main(String[] args) {
        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(18)
                .build();

        System.out.println(sam);
    }
}
