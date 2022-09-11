package com.leonlg.grpc.client.bidirectionalStreaming;

import com.leon.grpc.user.UserInfoGrpc;
import com.leon.grpc.user.UserInfoResponse;
import com.leon.grpc.user.UserRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @date: 2022/9/9 16:12
 * @author: leon
 */
public class BidirectionStreaming {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext()
                .build();
        UserInfoGrpc.UserInfoStub stub = UserInfoGrpc.newStub(channel);
        StreamObserver<UserRequest> response = stub.getUserInfoListByUserList(new StreamObserver<UserInfoResponse>() {
            @Override
            public void onNext(UserInfoResponse userInfoResponse) {
                System.out.print(userInfoResponse.getAge() + " ");
                System.out.print(userInfoResponse.getName() + " ");
                System.out.println(userInfoResponse.getGender());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("grpc completed !!!");
            }
        });
        for(int i = 0; i < 5 ; i++){
            response.onNext(UserRequest.newBuilder().setAge(i * 10).build());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        response.onCompleted();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
