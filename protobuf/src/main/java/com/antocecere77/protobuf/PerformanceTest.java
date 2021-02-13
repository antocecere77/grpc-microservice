package com.antocecere77.protobuf;

public class PerformanceTest {

    public static void main(String[] args) {

        //json
        Runnable runnable1;

        //protobuf
        Runnable runnable2;
    }

    public static void runPerformanceTest(Runnable runnable, String method) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method + " : " + (time2 - time1) + " ms");
    }
}
