package com.antocecere77.game.client;

import com.antocecere77.models.Die;
import com.antocecere77.models.GameState;
import com.antocecere77.models.Player;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.StreamObservers;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class GameStateStreamingResponse implements StreamObserver<GameState> {

    private CountDownLatch latch;
    private StreamObserver<Die> dieStreamObserver;

    public GameStateStreamingResponse(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onNext(GameState gameState) {
        List<Player> list = gameState.getPlayerList();
        list.forEach(p -> System.out.println(p.getName() + ":" + p.getPosition()));
        boolean isGameOver = list.stream().anyMatch(p -> p.getPosition() == 100);
        if(isGameOver) {
            System.out.println("Game Over!");
            this.dieStreamObserver.onCompleted();
        } else {
            this.roll();
        }
        System.out.println("--------------------------------------");
    }

    @Override
    public void onError(Throwable throwable) {
        this.latch.countDown();
    }

    @Override
    public void onCompleted() {
        this.latch.countDown();
    }

    public void setDieStreamObserver(StreamObserver<Die> streamObserver) {
        this.dieStreamObserver = streamObserver;
    }

    public void roll() {
        int dieValue = ThreadLocalRandom.current().nextInt(1, 7);
        Die die = Die.newBuilder().setValue(dieValue).build();
        this.dieStreamObserver.onNext(die);
    }
}
