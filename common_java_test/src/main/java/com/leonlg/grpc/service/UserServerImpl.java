package com.leonlg.grpc.service;

import com.leon.grpc.user.UserInfoGrpc;
import com.leon.grpc.user.UserInfoResponse;
import com.leon.grpc.user.UserRequest;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/**
 * @date: 2022/9/9 11:00
 * @author: leon
 */
public class UserServerImpl extends UserInfoGrpc.UserInfoImplBase {

    public void getUserInfo(UserRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        System.out.println("收到客户端的请求参数age：" + request.getAge());

        responseObserver.onNext(UserInfoResponse.newBuilder().setAge(20).setName("小张").setGender(1).build());

        responseObserver.onCompleted();
        System.out.println("服务端发送信息完成！！！");
    }

    public StreamObserver<UserRequest> getUserInfoByUserList(StreamObserver<UserInfoResponse> responseObserver) {
        return new StreamObserver<UserRequest>() {
            @Override
            public void onNext(UserRequest userRequest) {
                System.out.println("the age from client is : " + userRequest.getAge());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(UserInfoResponse.newBuilder().setAge(20).setName("xiao wang").setGender(1).build());

                responseObserver.onCompleted();
            }
        };
    }

    public void getUserInfoList(UserRequest request, StreamObserver<UserInfoResponse> responseObserver) {
        System.out.println("the age from client is :" + request);

        for(int i = 0 ;i < 3; i++){
            responseObserver.onNext(UserInfoResponse.newBuilder().setAge(i * 10).setName("xiao wang" + i).setGender(1).build());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        responseObserver.onCompleted();
    }

    public StreamObserver<UserRequest> getUserInfoListByUserList(StreamObserver<UserInfoResponse> responseObserver) {
        int i = 0;
        return new StreamObserver<UserRequest>() {
            @Override
            public void onNext(UserRequest userRequest) {
                System.out.println("the age from client is :" + userRequest.getAge());
                int temp = (int)(Math.random() * 100);
                responseObserver.onNext(UserInfoResponse.newBuilder().setAge((int)(Math.random() * 100)).setGender(1).setName((int)(Math.random() * 100) + "").build());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
