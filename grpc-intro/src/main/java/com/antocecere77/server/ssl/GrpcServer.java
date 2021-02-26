package com.antocecere77.server.ssl;

import com.antocecere77.server.loadbalancing.BankService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.shaded.io.netty.util.NettyRuntime;

import java.io.File;
import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        SslContext context = GrpcSslContexts.configure(
                SslContextBuilder.forServer(
                        new File("D:\\Project\\Udemy\\grpc-java-course\\ssl-tls\\localhost.crt"),
                        new File("D:\\Project\\Udemy\\grpc-java-course\\ssl-tls\\localhost.pem")
                )).build();

        Server server = NettyServerBuilder.forPort(6565)
                .sslContext(context)
                .addService(new BankService())
                .build();

        server.start();
        server.awaitTermination();
    }
}
