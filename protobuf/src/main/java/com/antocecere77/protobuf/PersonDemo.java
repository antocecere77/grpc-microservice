package com.antocecere77.protobuf;

import com.antocecere77.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {

    public static void main(String[] args) throws IOException {
        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(18)
                .build();

        Path path = Paths.get("sam.ser");
        Files.write(path, sam.toByteArray());

        byte[] bytes = Files.readAllBytes(path);
        Person newSam = Person.parseFrom(bytes);

        System.out.println(newSam);
    }
}
