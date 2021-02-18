package com.antocecere77.client;

import com.antocecere77.models.Balance;
import com.antocecere77.models.BalanceCheckRequest;
import com.antocecere77.models.BankServiceGrpc;
import com.antocecere77.models.WithdrawRequest;
import com.antocecere77.server.BankService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {

    private BankServiceGrpc.BankServiceBlockingStub blockingStub;

    @BeforeAll
    public void setup() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext()
                .build();

        this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
    }

    @Test
    public void balanceTest() {
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder()
                .setAccountNumber(2)
                .build();
        Balance balance = this.blockingStub.getBalance(balanceCheckRequest);

        System.out.println("Received: " + balance.getAmount());
    }

    @Test
    public void withdrawTest() {
        WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder()
                .setAccountNumber(7)
                .setAmount(40)
                .build();

        this.blockingStub.withdraw(withdrawRequest)
                .forEachRemaining(money -> System.out.println("Received " + money.getValue()));
    }
}
