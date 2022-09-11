package com.leonlg.grpc.client.unary;

import com.leon.grpc.user.UserInfoGrpc;
import com.leon.grpc.user.UserInfoResponse;
import com.leon.grpc.user.UserRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @date: 2022/9/9 11:24
 * @author: leon
 */
public class UserInfoClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899)
                //使用明文的方式展示出来
                .usePlaintext()
                .build();
        UserInfoGrpc.UserInfoBlockingStub blockingStub = UserInfoGrpc.newBlockingStub(channel);
        System.out.println("使用grpc调用了getUserInfo方法，这是普通的同步调用，没有用流");
        UserInfoResponse UserInfoResponse = blockingStub.getUserInfo(UserRequest.newBuilder().setAge(123).build());
        System.out.println(UserInfoResponse.getName());
        System.out.println(UserInfoResponse.getAge());
        System.out.println(UserInfoResponse.getGender());
    }
}
