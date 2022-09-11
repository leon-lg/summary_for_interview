package com.leonlg.grpc.client.serverStreaming;

import com.leon.grpc.user.UserInfoGrpc;
import com.leon.grpc.user.UserInfoResponse;
import com.leon.grpc.user.UserRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

/**
 * @date: 2022/9/9 16:00
 * @author: leon
 */
public class ServerStreaming {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext()
                .build();
        UserInfoGrpc.UserInfoBlockingStub stub = UserInfoGrpc.newBlockingStub(channel);
        Iterator<UserInfoResponse> response = stub.getUserInfoList(UserRequest.newBuilder().setAge(10).build());
        while(response.hasNext()){
            UserInfoResponse res = response.next();
            System.out.print(res.getName() + " ");
            System.out.print(res.getGender() + " ");
            System.out.print(res.getAge());
            System.out.println();
        }

        System.out.println("grpc completed!!!");
    }
}
