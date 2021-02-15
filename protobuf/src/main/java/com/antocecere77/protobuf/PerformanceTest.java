package com.antocecere77.protobuf;

import com.antocecere77.json.JPerson;
import com.antocecere77.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) {

        JPerson person = new JPerson();
        person.setName("sam");
        person.setAge(10);
        ObjectMapper mapper = new ObjectMapper();

        //json
        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        //protobuf
        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(Int32Value.newBuilder().setValue(25).build())
                .build();

        Runnable protobuf = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                Person sam1 = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            runPerformanceTest(json, "JSON");
            runPerformanceTest(protobuf, "PROTO");
        }

    }

    public static void runPerformanceTest(Runnable runnable, String method) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method + " : " + (time2 - time1) + " ms");
    }
}
