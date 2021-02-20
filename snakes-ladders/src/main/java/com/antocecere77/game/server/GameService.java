package com.antocecere77.game.server;

import com.antocecere77.models.Die;
import com.antocecere77.models.GameServiceGrpc;
import com.antocecere77.models.GameState;
import com.antocecere77.models.Player;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceGrpc.GameServiceImplBase {

    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        Player client = Player.newBuilder()
                .setName("client")
                .setPosition(0)
                .build();

        Player server = Player.newBuilder()
                .setName("server")
                .setPosition(0)
                .build();

        return new DieStreamingRequest(client, server, responseObserver);
    }
}
