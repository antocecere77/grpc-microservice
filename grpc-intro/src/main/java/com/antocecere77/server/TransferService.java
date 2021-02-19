package com.antocecere77.server;

import com.antocecere77.models.TransferRequest;
import com.antocecere77.models.TransferResponse;
import com.antocecere77.models.TransferServiceGrpc;
import io.grpc.stub.StreamObserver;

public class TransferService extends TransferServiceGrpc.TransferServiceImplBase {

    @Override
    public StreamObserver<TransferRequest> transfer(StreamObserver<TransferResponse> responseObserver) {
        return new TransferStreamingRequest(responseObserver);
    }
}
