package com.antocecere77.protobuf;

import com.antocecere77.models.Person;

public class PersonDemo {

    public static void main(String[] args) {
        Person sam1 = Person.newBuilder()
                .setName("sam")
                .setAge(18)
                .build();

        Person sam2 = Person.newBuilder()
                .setName("sam")
                .setAge(18)
                .build();

        System.out.println(sam1);

        System.out.println(sam1.equals(sam2));
    }
}
