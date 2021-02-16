package com.antocecere77.protobuf;

import com.antocecere77.models.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {

        Television television = Television.newBuilder()
                .setBrand("sony")
                .setYear(2015)
                .build();

        Path pathV1 = Paths.get("tv-v1");
        Files.write(pathV1, television.toByteArray());

        byte[] bytes = Files.readAllBytes(pathV1);
        System.out.println(Television.parseFrom(bytes));

    }
}
